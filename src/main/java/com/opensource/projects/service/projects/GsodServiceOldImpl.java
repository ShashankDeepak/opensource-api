package com.opensource.projects.service.projects;

import com.opensource.projects.exceptions.ProjectNotFoundException;
import com.opensource.projects.modal.projects.gsod.GsodModalNew;
import com.opensource.projects.modal.projects.gsod.GsodModalOld;
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
public class GsodServiceOldImpl implements ProjectsService<GsodModalOld>{

    @Autowired
    GsodOldRepository gsodOldRepository;
    @Override
    public GsodModalOld getModalById(String id) throws ProjectNotFoundException {
        Optional<GsodModalOld> modal = gsodOldRepository.findById(id);
        if(modal.isPresent()){
            return modal.get();
        }
        else{
            throw new ProjectNotFoundException();
        }
    }
    @Override
    public List<GsodModalOld> getModalsByYear(Integer year) {
        List<GsodModalOld> modals = gsodOldRepository.findByYear(year);
        return modals;
    }

    @Override
    public Page<GsodModalOld> getModalsByPage(int pageNumber, int pageSize) {
        Pageable page = PageRequest.of(pageNumber,pageSize);
        return gsodOldRepository.findAll(page);
    }

    @Override
    public void updateProject(GsodModalOld project) throws ProjectNotFoundException {

    }
}
