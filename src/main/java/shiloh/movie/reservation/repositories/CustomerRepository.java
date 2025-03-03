
package shiloh.movie.reservation.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shiloh.movie.reservation.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    
    public Customer findByUsername(String username);
}
