package com.example.edaappserver.services;

import com.example.edaappserver.repositories.UserRepository;
import com.example.edaappserver.requests.AuthenticationRequest;
import com.example.edaappserver.requests.RegisterRequest;
import com.example.edaappserver.responses.AuthenticationResponse;
import com.example.edaappserver.user.Role;
import com.example.edaappserver.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .email(request.getEmail())
                .passwordus(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        try {
            var userDB = userRepository.findByEmail(request.getEmail()).orElseThrow();
            if (user.getUsername().equals(userDB.getUsername()))
                throw new UsernameNotFoundException("потом доделаю и не ебет");
            // todo сделать нормально, а не хуйню с исключениями
        }catch (Exception e){

        }
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

}
