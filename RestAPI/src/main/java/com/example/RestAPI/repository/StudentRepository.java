package com.example.secondtask.repository;


import com.example.secondtask.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//the repository is necessary for us to use functions such as save, delete etc
@Repository
public interface  StudentRepository extends JpaRepository<Student, Integer> {
}
