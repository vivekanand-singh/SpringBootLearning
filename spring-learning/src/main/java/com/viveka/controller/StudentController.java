package com.viveka.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.viveka.model.StudentInfo;
import com.viveka.repository.StudentRepository;

@RestController
@RequestMapping(value = "/student")
public class StudentController {
  @Autowired
  StudentRepository studentRepo;

  @GetMapping(value = "/")
  String greet() {
    return "hello";
  }

  @GetMapping(value = "/all")
  List<StudentInfo> getAll() {
    return studentRepo.findAll();
  }

  @GetMapping(value = "/{roll}")
  Optional<StudentInfo> getRoll(@PathVariable Long roll) {
    return studentRepo.findById(roll);
  }

  @PostMapping(value = "/insert")
  Optional<StudentInfo> insert(@RequestBody StudentInfo std) {
    studentRepo.save(std);
    return studentRepo.findById(std.getRollNumber());
  }

  @PutMapping(value = "/update/{roll}")
  Optional<StudentInfo> update(@RequestBody StudentInfo std, @PathVariable Long roll) {
    std.setRollNumber(roll);
    studentRepo.save(std);
    return studentRepo.findById(roll);
  }

  @DeleteMapping(value = "/delete/{roll}")
  String delete(@PathVariable long roll) {
    studentRepo.deleteById(roll);
    return "Deleated";
  }
}
