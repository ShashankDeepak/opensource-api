package com.opensource.projects.repository;

import com.opensource.projects.modal.projects.GssocModal;
import com.opensource.projects.modal.projects.gsod.GsodModalOld;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface GsodOldRepository extends MongoRepository<GsodModalOld,String> {
    Optional<GsodModalOld> findById(String id);
    List<GsodModalOld> findByYear(int year);
}
