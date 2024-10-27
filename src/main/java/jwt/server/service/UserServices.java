package jwt.server.service;

import jwt.server.domain.JwtRequest;
import jwt.server.domain.JwtResponse;
import jwt.server.repository.UserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import jwt.server.domain.Role;
import jwt.server.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServices implements UserServicesInterface {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserServices userServices;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(login)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with username or email: " + login));

        return new CustomUserDetails(user);
    }
    public Optional<User> getByLogin(@NonNull String login) {
        return userRepository.findByLogin(login);
    }
    public ResponseEntity<String> regUser(JwtRequest authRequest){
        if (userRepository.findByLogin(authRequest.getLogin()).isPresent()){
            return ResponseEntity.ok("User already registration");
        }
        return ResponseEntity.ok("User registration " +  userServices.regUser(authRequest));
    }
    public ResponseEntity<String> getUser(long id){
        if (userRepository.findById(id).isEmpty()){
            return ResponseEntity.ok("The user does not exist");
        }else {
            return ResponseEntity.ok(userRepository.findById(id).get().toString());
        }
    }
    public ResponseEntity<String> deleteUser(long id){
        if (userRepository.findById(id).isEmpty()){
            return ResponseEntity.ok("The user does not exist");
        }else {
            userRepository.delete(userRepository.findById(id).get());
            return ResponseEntity.ok("User delete ");
        }
    }
    public ResponseEntity<String> updateUser(User user){
        if (userRepository.findByLogin(user.getLogin()).isEmpty()){
            return ResponseEntity.ok("The user does not exist");
        }
        if (userRepository.findByLogin(user.getLogin()).isPresent()){
            if (userRepository.findByLogin(user.getLogin()).get().getLogin().equals(user.getLogin()) &&
                    userRepository.findByLogin(user.getLogin()).get().getPassword().equals(user.getPassword())){
                userRepository.save(user);
                return ResponseEntity.ok("The user has been updated");
            }
        }else {
            return ResponseEntity.ok("Invalid password and login");
        }
        return ResponseEntity.ok("");
    }

}