package com.todoapp.todoproject.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.todoapp.todoproject.entity.Course;
import com.todoapp.todoproject.service.CourseService;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;
    private final Logger logger = LoggerFactory.getLogger(CourseController.class);

    // POST
    @PostMapping("/addCourse")
    public Course addCourse(@RequestBody Course course) {
        logger.info("Course object {}", course.toString());
        return courseService.saveCourse(course);
    }

    @PostMapping("/addCourses")
    public List<Course> addCourses(@RequestBody List<Course> courses) {
        logger.info("Courses object {}", courses.toString());
        return courseService.saveCourses(courses);
    }

    // GET
    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return courseService.getCourses();
    }

    @GetMapping("/courseById/{id}")
    public Course getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    @GetMapping("/courseByName/{name}")
    public Course findCourseByName(@RequestBody String name) {
        return courseService.getCourseByName(name);
    }

    @GetMapping("/listCourseByUsername/{username}")
    public List<Course> findCoursesByUsername(@PathVariable String username) {
        return courseService.getCoursesForUser(username);
    }

    // PUT
    @PutMapping("/update")
    public Course updateCourse(@RequestBody Course course) {
        System.out.println("UPDATED");
        return courseService.updateCourse(course);
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public String deleteCourse(@PathVariable Long id) {
        return courseService.deleteCourse(id);
    }
}
