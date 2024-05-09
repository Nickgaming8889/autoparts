package com.api.autoparts.repositories;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.api.autoparts.models.AutopartsModel;



@Repository
public interface IAutopartsRepository extends CrudRepository<AutopartsModel, Long>{

    public Optional<ArrayList<AutopartsModel>> findByCode(String code);
    
    public Optional<AutopartsModel> findById(Long id);
}
