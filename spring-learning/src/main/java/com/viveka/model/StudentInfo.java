package com.viveka.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class StudentInfo {
  @Id
  @GeneratedValue
  Long rollNumber;
  String name;
  String branch;
}
