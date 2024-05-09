package com.tracolab.backskeleton.controllers;

import com.tracolab.backskeleton.models.Messagerie;
import com.tracolab.backskeleton.services.MessagerieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RequestMapping("messagerie")
@RestController
@RequiredArgsConstructor
public class MessagerieController {
    private final MessagerieService messagerieService;

    @GetMapping("")
    public List<Messagerie> getAllCourses() {
        return messagerieService.findAll();
    }
}
