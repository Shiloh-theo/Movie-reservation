package shiloh.movie.reservation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;

@Entity
public class Reservations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reservation_id;

    private int seat_no;
    private String username;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "showtime_Id", referencedColumnName = "showtimeId")
    private Showtimes showtimes;

    @Transient // This field won't be stored in the database
    private Integer showtime_id; // Accepts showtime_id directly from request

    public int getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(int reservation_id) {
        this.reservation_id = reservation_id;
    }

    public int getSeat_no() {
        return seat_no;
    }

    public void setSeat_no(int seat_no) {
        this.seat_no = seat_no;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Showtimes getShowtimes() {
        return showtimes;
    }

    public void setShowtimes(Showtimes showtimes) {
        this.showtimes = showtimes;
    }

    public Integer getShowtime_id() {
        return showtime_id;
    }

    public void setShowtime_id(Integer showtime_id) {
        this.showtime_id = showtime_id;
    }

    @Override
    public String toString() {
        return "Reservations{" + "username=" + username + '}';
    }
    
    
}
