package com.attendanceserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.attendanceserver.DTO.UserDTO;
import com.attendanceserver.services.AdminService;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("api/admin")
@CrossOrigin("*")
public class AdminController {

@Autowired
private AdminService adminService;


@PostMapping("/createuser")
public ResponseEntity<?> signupUser(@RequestBody UserDTO dto){
        try {
            UserDTO createUser = adminService.createUser(dto);
            return new ResponseEntity<>(createUser, HttpStatus.OK);
        } catch (EntityExistsException | EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
        catch (Exception e){
            return new ResponseEntity<>("User not created !! ", HttpStatus.NOT_ACCEPTABLE);
   
        }

     
}

}
