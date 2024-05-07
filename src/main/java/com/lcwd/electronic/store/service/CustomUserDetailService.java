package com.lcwd.electronic.store.service;

//import com.lcwd.electronic.store.entites.User;
//import com.lcwd.electronic.store.exception.ResourceNotFoundException;
//import com.lcwd.electronic.store.repositories.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CustomUserDetailService implements UserDetailsService {
//    @Autowired
//    private UserRepository userRepository;
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//      User user = userRepository.findByEmail(username).orElseThrow(()->new ResourceNotFoundException("User with given email not found"));
//        return user;
//    }
//}






/* The error you're encountering indicates a type mismatch.
The loadUserByUsername method in the UserDetailsService interface expects a UserDetails object to be returned,
 but you're returning a User entity directly.
To resolve this issue, you need to convert your User entity to a UserDetails object.
You can create a new instance of org.springframework.security.core.userdetails.User
and populate it with the relevant information from your User entity.

Here's how you can modify your loadUserByUsername method to properly return a UserDetails object:
*/





import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
//import com.lcwd.electronic.store.entites.User;
import com.lcwd.electronic.store.exception.ResourceNotFoundException;
import com.lcwd.electronic.store.repositories.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.lcwd.electronic.store.entites.User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with email " + username + " not found"));

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail()) // Assuming email is the username
                .password(user.getPassword()) // Assuming you have a password field in your User entity
                .roles("USER") // Assuming roles are defined for your users
                .build();
    }
}