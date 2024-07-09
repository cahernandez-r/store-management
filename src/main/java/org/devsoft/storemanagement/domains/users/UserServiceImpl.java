package org.devsoft.storemanagement.domains.users;

import org.devsoft.storemanagement.common.exceptions.BusinessException;
import org.devsoft.storemanagement.domains.users.response.ListUsersResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public ListUsersResponse listUsers() {
        ListUsersResponse response = new ListUsersResponse();
        response.setNames(new ArrayList<>());
        if (response.getNames().isEmpty()) {
            throw new BusinessException("La lista no puede estar vacia");
        }
        response.setIsSuccessful(Boolean.TRUE);
        return response;
    }
}
