package com.example.restexample.rest;

import com.example.restexample.jwt.JwtTokenUtil;
import com.example.restexample.mail.EmailServiceImpl;
import com.example.restexample.model.JwtAuthenticationRequest;
import com.example.restexample.model.User;
import com.example.restexample.repository.UserRepository;
import com.example.restexample.security.CurrentUser;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/rest/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private EmailServiceImpl emailService;

    @PostMapping(value = "/auth")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest) throws org.springframework.security.core.AuthenticationException {
        // Perform the security
        final org.springframework.security.core.Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getEmail(),
                        authenticationRequest.getPassword()
                )
        );
        UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getEmail());

        final String token = jwtTokenUtil.generateToken(userDetails);

        // Return the token
        return ResponseEntity.ok(token);
    }

    @GetMapping
    @ApiOperation(value = "Get all users", response = User.class, responseContainer = "list")
    public ResponseEntity getAllUsers() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity getUserById(@PathVariable(name = "id") int id) {
        User one = userRepository.findOne(id);
        if (one == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).
                    body("User with " + id + " id no found");
        }
        return ResponseEntity.ok(one);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUserById(@PathVariable(name = "id") int id) {
        userRepository.delete(id);
        return ResponseEntity.ok("deleted");
    }

    @PostMapping()
    public ResponseEntity saveUser(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setVerify(false);
        userRepository.save(user);
        String token = jwtTokenUtil.generateToken(new CurrentUser(user));
        String message = String.format("Hi %s, You are successfully registered to our cool portal. Please visit by <a href=\"http://localhost:8080/rest/users/verify?token=%s\">this</a> link to verify your account", user.getName(), token);
        emailService.sendSimpleMessage(user.getEmail(), "Welcome", message);
        return ResponseEntity.ok("created");
    }

    @GetMapping("/verify")
    public ResponseEntity verifyUser(@RequestParam("token") String token) {
        String email = jwtTokenUtil.getUsernameFromToken(token);
        User oneByEmail = userRepository.findOneByEmail(email);
        oneByEmail.setVerify(true);
        userRepository.save(oneByEmail);
        return ResponseEntity.ok("verified");
    }


}
