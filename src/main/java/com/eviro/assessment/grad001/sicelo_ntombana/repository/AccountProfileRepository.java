package com.eviro.assessment.grad001.sicelo_ntombana.repository;

import com.eviro.assessment.grad001.sicelo_ntombana.model.AccountProfile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountProfileRepository extends CrudRepository<AccountProfile,Long> {
    List<AccountProfile> findAll();
}
