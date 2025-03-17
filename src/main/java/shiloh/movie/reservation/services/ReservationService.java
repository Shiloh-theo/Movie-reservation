package shiloh.movie.reservation.services;

import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shiloh.movie.reservation.model.Customer;
import shiloh.movie.reservation.repositories.CustomerRepository;
import shiloh.movie.reservation.repositories.MovieRepository;
import shiloh.movie.reservation.repositories.ReservationRepository;
import shiloh.movie.reservation.model.Reservations;
import shiloh.movie.reservation.model.Showtimes;
import shiloh.movie.reservation.repositories.ShowtimesRepository;

@Service
public class ReservationService {

    @Autowired
    ReservationRepository repo;

    @Autowired
    CustomerRepository customerRepo;

    @Autowired
    MovieRepository movieRepo;

    @Autowired
    ShowtimesRepository showtimeRepo;

    @Autowired
    JWTService jwt;

    public String extractUsername(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        System.out.println(authHeader);
        String token;
        String username = null;

        if (authHeader != null && authHeader.startsWith("Bearer")) {
            token = authHeader.substring(7);
            username = jwt.extractUserName(token);
        }
        System.out.println("username: " + username);
        return username;
    }

    public Reservations reserveMovie(Reservations reservation, HttpServletRequest request) {
    // Extract username from JWT token
    String username = extractUsername(request);

//    // Ensure seat number is provided
//    if (reservation.getSeat_no() == null) {
//        throw new RuntimeException("Seat number is required");
//    }

    // Ensure showtime ID is provided
    if (reservation.getShowtime_id() == null) {
        throw new RuntimeException("Showtime ID is required");
    }

    Integer showtimeId = reservation.getShowtime_id();

    // Fetch taken seats for the showtime
    List<Integer> seatsTaken = getTakenSeats(showtimeId);
    if (seatsTaken.contains(reservation.getSeat_no())) {
        throw new RuntimeException("Seat with seat number " + reservation.getSeat_no() + " is already taken. Check for available seats.");
    }

    // Fetch Customer entity using username
    Customer customer = customerRepo.findByUsername(username);
    if (customer == null) {
        throw new RuntimeException("Customer not found for username: " + username);
    }

    reservation.setUsername(username);
    reservation.setCustomer(customer);

    // Fetch Showtimes entity using showtimeId
    Showtimes showtime = showtimeRepo.findById(showtimeId)
            .orElseThrow(() -> new RuntimeException("Showtime not found"));

    reservation.setShowtimes(showtime); // Manually set the Showtimes object

    // Save and return reservation
    return repo.save(reservation);
}


    public List<Reservations> checkReservations(HttpServletRequest request) {
        String username = extractUsername(request);

        return repo.findAllByUsername(username);
    }

    public Reservations updateReservation(Integer id, Reservations reservation, HttpServletRequest request) {
        // Extract the logged-in user's username
        String loggedUser = extractUsername(request);

        Customer customer = customerRepo.findByUsername(loggedUser);
        
        reservation.setCustomer(customer);
        reservation.setUsername(loggedUser);
        
        Showtimes showtime = showtimeRepo.findById(reservation.getShowtime_id())
                .orElseThrow(() -> new RuntimeException("Showtime not found"));

        reservation.setShowtimes(showtime);
        
        // Fetch the reservation to verify ownership
        Reservations reservations = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found for ID: " + id));

        // Get the username of the reservation owner
        String reservationUser = reservations.getUsername();

        if (loggedUser.equals(reservationUser)) {
            return repo.save(reservation);
        } else {
            throw new RuntimeException("Unauthorized: You can only edit your own reservations.");

        }
    }

    public String deleteReservation(Integer id, HttpServletRequest request) {
        // Extract the logged-in user's username
        String loggedUser = extractUsername(request);

        // Fetch the reservation to verify ownership
        Reservations reservation = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found for ID: " + id));

        // Get the username of the reservation owner
        String reservationUser = reservation.getUsername();

        // Check if the logged-in user is the owner
        if (!loggedUser.equals(reservationUser)) {
            throw new RuntimeException("Unauthorized: You can only delete your own reservations.");
        }

        // Delete reservation
        repo.deleteById(id);

        return "Reservation with ID " + id + " successfully deleted.";
    }

       public List<Integer> getTakenSeats(Integer showtimeId) {
        return repo.findTakenSeatsByShowtimeId(showtimeId);
    }
}
