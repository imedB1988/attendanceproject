package com.attendanceserver.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendanceserver.DTO.ProjectDTO;
import com.attendanceserver.entities.Project;
import com.attendanceserver.repository.ProjectRepository;

@Service
public class ProjectService {

      @Autowired
    private ProjectRepository projectRepository;


    public Project addProject(ProjectDTO dto){
        Project project = new Project();
        project.setName(dto.getName());
        project.setDuration(dto.getDuration());
        project.setStartDate(dto.getStartDate());
        return projectRepository.save(project);

    }


    public List<ProjectDTO> getAllProjects(){
        return projectRepository.findAll().stream().map(Project::getProjectDTO).collect(Collectors.toList());
    }

}
