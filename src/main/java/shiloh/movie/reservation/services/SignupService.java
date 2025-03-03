
package shiloh.movie.reservation.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import shiloh.movie.reservation.model.Customer;
import shiloh.movie.reservation.repositories.CustomerRepository;

@Service
public class SignupService {
    
    @Autowired
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Autowired
    CustomerRepository repo;
    
    public Customer signup(Customer customer) {
        customer.setPassword(encoder.encode(customer.getPassword()));
    
        return repo.save(customer);
    }

    public Optional<Customer> getCustomer(int id) {
    
        return repo.findById(id);
    }
    
}
