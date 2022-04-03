package com.example.mongodb;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

@Slf4j
public class StudentDaoTest extends MongodbApplicationTests{

    @Autowired
    private StudentDao studentDao;

    @Test
    void addOneStudent(){
        for (int i = 0; i < 10; i++) {
            Student student = new Student()
                    .setStudentId("student_" + i)
                    .setStudentName("wzh_" + i)
                    .setStudentAge(i)
                    .setStudentScore(200.5-i)
                    .setStudentBirthday(new Date());
            studentDao.save(student);
            log.info("插入{}", student);
        }
    }

    @Test
    void getOneStudentByStudentId(){
        log.info("student: {}", studentDao.findById("student_1"));
    }

    @Test
    void getAllStudent(){
        List<Student> studentList = studentDao.findAll();
        studentList.forEach(System.out::println);
    }
}
