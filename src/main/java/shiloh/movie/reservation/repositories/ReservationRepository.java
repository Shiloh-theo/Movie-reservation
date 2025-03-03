package shiloh.movie.reservation.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shiloh.movie.reservation.model.Reservations;

@Repository
public interface ReservationRepository extends JpaRepository<Reservations, Integer>{
    public Reservations findByUsername(String username);
    public List<Reservations> findAllByUsername(String username);
}
