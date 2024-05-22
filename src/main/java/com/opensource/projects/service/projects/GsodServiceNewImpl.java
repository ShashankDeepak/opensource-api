package com.opensource.projects.service.projects;

import com.opensource.projects.exceptions.ProjectNotFoundException;
import com.opensource.projects.modal.projects.GssocModal;
import com.opensource.projects.modal.projects.Project;
import com.opensource.projects.modal.projects.gsod.GsodModalNew;
import com.opensource.projects.repository.GsodNewRepository;
import com.opensource.projects.repository.GsodOldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GsodServiceNewImpl implements ProjectsService<GsodModalNew>{
    @Autowired
    GsodNewRepository gsodNewRepository;

    @Override
    public GsodModalNew getModalById(String id) throws ProjectNotFoundException {
        Optional<GsodModalNew> modal = gsodNewRepository.findById(id);
        if(modal.isPresent()){
            return modal.get();
        }
        else{
            throw new ProjectNotFoundException();
        }
    }

    @Override
    public List<GsodModalNew> getModalsByYear(Integer year) {
        List<GsodModalNew> modals = gsodNewRepository.findByYear(year);
        return modals;
    }

    @Override
    public Page<GsodModalNew> getModalsByPage(int pageNumber, int pageSize) {
        Pageable page = PageRequest.of(pageNumber,pageSize);
        return gsodNewRepository.findAll(page);
    }

    @Override
    public void updateProject(GsodModalNew project) throws ProjectNotFoundException {

    }
}
