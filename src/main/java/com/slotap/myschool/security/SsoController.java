package com.slotap.myschool.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@RestController
class SsoController {
    @GetMapping("/v1/logout")
    void logout(HttpServletRequest request) throws ServletException {
        request.logout();
    }
}
