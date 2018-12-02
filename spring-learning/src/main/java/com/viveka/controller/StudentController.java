package com.viveka.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

  @GetMapping("/{roll}")
  Optional<StudentInfo> getRoll(@PathVariable Long roll) {
    return studentRepo.findById(roll);
  }

  @PostMapping("/insert")
  Optional<StudentInfo> insert(@RequestBody StudentInfo std) {
    studentRepo.save(std);
    return studentRepo.findById(std.getRollNumber());
  }
}
