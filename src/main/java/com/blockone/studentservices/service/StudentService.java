package com.blockone.studentservices.service;

import com.blockone.studentservices.entity.Student;
import com.blockone.studentservices.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    /**
     * Create student.
     *
     * @return the student
     */
    public Student createStudent(Student student) {
        return repository.save(student);
    }


    /**
     * Get all students list matching with the given className.
     *
     * @return the list
     */
    public List<Student> getAllStudentsByClassName(String className) {
        return repository.findByClassName(className);
    }

    /**
     * Gets student by id.
     *
     * @param studentId of the student
     * @return the student with id
     */
    public Student getStudent(int studentId) {
        return repository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with ID :: " + studentId));
    }

    /**
     * Delete student.
     *
     * @param student the student details
     */
    public String deleteStudent(Student student) {
        Student existingStudent = repository.findById(student.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with ID :: " + student.getId()));
        int studentId = existingStudent.getId();
        repository.deleteById(studentId);
        return "Student with ID " + studentId + " deleted.";
    }

    /**
     * Update student response entity.
     *
     * @param student the student details
     * @return the response entity
     */
    public Student updateStudent(Student student){
        Student existingStudent = repository.findById(student.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with ID :: " + student.getId()));
        existingStudent.setId(student.getId());
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setClassName(student.getClassName());
        existingStudent.setNationality(student.getNationality());
        return repository.save(existingStudent);
    }

}
