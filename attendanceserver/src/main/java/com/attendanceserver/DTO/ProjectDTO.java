package com.attendanceserver.DTO;

import java.util.Date;

import lombok.Data;


@Data
public class ProjectDTO {

    private long id;

    private String name;
    private String duration;

    private Date startDate;

}
