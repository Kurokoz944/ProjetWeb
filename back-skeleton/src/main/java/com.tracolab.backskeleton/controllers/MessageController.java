package com.tracolab.backskeleton.controllers;

import com.tracolab.backskeleton.models.Message;
import com.tracolab.backskeleton.services.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RequestMapping("message")
@RestController
@RequiredArgsConstructor
public class MessageController {
    private final MessageService messageService;

    @GetMapping("")
    public List<Message> getAllCourses() {
        return messageService.findAll();
    }
}
