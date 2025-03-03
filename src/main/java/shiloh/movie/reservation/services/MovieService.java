package shiloh.movie.reservation.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shiloh.movie.reservation.model.Movies;
import shiloh.movie.reservation.repositories.MovieRepository;

@Service
public class MovieService {

    @Autowired
    MovieRepository repo;

    public Movies addMovie(Movies movie) {

        return repo.save(movie);
    }

    public List<Movies> getMovies() {

        return repo.findAll();
    }

    public String deleteMovie(Integer id) {
        repo.deleteById(id);
        Optional<Movies> movie = repo.findById(id);
        String returnStmt = "Movie " + movie + " with id " + id + " successfully deleted";

        return returnStmt;
    }

    public Movies updateMovie( Movies movie) {
        return repo.save(movie);
    }

    public Optional<Movies> findMovie(Integer id) {
        return repo.findById(id);
    }

}
