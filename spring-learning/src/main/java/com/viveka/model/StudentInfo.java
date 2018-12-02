package com.viveka.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class StudentInfo {
  @Id
  @GeneratedValue
  int rollNumber;
  int name;
  int branch;
}
