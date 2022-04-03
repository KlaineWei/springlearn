package com.example.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StudentDao extends MongoRepository<Student, String> {

    Student getAllByStudentName(String studentName);

    @Override
    List<Student> findAll();
}
