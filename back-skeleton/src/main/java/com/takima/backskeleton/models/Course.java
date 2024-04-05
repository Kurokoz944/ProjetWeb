package com.takima.backskeleton.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "courses")
@NoArgsConstructor
@Getter
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "courses_id_seq")
    private Long id;
    private String name;
    private Integer hours;
    @ManyToMany(mappedBy = "courses")
    @JsonIgnore
    List<Student> students;
}
