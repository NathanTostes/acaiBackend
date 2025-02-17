package com.acai.acaibackend.service;

import com.acai.acaibackend.model.Complement;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ComplementService {

    public List<Complement> getComplements() {
        return List.of(new Complement(0L, "pacoca", 2.00f));
    }
}
