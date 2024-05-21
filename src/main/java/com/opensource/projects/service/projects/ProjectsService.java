package com.opensource.projects.service.projects;

import com.opensource.projects.exceptions.ProjectNotFoundException;
import com.opensource.projects.modal.projects.Project;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProjectsService {

    public Project getModalById(String id) throws ProjectNotFoundException;

    public List<? extends Project> getModalsByYear(Integer year);

    public Page<? extends Project> getModalsByPage(int pageNumber, int pageSize);
}
