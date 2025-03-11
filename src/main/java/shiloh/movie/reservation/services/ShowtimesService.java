package shiloh.movie.reservation.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shiloh.movie.reservation.model.Showtimes;
import shiloh.movie.reservation.repositories.ShowtimesRepository;

@Service
public class ShowtimesService {
    
    @Autowired
    ShowtimesRepository repo;

    public Showtimes addShowtime(Showtimes showtime) {
    
        return repo.save(showtime);
    }

    public String editShowtime(Showtimes showtime, int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String deleteShowtime(int id) {
    
        repo.deleteById(id);
        return "successful";
    }

    public List<Showtimes> getShowtime() {
    
        return repo.findAll();
    }
    
}
