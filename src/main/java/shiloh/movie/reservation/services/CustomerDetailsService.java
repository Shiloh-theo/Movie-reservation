
package shiloh.movie.reservation.services;

import java.util.Collections;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import shiloh.movie.reservation.model.AdminDetails;
import shiloh.movie.reservation.model.Administrator;
import shiloh.movie.reservation.model.Customer;
import shiloh.movie.reservation.model.CustomerDetails;
import shiloh.movie.reservation.repositories.AdminRepository;
import shiloh.movie.reservation.repositories.CustomerRepository;

@Service
public class CustomerDetailsService implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepo;

    @Autowired
    private AdminRepository adminRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Check in Customer table
        Customer customer = customerRepo.findByUsername(username);
        if (customer != null) {
            return new CustomerDetails(customer);
        }

        // Check in Administrator table
        Administrator admin = adminRepo.findByUsername(username);
        if (admin != null) {
            return new AdminDetails(admin);
        }

        // If not found in either table, throw exception
        throw new UsernameNotFoundException("User not found in Customer or Administrator tables");
    }
}
