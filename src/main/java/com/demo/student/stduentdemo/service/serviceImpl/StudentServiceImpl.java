package com.demo.student.stduentdemo.service.serviceImpl;

import com.demo.student.stduentdemo.dao.StudentDao;
import com.demo.student.stduentdemo.ds.Student;
import com.demo.student.stduentdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    @Override
    public Student saveStudent(Student student) {
        return studentDao.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDao.findAll();
    }
    @Override
    public Student getStudentById(Long id) {
        return studentDao.findById(id).get();
    }

    @Override
    public Student updateStudent(Student student) {
        return studentDao.save(student);
    }

    @Override
    public void deleteStudentById(long id) {
        studentDao.deleteById(id);
    }

    @Override
    public List<Student> findAllStudent(String keyword) {
        if (keyword !=null){
            return studentDao.findAll(keyword);
        }
        return studentDao.findAll();
    }
}



