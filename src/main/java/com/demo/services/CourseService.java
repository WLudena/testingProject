package com.demo.services;

import com.demo.entities.CourseEntity;
import com.demo.entities.ModuleEntity;
import com.demo.repositories.CourseRepository;
import com.demo.repositories.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private ModuleRepository moduleRepository;

    public List<CourseEntity> getAllCourses() {
        ArrayList<CourseEntity> courses = new ArrayList<>();
        courseRepository.findAll().forEach(courseEntity -> courses.add(courseEntity));
        return courses;
    }

    public CourseEntity getById(int courseId) {
        return courseRepository.findById(courseId).get();
    }

    public void addCourse(CourseEntity newCourse) {
        courseRepository.save(newCourse);
    }

    public void removeCourse(int id) {
        courseRepository.deleteById(id);
    }

    public void removeCourse(CourseEntity courseEntity){
        courseRepository.delete(courseEntity);
    }

    public CourseEntity editCourse(CourseEntity editEntity, int id) {
        editEntity.setCourseId(id);
        courseRepository.save(editEntity);
        return editEntity;
        
    }

    public void addModule(int courseId, int moduleId) {
        CourseEntity course = courseRepository.findById(courseId).get();
        ModuleEntity module = moduleRepository.findById(moduleId).get();
        addModule(course,module);

    }

    public void removeModule(int courseId, int moduleId) {
        CourseEntity course = courseRepository.findById(courseId).get();
        ModuleEntity module = moduleRepository.findById(moduleId).get();
        course.removeModule(module);
        courseRepository.save(course);
    }

    public void addModule(CourseEntity course, ModuleEntity module){
        course.addModule(module);
        courseRepository.save(course);
    }

    public void removeModule(CourseEntity course, ModuleEntity module){
        course.removeModule(module);
        courseRepository.save(course);
    }
}
