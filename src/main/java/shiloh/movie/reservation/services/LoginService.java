package shiloh.movie.reservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;
import shiloh.movie.reservation.model.Customer;

@Service
public class LoginService {

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    JWTService jwtService;

    public String login(Customer customer) {
        try {
            Authentication auth = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(customer.getUsername(), customer.getPassword()));

            if (auth.isAuthenticated()) {
                return jwtService.generateToken(customer.getUsername());
            }
        }catch(AuthenticationException e){
            System.out.println("failed" + e.getMessage());
        }

        return "fail";
    }

}
