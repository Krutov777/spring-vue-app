package com.example.lab2spring.controller;

import com.example.lab2spring.entity.ElectronicEntity;
import com.example.lab2spring.entity.User;
import com.example.lab2spring.repository.ElectronicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.util.Collections;
import java.util.HashMap;


@CrossOrigin
@Controller
@RequestMapping("/")
public class MainController {


    @Autowired
    public MainController() {
    }


    @GetMapping("sessions/me")
    public ResponseEntity<?> user(Principal principal) {
        if (principal == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Collections.singletonMap("error", "unauthorized"));
            // dat not me!!!!!!! TODO should be custom exception handler
        }
        return ResponseEntity.ok(principal);
    }

    @GetMapping("sessions/Google/callback")
    public void googleCallback(HttpServletResponse response) throws IOException {
        response.sendRedirect("http://localhost:8081/electronics");
    }

}
