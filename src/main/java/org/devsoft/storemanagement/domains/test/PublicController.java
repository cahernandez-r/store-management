package org.devsoft.storemanagement.domains.test;

import org.devsoft.storemanagement.common.exceptions.BusinessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("public")
public class PublicController {

    @GetMapping("test")
    public String test(@RequestParam String name) {
        if (name.length() == 0) {
            throw  new BusinessException("Name is null");
        }
        return "asdf";
    }
}
