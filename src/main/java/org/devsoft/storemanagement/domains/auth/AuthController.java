package org.devsoft.storemanagement.domains.auth;

import lombok.RequiredArgsConstructor;
import org.devsoft.storemanagement.domains.auth.request.LoginRequest;
import org.devsoft.storemanagement.domains.auth.request.RegisterRequest;
import org.devsoft.storemanagement.domains.auth.response.JwtAuthenticationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(AuthRoute.AUTH)
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping(AuthRoute.REGISTER)
    public ResponseEntity<JwtAuthenticationResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping(AuthRoute.LOGIN)
    public ResponseEntity<JwtAuthenticationResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authenticationService.login(request));
    }
}
