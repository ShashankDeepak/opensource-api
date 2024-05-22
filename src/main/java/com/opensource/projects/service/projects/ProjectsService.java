package com.opensource.projects.service.projects;

import com.opensource.projects.exceptions.ProjectNotFoundException;
import com.opensource.projects.modal.projects.Project;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProjectsService<T extends Project> {

    public T getModalById(String id) throws ProjectNotFoundException;

    public List<T> getModalsByYear(Integer year);

    public Page<T> getModalsByPage(int pageNumber, int pageSize);

    public void updateProject(T project) throws ProjectNotFoundException;
}
