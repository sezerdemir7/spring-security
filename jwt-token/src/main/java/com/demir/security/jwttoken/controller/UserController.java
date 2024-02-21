package com.demir.security.jwttoken.controller;

import com.demir.security.jwttoken.dto.AuthRequest;
import com.demir.security.jwttoken.dto.CreateUserRequest;
import com.demir.security.jwttoken.model.User;
import com.demir.security.jwttoken.service.AuthenticationService;
import com.demir.security.jwttoken.service.JwtService;
import com.demir.security.jwttoken.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {

    private final UserService userService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final AuthenticationService authenticationService;

    public UserController(UserService userService, JwtService jwtService, AuthenticationManager authenticationManager, AuthenticationService authenticationService) {
        this.userService = userService;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.authenticationService = authenticationService;
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "hello world! this is dmr";
    }

    @PostMapping("/addNewUser")
    public User addUser(@RequestBody CreateUserRequest request){
        return userService.createUser(request);
    }

    @PostMapping("/generateToken")
    public String generateToken(@RequestBody AuthRequest request){
        return authenticationService.generateToken(request);
    }

    @GetMapping("/user")
    public String getUserString(){
        return "This is User";
    }

    @GetMapping("/admin")
    public String getAdminString(){
        return "This is Admin";
    }
}
