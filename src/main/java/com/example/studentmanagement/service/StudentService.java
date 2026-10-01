package com.example.studentmanagement.service;

import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;
    public Student saveStudent(Student student){
        return repository.save(student);
    }

    public List<Student> getAllStudents(){
        return repository.findAll();
    }


    public Student getStudentbyId(Integer id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public Student updateStudent(Integer id, Student student){
        Student existingStudent = repository.findById(id).orElseThrow(()->new RuntimeException("Student not found"));

        existingStudent.setName(student.getName());
        existingStudent.setAge(student.getAge());
        return repository.save(existingStudent);
    }

    public void deleteStudent(Integer id){
        Student student = repository.findById(id).orElseThrow(()-> new RuntimeException("Student not found"));
        repository.delete(student);
    }
}
