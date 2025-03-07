//package shiloh.movie.reservation.services;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Primary;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import shiloh.movie.reservation.model.AdminDetails;
//import shiloh.movie.reservation.model.Administrator;
//import shiloh.movie.reservation.repositories.AdminRepository;
//
//@Service
////@Primary
//public class AdminDetailsService implements UserDetailsService{
//
//    @Autowired
//    AdminRepository repo;
//    
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//    Administrator admin = repo.findByUsername(username);
//    if(admin == null){
//        System.out.println("admin not found");
//        throw new UsernameNotFoundException("admin not found");
//    }
//    
//    return new AdminDetails(admin);
//    }
//    
//}
