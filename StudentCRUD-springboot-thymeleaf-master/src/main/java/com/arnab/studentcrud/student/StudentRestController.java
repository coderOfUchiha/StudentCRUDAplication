package com.arnab.studentcrud.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentRestController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/")
    public List<Student> getAllStudents() {
        return studentService.getAllStudent();

    }
    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }
    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @PutMapping("/students/{id}")
    public Student updateStudent(@RequestBody Student student, @PathVariable long id) {
        Student uStudent= studentService.getStudentById(id);
        uStudent.setName(student.getName());
        uStudent.setGrp(student.getGrp());
        uStudent.setAge(student.getAge());
        Student updatedStudent= studentService.updateStudent(uStudent);
        return updatedStudent;



    }
    @DeleteMapping("/students/{id}")
    public void deleteStudentById(@PathVariable long id) {
        studentRepository.deleteById(id);
    }

}
