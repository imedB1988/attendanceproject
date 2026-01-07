package com.attendanceserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.attendanceserver.DTO.ProjectDTO;
import com.attendanceserver.services.ProjectService;

@RestController
@RequestMapping("/api/projects")
@CrossOrigin("*")
public class ProjectController {
@Autowired
private ProjectService projectService;



@PostMapping("/add")
public ResponseEntity<?> addProject(@RequestBody ProjectDTO dto){
try {
    return ResponseEntity.ok(projectService.addProject(dto));
} catch (Exception e) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
}
}


@GetMapping("/list")
public ResponseEntity<?> getAllProjects(){
try {
    return ResponseEntity.ok(projectService.getAllProjects());
} catch (Exception e) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
}
}




}
