package shiloh.movie.reservation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Showtimes {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int showtimeId;
    
    @ManyToOne
    @JoinColumn(name = "movieId", referencedColumnName = "movieId")
    private Movies movies;
    
    LocalTime time;
    LocalDate date;

    public Showtimes(int showtimeId, Movies movies, LocalTime time, LocalDate date) {
        this.showtimeId = showtimeId;
        this.movies = movies;
        this.time = time;
        this.date = date;
    }

    public Showtimes() {
    }

    public int getShowtimeId() {
        return showtimeId;
    }

    public void setShowtimeId(int showtimeId) {
        this.showtimeId = showtimeId;
    }

    public Movies getMovies() {
        return movies;
    }

    public void setMovies(Movies movies) {
        this.movies = movies;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    
}
