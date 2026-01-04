package com.hobbeyhive.backend.controller;


import com.hobbeyhive.backend.entity.Workshop;
import com.hobbeyhive.backend.service.WorkshopService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workshops")
@CrossOrigin(origins = "http://localhost:4200")
public class WorkshopController {

    private final WorkshopService service;

    public WorkshopController(WorkshopService service) {
        this.service = service;
    }

    @GetMapping
    public List<Workshop> getAll() {
        return service.getAllWorkshops();
    }

    @GetMapping("/{id}")
    public Workshop getById(@PathVariable Long id) {
        return service.getWorkshopById(id);
    }
}

