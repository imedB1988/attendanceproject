package com.attendanceserver.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendanceserver.DTO.UserDTO;
import com.attendanceserver.entities.Project;
import com.attendanceserver.entities.User;
import com.attendanceserver.repository.ProjectRepository;
import com.attendanceserver.repository.UserRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class AdminService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProjectRepository projectRepository;

    public UserDTO createUser(UserDTO userDTO){
        boolean exists = userRepository.findByEmail(userDTO.getEmail()).isPresent();
        if(exists)
        {
            throw new EntityExistsException("user already exists");
        }

        Optional<Project> optionalProject= projectRepository.findById(userDTO.getProjectID());
        if(optionalProject.isPresent())
        {
            User user = new User();
            user.setUserRole(userDTO.getUserRole());
            user.setEmail(userDTO.getEmail());
            user.setName(userDTO.getName());
            user.setPassword(userDTO.getPassword());
            user.setProject(optionalProject.get());

            User userCreated = userRepository.save(user);

            return userCreated.getUserDTO();
        }

        throw new EntityNotFoundException("Project not found");
    }
}
