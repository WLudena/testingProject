package com.demo.controllers;

import com.demo.entities.CourseEntity;
import com.demo.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/course/getCourses")
    public String getCourses(Model model) {
        model.addAttribute("courses",courseService.getAllCourses());
        return "";
    }

    @GetMapping("/course/getCourse/{id}")
    public String getCourse(@PathVariable("id") int id,Model model) {
        model.addAttribute("course",courseService.getById(id));
        return "";
    }

    @PostMapping("/course/addCourse")
    public String addCourse(@Valid CourseEntity newCourse) {
        courseService.addCourse(newCourse);
        return "";
    }

    @GetMapping("/course/removeCourse/{id}")
    public String removeCourse(@PathVariable("id") int id) {
        courseService.removeCourse(id);
        return "";
    }

    @GetMapping("/course/editCourse/{id}")
    public String editCourse(@PathVariable("id") int id, @Valid CourseEntity editCourse) {
        courseService.editCourse(editCourse, id);
        return "";
    }


    @PostMapping("/course/addModule/{courseId}/{moduleId}")
    public String addModule(@PathVariable("courseId") int courseId, @PathVariable("moduleId") int moduleId){
        courseService.addModule(courseId,moduleId);
        return "";
    }

    @GetMapping("/course/removeModule/{courseId}/{moduleId}")
    public String removeModule(@PathVariable("courseId") int courseId, @PathVariable("moduleId") int moduleId){
        courseService.removeModule(courseId,moduleId);
        return "";
    }
}
