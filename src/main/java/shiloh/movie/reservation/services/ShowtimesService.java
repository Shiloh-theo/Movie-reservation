package shiloh.movie.reservation.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shiloh.movie.reservation.model.Movies;
import shiloh.movie.reservation.model.Showtimes;
import shiloh.movie.reservation.repositories.MovieRepository;
import shiloh.movie.reservation.repositories.ShowtimesRepository;

@Service
public class ShowtimesService {

    @Autowired
    ShowtimesRepository repo;

    @Autowired
    MovieRepository movieRepo;

    public Showtimes addShowtime(Showtimes showtime) {

        Movies movie = movieRepo.findById(showtime.getMovie_id())
                .orElseThrow(() -> new RuntimeException("movie not found"));

        showtime.setMovies(movie);

        return repo.save(showtime);
    }

    public Showtimes editShowtime(Showtimes showtime) {
        
        Movies movie = movieRepo.findById(showtime.getMovie_id())
                .orElseThrow(() -> new RuntimeException("movie not found"));

        showtime.setMovies(movie);
        
        return repo.save(showtime);
    }

    public String deleteShowtime(int id) {

        repo.deleteById(id);
        return "successful";
    }

    public List<Showtimes> getShowtime() {

        return repo.findAll();
    }

}
