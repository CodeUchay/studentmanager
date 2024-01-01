package com.uchay.studentmanager.service;

import com.uchay.studentmanager.model.Student;
import com.uchay.studentmanager.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


// Contains all the methods in the controller and connects to the database
@Service
public class StudentService {
    private final StudentRepo studentRepo;
    @Autowired
    public StudentService(StudentRepo studentRepo){
        this.studentRepo = studentRepo;
    }
    public Student addStudent(Student student){
        student.setStudentCode(UUID.randomUUID().toString());
        return studentRepo.save(student);
    }

    public List<Student> findAllStudent(){
        return studentRepo.findAll();
    }

    public Student updateStudent(Student student){
        return studentRepo.save(student);
    }

    public Student findStudentById(Long id) throws Throwable {
        return studentRepo.findStudentById(id).orElseThrow(() -> new UserPrincipalNotFoundException("User by id" + id + "was not found"));
    }
    public void deleteStudent(Long id){
        studentRepo.deleteStudentById(id);
    }
}
