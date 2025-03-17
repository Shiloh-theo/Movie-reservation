package shiloh.movie.reservation.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shiloh.movie.reservation.model.Movies;
import shiloh.movie.reservation.repositories.MovieRepository;
import shiloh.movie.reservation.repositories.ReservationRepository;
import shiloh.movie.reservation.repositories.ShowtimesRepository;

@Service
public class MovieService {

    @Autowired
    MovieRepository repo;
    
    @Autowired
    ReservationRepository reservationRepo;

    @Autowired
    ShowtimesRepository showtimeRepo;

    public Movies addMovie(Movies movie) {
        return repo.save(movie);
    }

    public List<Movies> getMovies() {
        return repo.findAll();
    }

    public String deleteMovie(Integer id) {
        reservationRepo.deleteById(id);
        repo.deleteById(id);
        return "successfully deleted";
    }

    public Movies updateMovie(Movies movie) {
        return repo.save(movie);
    }

    public Optional<Movies> findMovie(Integer id) {
        return repo.findById(id);
    }

    public Optional<Movies> searchById(Integer movieId) {
        return repo.findById(movieId);
    }

    public List<Movies> searchByTitle(String title) {
        return repo.findByTitleContainingIgnoreCase(title);
    }

    public List<Movies> searchByGenre(String genre) {
        return repo.findByGenreContainingIgnoreCase(genre);
    }

    public List<Movies> searchByTime(String time) {
        try {
            
              System.out.println("Received time: " + time); // Debugging log

             // Ensure time is properly parsed
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime parsedTime = LocalTime.parse(time, formatter);
        
         String formattedTime = parsedTime.format(formatter);
        System.out.println("Parsed time: " + parsedTime);
        
            LocalTime localTime = LocalTime.parse(time);
            return showtimeRepo.findByTime(localTime);
        } catch (Exception e) {
            throw new RuntimeException("Invalid time format. Expected format: HH:mm:ss");
        }
    }

    public List<Movies> searchByDate(String date) {
        try {
            
              System.out.println("Received date: " + date); // Debugging log

                    // Ensure time is properly parsed
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalTime parsedDate = LocalTime.parse(date, formatter);
        
        System.out.println("Parsed time: " + parsedDate);
      
            LocalDate localDate = LocalDate.parse(date);
            return showtimeRepo.findByDate(localDate);
        } catch (Exception e) {
            throw new RuntimeException("Invalid date format. Expected format: YYYY-MM-DD");
        }
    }

    public List<Movies> getAllMovies() {
        return repo.findAll();
    }
}
