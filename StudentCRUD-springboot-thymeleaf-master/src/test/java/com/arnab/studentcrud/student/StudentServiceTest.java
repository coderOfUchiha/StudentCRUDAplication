package com.arnab.studentcrud.student;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;


class StudentServiceTest {



    @Mock
    private StudentRepository studentRepository;
    @InjectMocks
    private StudentService studentService;
    private AutoCloseable autoCloseable;
    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        studentService= new StudentService(studentRepository);
    }
    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void addStudent() {
        Student student = new Student("tariq", "Science", 12);
        studentService.addStudent(student);
        ArgumentCaptor<Student> captor = ArgumentCaptor.forClass(Student.class);
        verify(studentRepository).save(captor.capture());
        Student captured = captor.getValue();
        assertThat(captured).isEqualTo(student);

    }

    @Test
    void getStudentById() {
        long id = 15;
        Optional<Student> getStudents = studentRepository.findById(id);
        verify(studentRepository).findById(id);
        assertThat(Optional.empty()).isEqualTo(getStudents);

    }

    @Test
    void canGetAllStudent() {
       List<Student> allStudent = studentRepository.findAll();
        verify(studentRepository).findAll();
        assertThat(studentRepository.count()).isEqualTo(allStudent.size());

    }

    @Test
    void updateStudent() {
        long updateId = 14;
        Optional<Student> getStudents = studentRepository.findById(updateId);
        Student updateStudent = getStudents.get();
        updateStudent.setAge(20);
        updateStudent.setName("nabil");
        updateStudent.setGrp("SQA");

        assertThat(Optional.empty()).isEqualTo(updateStudent);
    }

    @Test

    void deleteStudent() {
        long exstingId = 14;
        studentRepository.deleteById(exstingId);
        verify(studentRepository).deleteById(exstingId);
    }


}