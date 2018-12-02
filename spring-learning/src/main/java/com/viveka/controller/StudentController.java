package com.viveka.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.viveka.model.StudentInfo;
import com.viveka.repository.StudentRepository;

@Component
@RestController("/student")
@RequestMapping
public class StudentController {
  @Autowired
  StudentRepository studentRepo;

  @GetMapping("/all")
  List<StudentInfo> getAll() {
    return studentRepo.findAll();
  }
}
