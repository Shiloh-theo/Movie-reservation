package shiloh.movie.reservation.repositories;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shiloh.movie.reservation.model.Movies;

@Repository
public interface MovieRepository extends JpaRepository<Movies, Integer> {
    List<Movies> findByMovieId(Integer movieId);
    List<Movies> findByTitleContainingIgnoreCase(String title);
    List<Movies> findByGenreContainingIgnoreCase(String genre);
    List<Movies> findByTime(LocalTime time);
    List<Movies> findByDate(LocalDate date);
}
