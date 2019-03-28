package com.example.demo.repositories;

import com.example.demo.beans.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
