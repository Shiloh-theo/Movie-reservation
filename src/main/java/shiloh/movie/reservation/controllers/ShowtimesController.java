package shiloh.movie.reservation.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shiloh.movie.reservation.model.Showtimes;
import shiloh.movie.reservation.services.ShowtimesService;

@RestController
public class ShowtimesController {
    
    @Autowired
    ShowtimesService service;
    
    @PreAuthorize("hasAuthority('ADMIN')") 
    @PostMapping("addShowtime")
    public Showtimes addShowtime(@RequestBody Showtimes showtime){
        return service.addShowtime(showtime);
    }
    
    @PreAuthorize("hasAuthority('ADMIN')") 
    @PutMapping("editShowtime/{id}")
    public String editShowtime(@RequestBody Showtimes showtime, @PathVariable Integer id){
        return service.editShowtime(showtime, id);
    }
    
    @PreAuthorize("hasAuthority('ADMIN')") 
    @DeleteMapping("deleteShowtime/{id}")
    public String deleteMapping(@PathVariable Integer id){
        return service.deleteShowtime(id);
    }
    
    @GetMapping("showtimes")
    public List<Showtimes> getShowtimes(){
        return service.getShowtime();
    }
    
//    @GetMapping("search")
}
