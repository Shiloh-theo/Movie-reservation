package shiloh.movie.reservation.controllers;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shiloh.movie.reservation.model.Movies;
import shiloh.movie.reservation.services.MovieService;

@RestController
public class MoviesController {
    
    @Autowired
    MovieService service;
    
    
    @PostMapping("addmovie")
    public Movies addMovie(@RequestBody Movies movie){
        return service.addMovie(movie);
    }
    
    @GetMapping("movies")
    public List<Movies> getMovies(){
        return service.getMovies();
    }
    
    @DeleteMapping("deletemovie/{id}")
    public String deleteMovie(@PathVariable Integer id){
        return service.deleteMovie(id);
    }
    
    @GetMapping("moviebyid/{id}")
    public Optional<Movies> movieById(@PathVariable Integer id){
        return service.findMovie(id);
    }
    
    @PutMapping("updatemovie/{id}")
    public Movies updateMovie(@PathVariable Integer id, @RequestBody Movies movie){
     return service.updateMovie(movie); 
    }
    
     @GetMapping("search")
    public List<Movies> searchMovie(
            @RequestParam(required = false) Integer movie_id,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String genre,
            @RequestParam(required = false) String time,
            @RequestParam(required = false) String date) {

        // Check which parameter is provided and call the appropriate service method
        if (movie_id != null) {
            return service.searchById(movie_id);
        } else if (title != null) {
            return service.searchByTitle(title);
        } else if (genre != null) {
            return service.searchByGenre(genre);
        } else if (time != null) {
            return service.searchByTime(time);
        } else if (date != null) {
            return service.searchByDate(date);
        } else {
            return service.getMovies(); // Default case, return all movies
        }
    }
}
