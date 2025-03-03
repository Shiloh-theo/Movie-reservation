package shiloh.movie.reservation.controllers;

import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import shiloh.movie.reservation.model.Reservations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import shiloh.movie.reservation.services.ReservationService;

@RestController
public class ReservationController {
    
    @Autowired
    ReservationService service;
    
    @PostMapping("reservemovie")
    public Reservations reserveMovie(@RequestBody Reservations reservation, HttpServletRequest request){
        
        return service.reserveMovie(reservation, request);
    }
    
    @GetMapping("checkreservations")
    public List<Reservations> checkReservations( HttpServletRequest request){
        return service.checkReservations(request);
    }
    
    @PutMapping("updatereservation/{id}")
    public Reservations updateReservation(@PathVariable Integer id, @RequestBody Reservations reservation, HttpServletRequest request){
       return service.updateReservation(reservation, request); 
    }
    
    @DeleteMapping("deletereservation/{id}")
    public String deleteReservation(){
        return service.deleteReservation();
    }
}
