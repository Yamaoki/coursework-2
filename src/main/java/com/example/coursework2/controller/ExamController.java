package com.example.coursework2.controller;

import com.example.coursework2.Question;
import com.example.coursework2.service.ExaminerServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExamController {

    private final ExaminerServiceImpl examinerService;

    public ExamController(ExaminerServiceImpl examinerService) {
        this.examinerService = examinerService;
    }
    @GetMapping(path = "/get/{amount}")
    public Collection<Question> add(@PathVariable(required = false) int amount) {
        return examinerService.getQuestions(amount);
    }
}
