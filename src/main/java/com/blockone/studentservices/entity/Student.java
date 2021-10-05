package com.blockone.studentservices.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student_table")
public class Student {

    @Id
    private int id;
    private String firstName;
    private String lastName;
    private String className;
    private String nationality;

    /**
     * Generate a string consisting of student details
     * @return string consisting of all student details
     */
    @Override
    public String toString() {
        return "Student{" + "id='" + id + '\'' + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\''
                + ", class='" + className + '\'' + ", nationality='" + nationality + '\''+'}';
    }

}
