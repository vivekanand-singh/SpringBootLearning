package com.viveka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import com.viveka.model.StudentInfo;

@Component
public interface StudentRepository extends JpaRepository<StudentInfo, Long> {
  StudentInfo findByName(String name);
}
