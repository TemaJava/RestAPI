package com.example.secondtask.service;

import com.example.secondtask.entity.Student;
import com.example.secondtask.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


//class service contains business logic of our app.
//now there are only basic functions, but it's good to create such a class for the future
@org.springframework.stereotype.Service
@Transactional
public class Service {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> listAll(){
        return studentRepository.findAll();
    }

    public Student get(Integer id){
        return studentRepository.findById(id).get();
    }

    public void  save(Student student){
        studentRepository.save(student);
    }

    public void delete(int id){
        studentRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return studentRepository.existsById(id);
    }
}
