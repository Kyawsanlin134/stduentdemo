package com.demo.student.stduentdemo.service;

import com.demo.student.stduentdemo.dao.StudentDao;
import com.demo.student.stduentdemo.ds.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    Student saveStudent(Student student);

    List<Student> getAllStudents();

    Student getStudentById(Long id);

    Student updateStudent(Student student);

    void deleteStudentById(long id);

    public List<Student> findAllStudent(String keyword);



}
