package org.devsoft.storemanagement.domains.users;

import lombok.RequiredArgsConstructor;
import org.devsoft.storemanagement.domains.users.response.ListUsersResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(Route.USERS)
public class UserController {

    private final UserService userService;

    @GetMapping("test")
    public ResponseEntity<ListUsersResponse> test() {
        return ResponseEntity.ok(userService.listUsers());
    }
}
