package shiloh.movie.reservation.services;

import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shiloh.movie.reservation.model.Customer;
import shiloh.movie.reservation.model.Movies;
import shiloh.movie.reservation.repositories.CustomerRepository;
import shiloh.movie.reservation.repositories.MovieRepository;
import shiloh.movie.reservation.repositories.ReservationRepository;
import shiloh.movie.reservation.model.Reservations;

@Service
public class ReservationService {

    @Autowired
    ReservationRepository repo;

//    @Autowired
//    Reservations reservations;
    @Autowired
    CustomerRepository customerRepo;

    @Autowired
    MovieRepository movieRepo;

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

        // Fetch only the customer ID
        Customer customer = customerRepo.findByUsername(username);
        if (customer == null) {
            throw new RuntimeException("Customer not found for username: " + username);
        } else {
            reservation.setUsername(username);
        }

        // Fetch Movie entity using movie ID from reservation
        Movies movie = movieRepo.findById(reservation.getMovie().getMovie_id())
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        // Set Customer ID and Movie in reservation
        reservation.setCustomer(customer); // Only storing customer_id
        reservation.setMovie(movie);

        // Save and return reservation
        return repo.save(reservation);
    }

    public List<Reservations> checkReservations(HttpServletRequest request) {
        String username = extractUsername(request);
//        reservation = repo.findAllByUsername(username);
//
//        Reservation reservation = null;
//        
//        repo.findByUsername(username);
//        String movie = reservation.getMovie().toString();
        return repo.findAllByUsername(username); 
    }

    public Reservations updateReservation(Reservations reservation, HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
