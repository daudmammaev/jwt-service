package jwt.server.controller;

import jwt.server.domain.JwtRequest;
import jwt.server.domain.User;
import jwt.server.dto.UserDto;
import jwt.server.service.AuthService;
import jwt.server.domain.JwtAuthentication;
import jwt.server.service.UserServices;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import static jwt.server.mapping.UserMapping.UserDtoToUser;
@CrossOrigin
@Slf4j
@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class Controller {

    @Autowired
    private UserServices userServices;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("user/registration")
    public ResponseEntity<String> regUser(@RequestBody JwtRequest authRequest){
        log.info(String.valueOf(authRequest));
        return userServices.regUser(authRequest);
    }
    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("user/{id}")
    public ResponseEntity<String> getUser(@PathVariable("id") long id){
        log.info(String.valueOf(id));
        return userServices.getUser(id);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("user/update")
    public ResponseEntity<String> updateUser(@RequestBody UserDto userDto){
        log.info(String.valueOf(userDto));
        return userServices.updateUser(UserDtoToUser(userDto));
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("user/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") long id){
        log.info(String.valueOf(id));
        return userServices.deleteUser(id);
    }
}