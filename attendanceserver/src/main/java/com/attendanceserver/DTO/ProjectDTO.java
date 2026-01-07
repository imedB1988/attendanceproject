package com.attendanceserver.DTO;

import java.time.LocalDateTime;


import lombok.Data;



@Data
public class ProjectDTO {

    private long id;

    private String name;
    private String duration;
    
    private LocalDateTime startDate;

}
