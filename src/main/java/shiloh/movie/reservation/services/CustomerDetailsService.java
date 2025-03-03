
package shiloh.movie.reservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import shiloh.movie.reservation.model.Customer;
import shiloh.movie.reservation.model.CustomerDetails;
import shiloh.movie.reservation.repositories.CustomerRepository;

@Service
public class CustomerDetailsService implements UserDetailsService{
    
    @Autowired
    CustomerRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Customer customer = repo.findByUsername(username);
        if(customer == null){
            System.out.println("user not found");
            throw new UsernameNotFoundException("user not found");
        }
    
        return new CustomerDetails(customer);
    
    }
    
}
