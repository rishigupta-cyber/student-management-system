package com.example.studentmanagement.controller;

import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping("/save")
    public Student saveStudent(@RequestBody Student student){
        return service.saveStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentbyId(@PathVariable Integer id){
        return service.getStudentbyId(id);
    }
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Integer id, @RequestBody Student student){
        return service.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id){
        service.deleteStudent(id);
        return ResponseEntity.ok("Student deleted Successfully.");
    }
}
