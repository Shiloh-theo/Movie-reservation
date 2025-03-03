
package shiloh.movie.reservation.controllers;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shiloh.movie.reservation.model.Customer;
import shiloh.movie.reservation.services.SignupService;

@RestController
public class SignupController {
    
    @Autowired
    SignupService service;
    
    @RequestMapping("/signup")
    public Customer signup(@RequestBody Customer customer){
        return service.signup(customer);
    }
    
    @GetMapping("customer/{id}")
    public Optional<Customer> getCustomer(@PathVariable int id){
        return service.getCustomer(id);
    }
    
}
