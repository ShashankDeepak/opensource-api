package com.opensource.projects.repository;

import com.opensource.projects.modal.projects.GssocModal;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface GssocRepository extends MongoRepository<GssocModal,String> {
    Optional<GssocModal> findById(String id);
    List<GssocModal> findByYear(int year);
}
