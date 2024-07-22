package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.dto.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>
{
   @Query("select s from Student s where s.email=?1 and s.password=?2")
   Optional<Student> verifyByEmail(String email, String Password);
   
   @Query("select s from Student s where s.phone=?1 and s.password=?2")
   Optional<Student> verifyByPhone(long phone, String Password);
}
