package shiloh.movie.reservation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Movies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int movieId;
    String title;
    String description;
    String genre;
    LocalTime time;
    LocalDate date;

    public Movies(int movieId, String title, String description, String genre, LocalTime time, LocalDate date) {
        this.movieId = movieId;
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.time = time;
        this.date = date;
    }

    public Movies() {
    }

    public int getMovie_id() {
        return movieId;
    }

    public void setMovie_id(int movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalTime getLocalTime() {
        return time;
    }

    public void setLocalTime(LocalTime time) {
        this.time = time;
    }

    public LocalDate getLocalDate() {
        return date;
    }

    public void setLocalDate(LocalDate date) {
        this.date = date;
    }
    
    
}
