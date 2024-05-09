package com.api.autoparts.services;

import com.api.autoparts.models.AutopartsModel;
import com.api.autoparts.repositories.IAutopartsRepository;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutopartsService {
    @Autowired
    IAutopartsRepository repository;

    public AutopartsModel save(AutopartsModel autoparts) {
        String searchCode = autoparts.getCode();
        if (repository.findByCode(searchCode).toString().equals("Optional[[]]")) {
            return repository.save(autoparts);
        }
        else {
            AutopartsModel autoparts2 = new AutopartsModel();
            autoparts2.setId(-1L);
            return autoparts2;
        }
    }

    public ArrayList<AutopartsModel> allParts() {
        return (ArrayList<AutopartsModel>) repository.findAll();
    }

    public Optional<ArrayList<AutopartsModel>> findByCode(String searchCode) {
        return repository.findByCode(searchCode);
    }

    public Optional<AutopartsModel> findById(Long searchId) {
        return repository.findById(searchId);
    }

    public String deleteByCode(Long id) {
        if (findById(id).isPresent()) {
            repository.deleteById(id);
            return "Pieza Eliminada";
        }
        else {
            return "No se encontro la pieza";
        }
    }

    public AutopartsModel edit(AutopartsModel autoparts) {
        return repository.save(autoparts);
    }
}
