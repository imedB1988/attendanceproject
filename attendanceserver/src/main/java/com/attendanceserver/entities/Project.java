package com.attendanceserver.entities;


import java.time.LocalDateTime;
import java.util.Date;

import com.attendanceserver.DTO.ProjectDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import tools.jackson.databind.annotation.JsonDeserialize;
import tools.jackson.databind.ext.javatime.deser.LocalDateDeserializer;

@Entity
@Data
public class Project {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String duration;

   
    private LocalDateTime startDate;

    public ProjectDTO getProjectDTO(){
            ProjectDTO dto = new ProjectDTO();
            dto.setId(id);
            dto.setName(name);
            dto.setDuration(duration);
            dto.setStartDate(startDate);

            return dto;
    }

}
