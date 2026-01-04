package com.hobbeyhive.backend.service;

import com.hobbeyhive.backend.entity.Workshop;
import com.hobbeyhive.backend.repository.WorkshopRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkshopService {

    private final WorkshopRepository repository;

    public WorkshopService(WorkshopRepository repository) {
        this.repository = repository;
    }

    public List<Workshop> getAllWorkshops() {
        return repository.findAll();
    }

    public Workshop getWorkshopById(Long id) {
        return ((Optional<Workshop>) repository.findById(id))
                .orElseThrow(() -> new RuntimeException("Workshop not found"));
    }
}
