package com.acai.acaibackend.controller;

import com.acai.acaibackend.model.Complement;
import com.acai.acaibackend.service.ComplementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/complement")
public class ComplementController {

    private final ComplementService complementService;

    @Autowired
    public ComplementController(ComplementService complementService) {
        this.complementService = complementService;
    }

    @GetMapping
    public List<Complement> getComplements() {
        return complementService.getComplements();
    }

}
