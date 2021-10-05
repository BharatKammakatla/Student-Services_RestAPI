package com.blockone.studentservices.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import com.blockone.studentservices.entity.Student;
import com.blockone.studentservices.service.StudentService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;


import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    private static ObjectMapper mapper = new ObjectMapper();

    /**
     * Test if students are fetched based on id / class
     */
    @Test
    public void testFetchStudents() throws Exception {
        List<Student> students = new ArrayList<>();
        Student student = new Student();
        student.setId(896443);
        student.setFirstName("Rajju");
        student.setLastName("Nodadi");
        student.setClassName("9 Y");
        student.setNationality("India");
        students.add(student);
        Mockito.when(studentService.getAllStudentsByClassName(ArgumentMatchers.any())).thenReturn(students);
        mockMvc.perform(get("/fetchStudents").queryParam("Id","896443")).andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)));
    }

    /**
     * Test if student is created with given details
     */
    @Test
    public void testCreateStudent() throws Exception {
        Student student = new Student();
        student.setId(896443);
        student.setFirstName("Rajju");
        student.setLastName("Nodadi");
        student.setClassName("9 Y");
        student.setNationality("India");
        Mockito.when(studentService.createStudent(ArgumentMatchers.any())).thenReturn(student);
        String json = mapper.writeValueAsString(student);
        mockMvc.perform(post("/addStudent").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
                .content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", Matchers.equalTo(896443)))
                .andExpect(jsonPath("$.firstName", Matchers.equalTo("Rajju")));
    }

    /**
     * Test if a student is updated with new detials
     */
    @Test
    public void testUpdateStudent() throws Exception {
        Student student = new Student();
        student.setId(896443);
        student.setFirstName("Rajju");
        student.setLastName("Nodadi");
        student.setClassName("9 Y");
        student.setNationality("India");
        Mockito.when(studentService.updateStudent(ArgumentMatchers.any())).thenReturn(student);
        String json = mapper.writeValueAsString(student);
        mockMvc.perform(put("/updateStudent").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
                .content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(jsonPath("$.id", Matchers.equalTo(896443)))
                .andExpect(jsonPath("$.firstName", Matchers.equalTo("Rajju")));
    }

    /**
     * Test if a student is deleted
     */
    @Test
    public void testDeleteStudent() throws Exception {
        Student student = new Student();
        student.setId(896443);
        student.setFirstName("Rajju");
        student.setLastName("Nodadi");
        student.setClassName("9 Y");
        student.setNationality("India");
        Mockito.when(studentService.deleteStudent(ArgumentMatchers.any())).thenReturn("Student with ID " + student.getId() +" deleted.");
        String json = mapper.writeValueAsString(student);
        MvcResult requestResult = mockMvc.perform(delete("/deleteStudent").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
                .content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
        String result = requestResult.getResponse().getContentAsString();
        assertEquals(result, "Student with ID " + student.getId() +" deleted.");}
}