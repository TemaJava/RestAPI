package com.example.secondtask.controller;


import com.example.secondtask.entity.Student;
import com.example.secondtask.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;


//the Restcontroller creates responses to our requests
@RestController
public class StudentController {

    @Autowired
    private Service studentService;

    //this function allows us to output all students
    @GetMapping(value = "/students", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Student> list() {
        return studentService.listAll();
    }

    //returns the student with the entered id
    @GetMapping(value = "/students/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> get(@PathVariable Integer id) {
        try {
            Student student = studentService.get(id);
            return new ResponseEntity<Student>(student, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
    }

    //adds a new student to the database
    @PostMapping(value = "/students", produces = MediaType.APPLICATION_JSON_VALUE)
    public void add(@RequestBody Student student) {
        studentService.save(student);
    }

    //updates the student. Implemented with the removal of the old student's version
    @PutMapping(value = "/students/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@RequestBody Student student, @PathVariable Integer id) {
        try {
            Student existStudent = studentService.get(id);
            if (existStudent == student) {
                return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
            }
            studentService.delete(id);
            studentService.save(student);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //deletes the student with the entered id
    @DeleteMapping(value = "/students/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable int id) {
        studentService.delete(id);
    }
}

