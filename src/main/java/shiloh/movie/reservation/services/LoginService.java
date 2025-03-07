package shiloh.movie.reservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import shiloh.movie.reservation.model.Administrator;
import shiloh.movie.reservation.model.Customer;
import shiloh.movie.reservation.repositories.AdminRepository;
import shiloh.movie.reservation.repositories.CustomerRepository;

@Service
public class LoginService {

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    JWTService jwtService;

    @Autowired
    CustomerRepository customerRepo;

    @Autowired
    AdminRepository adminRepo;

    public String login(String username, String password) {
    try {
        // Check if the user exists in the Customer table
        Customer customer = customerRepo.findByUsername(username);
        if (customer != null) {
            Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
            );

            if (auth.isAuthenticated()) {
                return jwtService.generateToken(username, "CUSTOMER");
            }
            throw new AuthenticationException("Invalid credentials for Customer") {};
        }

        // If not a Customer, check the Administrator table
        Administrator admin = adminRepo.findByUsername(username);
        if (admin != null) {
            Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
            );

            if (auth.isAuthenticated()) {
                return jwtService.generateToken(username, "ADMIN");
            }
            throw new AuthenticationException("Invalid credentials for Administrator") {};
        }

        // If neither Customer nor Administrator, throw an error
        throw new UsernameNotFoundException("Username not found in Customer or Administrator tables");

    } catch (AuthenticationException e) {
        return "Authentication failed: " + e.getMessage();
    }
}

}
