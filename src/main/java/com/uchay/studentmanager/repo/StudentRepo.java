package com.uchay.studentmanager.repo;

import com.uchay.studentmanager.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

// its a model for the service
public interface StudentRepo extends JpaRepository<Student, Long> {

    // springbpots knows these extra methods you define cos the way its written
    void deleteStudentById(Long id);
    Optional<Student> findStudentById(Long id);
}
