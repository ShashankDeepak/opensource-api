package com.opensource.projects.repository;

import com.opensource.projects.modal.projects.GssocModal;
import com.opensource.projects.modal.projects.gsod.GsodModalNew;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface GsodNewRepository extends MongoRepository<GsodModalNew,String> {
    Optional<GsodModalNew> findById(String id);
    List<GsodModalNew> findByYear(int year);
}
