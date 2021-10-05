package com.blockone.studentservices.repository;


import com.blockone.studentservices.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//@RestResource(exported = false)
public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findByClassName(String className);
}
