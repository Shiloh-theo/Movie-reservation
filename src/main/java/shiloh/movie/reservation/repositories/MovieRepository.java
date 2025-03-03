package shiloh.movie.reservation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shiloh.movie.reservation.model.Movies;

@Repository
public interface MovieRepository extends JpaRepository<Movies, Integer> {
    
}
