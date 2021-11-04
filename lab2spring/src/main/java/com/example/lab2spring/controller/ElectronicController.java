package com.example.lab2spring.controller;

import com.example.lab2spring.entity.ElectronicEntity;
import com.example.lab2spring.entity.User;
import com.example.lab2spring.exception.ElectronicAlreadyExistException;
import com.example.lab2spring.exception.ElectronicAreEmptyException;
import com.example.lab2spring.exception.ElectronicNotFoundException;
import com.example.lab2spring.repository.ElectronicRepo;
import com.example.lab2spring.service.ElectronicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@CrossOrigin
@RestController
@RequestMapping("/electronics")
public class ElectronicController {

    @Autowired
    private ElectronicService electronicService;

    @PostMapping("/user/{userId}")
    public ResponseEntity<?> addElectronic(@RequestBody ElectronicEntity electronic, @PathVariable String userId) {
        try {
            electronicService.addElectronic(electronic, userId);
            return new ResponseEntity<>(electronic, HttpStatus.CREATED);
        } catch (ElectronicAlreadyExistException error) {
            return ResponseEntity.badRequest().body(error.getMessage());
        } catch (ElectronicAreEmptyException e) {
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }catch (Exception error) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getElectronic(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(electronicService.getElectronic(id));
        } catch (ElectronicNotFoundException error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage());
        }
        catch (Exception error) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }

    @GetMapping
    public ResponseEntity<?> getElectronics() {
        try {
            return ResponseEntity.ok(electronicService.getElectronics());
        }
        catch (Exception error) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteElectronic(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(electronicService.deleteElectronic(id));
        }
        catch (Exception error) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateElectronic(@PathVariable Long id,
                                           @RequestBody ElectronicEntity electronic) {
        try {
            return ResponseEntity.ok(electronicService.updateElectronic(id, electronic));
        }
        catch (ElectronicNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception error) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }

    @GetMapping("/profile")
    public ResponseEntity<?> main(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(user);
    }

    /*@GetMapping("/user/{userId}")
    public ResponseEntity<?> getElectronicsForUser(@PathVariable String userId) {
        try {
            return ResponseEntity.ok(electronicService.getElectronicsForUser(userId));
        }
        catch (Exception error) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }*/

}
