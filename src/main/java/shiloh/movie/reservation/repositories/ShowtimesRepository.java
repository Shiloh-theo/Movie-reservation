package shiloh.movie.reservation.repositories;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import shiloh.movie.reservation.model.Movies;
import shiloh.movie.reservation.model.Showtimes;

@Repository
public interface ShowtimesRepository extends JpaRepository<Showtimes, Integer> {
    List<Movies> findByTime(LocalTime time);
    List<Movies> findByDate(LocalDate date);
    
    // Get all showtimes for a specific movie
    @Query("SELECT s FROM Showtimes s WHERE s.movies.movieId = :movieId")
    List<Showtimes> findByMovieId(@Param("movieId") int movieId);
}
