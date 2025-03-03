
package shiloh.movie.reservation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int Customer_id;
    String username;
    String email;
    String password;
    int age;

    public Customer(int Customer_id, String username, String email, String password, int age) {
        this.Customer_id = Customer_id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.age = age;
    }

    public Customer() {
    }

    public Customer(int Customer_id) {
        this.Customer_id = Customer_id;
    }
    
    

    public int getCustomer_id() {
        return Customer_id;
    }

    public void setCustomer_id(int Customer_id) {
        this.Customer_id = Customer_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
     
}
