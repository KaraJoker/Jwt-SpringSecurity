package com.noriman.zoom.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: Jwt-SpringSecurity
 * @description:
 * @author: Outcaster
 * @create: 2018-07-30 16:47
 **/
@RestController
@RequestMapping("manager")
public class ManagerController {

    @RequestMapping("/")
    @PreAuthorize("hasRole('MANAGER')")
    public ResponseEntity<?> getManagerGreeting () {
        return ResponseEntity.ok("Greeting from manager");
    }

}
