package com.blockone.studentservices.controller;

import com.blockone.studentservices.entity.Student;
import com.blockone.studentservices.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService service;



    /**
     * Add student to the existing students list
     * @param student Request body containing student details
     * @return newly created student
     */
    @PostMapping("/addStudent")
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        student = service.createStudent(student);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    /**
     * Get list of all students with matching classname or id
     * @param className class of the student
     * @param id id of the student
     * @return list of students
     */
    @GetMapping("/fetchStudents")
    public ResponseEntity<List<Student>> fetchAllStudents(@RequestParam(value = "class", required = false) String className,
                                               @RequestParam(value = "Id", required = false) Integer id){
        if(className != null){
            List<Student> students = service.getAllStudentsByClassName(className);
            return new ResponseEntity<>(students, HttpStatus.OK);
        }else{
            List<Student> students = new ArrayList<Student>();
            students.add(service.getStudent(id));
            return new ResponseEntity<>(students, HttpStatus.OK);
        }


    }

    /**
     * Updated a student with new details
     * @param student Request body containing student details
     * @return updated student
     */
    @PutMapping("/updateStudent")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
        student = service.updateStudent(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    /**
     * Delete student from the students list
     * @param student Request body containing student details
     * @return student gets deleted
     */
    @DeleteMapping("/deleteStudent")
    public ResponseEntity<String> deleteStudnet(@RequestBody Student student){
        String response =  service.deleteStudent(student);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
