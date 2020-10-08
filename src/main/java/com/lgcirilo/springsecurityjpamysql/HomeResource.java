package com.lgcirilo.springsecurityjpamysql;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {
    @GetMapping(path = "/")
    public String home() {
        return "<h1>Welcome</h1>";
    }

    @GetMapping(path = "user")
    public String user() {
        return "<h1>Welcome user</h1>";
    }

    @GetMapping(path = "admin")
    public String admin() {
        return "<h1>Welcome admin</h1>";
    }
}
