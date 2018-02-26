package com.incremental.ria.api.endpoints;

import com.incremental.ria.repository.commons.HasRole;
import com.incremental.ria.repository.commons.UserRole;
import com.incremental.ria.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private UserService userService;

    @Autowired
    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getHome() {
        return "Hello World";
    }

    @GetMapping("/secure")
    @HasRole(UserRole.USER)
    public String getSecure() {
        return "You are authorized";
    }
}
