package com.attendanceserver.entities;

import java.util.Date;

import com.attendanceserver.DTO.ProjectDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Project {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String duration;

    private Date startDate;

    public ProjectDTO getProjectDTO(){
            ProjectDTO dto = new ProjectDTO();
            dto.setId(id);
            dto.setName(name);
            dto.setDuration(duration);
            dto.setStartDate(startDate);

            return dto;
    }

}
