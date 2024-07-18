package org.devsoft.storemanagement.domains.auth;

import lombok.RequiredArgsConstructor;
import org.devsoft.storemanagement.common.config.JwtTokenProvider;
import org.devsoft.storemanagement.common.entities.User;
import org.devsoft.storemanagement.common.repositories.UserRepository;
import org.devsoft.storemanagement.domains.auth.request.LoginRequest;
import org.devsoft.storemanagement.domains.auth.request.RegisterRequest;
import org.devsoft.storemanagement.domains.auth.response.JwtAuthenticationResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtService;

    @Override
    public JwtAuthenticationResponse register(final RegisterRequest request) {

        var user = new User();
        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        userRepository.save(user);
        var jwt = jwtService.createToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

    @Override
    public JwtAuthenticationResponse login(final LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userRepository.findUserByEmailAndActiveTrue(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
        var jwt = jwtService.createToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }
}
