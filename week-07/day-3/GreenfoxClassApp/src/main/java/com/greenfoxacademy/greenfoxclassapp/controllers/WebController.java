package com.greenfoxacademy.greenfoxclassapp.controllers;

import com.greenfoxacademy.greenfoxclassapp.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {

  StudentService studentService;

  public WebController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping(value = "/gfa")
  public String getMainPage(Model model) {
    model.addAttribute("counter", studentService.count());
    return "main";
  }

  @GetMapping(value = "/gfa/list")
  public String getAllStudents(Model model) {
    model.addAttribute("students", studentService.findAll());
    return "list-of-students";
  }

  @GetMapping(value = "/gfa/add")
  public String getAddStudentPage() {
    return "add-student";
  }

  @PostMapping(value = "/gfa/add")
  public String postAddStudentPage(@RequestParam(value = "studentName") String student) {
    studentService.save(student);
    return "redirect:/gfa/list";
  }
}
