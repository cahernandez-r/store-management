package org.devsoft.storemanagement.common.services;

import lombok.RequiredArgsConstructor;
import org.devsoft.storemanagement.common.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDetailsService userDetailsService() {
        return username -> userRepository.findUserByEmailAndActiveTrue(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
