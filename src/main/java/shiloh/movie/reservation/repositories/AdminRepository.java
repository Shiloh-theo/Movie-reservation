package shiloh.movie.reservation.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shiloh.movie.reservation.model.Administrator;

@Repository
public interface AdminRepository extends JpaRepository<Administrator, Integer>{
    public Administrator findByUsername(String username);
}
