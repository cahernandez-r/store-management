package org.devsoft.storemanagement.domains.auth;

import org.devsoft.storemanagement.domains.auth.request.RegisterRequest;
import org.devsoft.storemanagement.domains.auth.request.LoginRequest;
import org.devsoft.storemanagement.domains.auth.response.JwtAuthenticationResponse;

public interface AuthenticationService {

    JwtAuthenticationResponse register(RegisterRequest request);

    JwtAuthenticationResponse login(LoginRequest request);
}
