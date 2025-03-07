
package shiloh.movie.reservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import shiloh.movie.reservation.services.LoginRequest;
import shiloh.movie.reservation.services.LoginService;


@RestController
public class LoginController {
    
    @Autowired
    LoginService service;
    
//    @Autowired
//    Login
    
    @PostMapping("login")
    public String login(@RequestBody LoginRequest request){
        return service.login(request.getUsername(), request.getPassword());
    }
    
    @GetMapping("home")
    public String home(){
        return "this is the homepage";
    }
}
