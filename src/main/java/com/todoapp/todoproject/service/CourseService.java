package com.todoapp.todoproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoapp.todoproject.entity.Course;
import com.todoapp.todoproject.repositories.CourseRepository;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    // POST
    public Course saveCourse(Course course) {
        System.out.println(course.toString());
        return courseRepository.save(course);
    }

    public List<Course> saveCourses(List<Course> courses) {
        return courseRepository.saveAll(courses);
    }

    // GET
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    // orElse : renvoie quelque chose si le findById ne renvoie rien
    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    public Course getCourseByName(String name) {
        return courseRepository.findByname(name);
    }

    public List<Course> getCoursesForUser(String username) {
        return courseRepository.findAllByUsername(username);
    }

    // PUT
    public Course updateCourse(Course course) {
        System.out.println("updates");
        Course existing_course = courseRepository.findById(course.getId()).orElse(null);
        existing_course.setName(course.getName());
        existing_course.setDescription(course.getDescription());
        existing_course.setStatus(course.getStatus());
        return courseRepository.save(existing_course);
    }

    // DELETE
    public String deleteCourse(Long id) {
        courseRepository.deleteById(id);
        return id + " id -> course removed/completed";
    }

}
