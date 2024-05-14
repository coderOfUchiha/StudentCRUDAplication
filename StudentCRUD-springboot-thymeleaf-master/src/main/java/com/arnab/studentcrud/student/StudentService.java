package com.arnab.studentcrud.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public Student addStudent(Student student) {

        return studentRepository.save(student);
    }
    public Student getStudentById(long id) {
        Optional<Student> student1 = studentRepository.findById(id);
        if (student1.isEmpty()) {
            throw new RuntimeException("Student not found");
        }
        return student1.get();
    }
    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }
    public Student updateStudent(Student student){
        Optional<Student> oldStudent = studentRepository.findById(student.getId());
        if(oldStudent.isEmpty())
        {
            throw new RuntimeException("Student not found");
        }
        Student udateStudent = oldStudent.get();
        udateStudent.setName(student.getName());
        udateStudent.setGrp(student.getGrp());
        udateStudent.setAge(student.getAge());
        udateStudent.setId(student.getId());

        return studentRepository.save(udateStudent);
    }
    public void deleteStudent(long id){
        Optional<Student> student = studentRepository.findById(id);
        if(student.isEmpty()){
            throw new RuntimeException("No student found");
        }
        studentRepository.deleteById(id);
    }

}