package com.demo.student.stduentdemo.controller;

import com.demo.student.stduentdemo.ds.Student;
import com.demo.student.stduentdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;


    @GetMapping("/")
    public String createStudentForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "index";
    }
    @PostMapping("/student")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }
    @GetMapping("/students")
    public String studentList(Model model){
        model.addAttribute("students",studentService.getAllStudents());
        return "studentlist";
    }
    @GetMapping("/students/edit/{id}")
    public String editStudentFrom(@PathVariable Long id, Model model){
    model.addAttribute("student",studentService.getStudentById(id));
    return "editstudent";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id,
                                @ModelAttribute("student") Student student,
                                Model model) {
        // get student from database by id
        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setId(id);
        existingStudent.setName(student.getName());
        existingStudent.setNrc(student.getNrc());
        existingStudent.setGender(student.getGender());
        existingStudent.setDb(student.getDb());
        existingStudent.setCity(student.getCity());
        existingStudent.setAddress(student.getAddress());
        existingStudent .setRemark(student.getRemark());
        // save updated student object
        studentService.updateStudent(existingStudent);
        return "redirect:/students";
    }
    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }
    @GetMapping("/search")
    public String getStudent(@Param("keyword") String keyword, Model model){
        List<Student> students = studentService.findAllStudent(keyword);
        model.addAttribute("students",students);
        model.addAttribute("keyword",keyword);
        return "studentlist";
    }

}
