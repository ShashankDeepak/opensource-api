package com.opensource.projects.service.projects;
import com.opensource.projects.exceptions.ProjectNotFoundException;
import com.opensource.projects.modal.projects.GssocModal;
import com.opensource.projects.modal.projects.Project;
import com.opensource.projects.repository.GssocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GssocServiceImpl implements ProjectsService {

    @Autowired
    GssocRepository gssocRepository;
    @Override
    public GssocModal getModalById(String id) throws ProjectNotFoundException{
        Optional<GssocModal> modal = gssocRepository.findById(id);
        if(modal.isPresent()){
            return modal.get();
        }
        else{
            throw new ProjectNotFoundException();
        }
    }
    @Override
    public List<? extends Project> getModalsByYear(Integer year) {
        List<? extends Project> modals = gssocRepository.findByYear(year);
        return modals;
    }

    @Override
    public Page<? extends Project> getModalsByPage(int pageNumber, int pageSize) {
        Pageable page = PageRequest.of(pageNumber,pageSize);
        return gssocRepository.findAll(page);
    }
}
