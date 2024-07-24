package com.todoapp.todoproject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todoapp.todoproject.entity.Course;;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    Course findByname(String name);

    List<Course> findAllByUsername(String username);
}
