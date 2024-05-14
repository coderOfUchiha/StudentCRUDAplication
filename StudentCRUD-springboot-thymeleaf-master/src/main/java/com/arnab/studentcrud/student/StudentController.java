package com.arnab.studentcrud.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

public class StudentController {
    private final StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }
    @GetMapping(path = "/")
    public String indexPage(Model model) {
        model.addAttribute("studentList", service.getAllStudent());
        return "index";
    }
    @GetMapping(path= "/add-student")
    public String addStudentPage(Model model) {
        model.addAttribute("student", new Student());
        return "addForm";
    }

    @PostMapping(path = "/save-student")
    public String saveStudentPage(@ModelAttribute("student") Student student) {
        service.addStudent(student);
        return "redirect:/";
    }
    @GetMapping(path="/show-update-form/{id}")
    public String showUpdateForm(Model model, @PathVariable("id") long id) {
        Student student = service.getStudentById(id);
        model.addAttribute("student", student);
        return "updateForm";
    }
    @GetMapping(path = "/remove-student/{id}")
    public String removeStudentPage(@PathVariable("id")  long id) {
        service.deleteStudent(id);
        return "redirect:/";
    }

}

