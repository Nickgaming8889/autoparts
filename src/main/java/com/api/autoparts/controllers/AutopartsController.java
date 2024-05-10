package com.api.autoparts.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.autoparts.models.AutopartsModel;
import com.api.autoparts.services.AutopartsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@CrossOrigin
@RequestMapping("/autoparts")
public class AutopartsController {
    @Autowired
    AutopartsService service;

    @PostMapping("/save")
    public AutopartsModel save(@RequestBody AutopartsModel autopart) {
        return service.save(autopart);
    }
    
    @PutMapping()
    public AutopartsModel edit(@RequestBody AutopartsModel entity) {
        return service.edit(entity);
    }

    @GetMapping()
    public ArrayList<AutopartsModel> allParts() {
        return service.allParts();
    }
    
    @GetMapping("/findById/{id}")
    public Optional<AutopartsModel> findById(@PathVariable Long id) {
        return service.findById(id);
    }
    
    @GetMapping("/findByCode/{code}")
    public Optional<ArrayList<AutopartsModel>> findByCode(@PathVariable String code) {
        return service.findByCode(code);
    }

    @DeleteMapping("/deleteByCode")
    public String deleteByCode(@RequestParam Long id) {
        return service.deleteByCode(id);
    }
}
