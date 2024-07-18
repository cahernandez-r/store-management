package org.devsoft.storemanagement.domains.users.response;

import lombok.Getter;
import lombok.Setter;
import org.devsoft.storemanagement.common.dto.ResultDTO;

import java.util.List;

@Getter
@Setter
public class ListUsersResponse extends ResultDTO {

    private List<String> names;

    public ListUsersResponse() {
    }
}
