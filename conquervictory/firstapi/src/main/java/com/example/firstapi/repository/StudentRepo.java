package com.example.firstapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.firstapi.domain.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer>  {

    List<Student> findByName(String name);
     
    @Query(value = "SELECT * FROM student WHERE gender = :gender AND technology = :technology", nativeQuery = true)
    //@Query(nativeQuery = true,value = "select * from student where gender = :gender and technology = :technology")
    List<Student> findByGenderAndTechnology(@Param("gender") String gender,@Param("technology") String technology);

}
