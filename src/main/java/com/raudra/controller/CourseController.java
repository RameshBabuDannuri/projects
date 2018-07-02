package com.raudra.controller;

import com.raudra.entiry.Course;
import com.raudra.exception.CourseNotCreateException;
import com.raudra.exception.CourseNotFoundException;
import com.raudra.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    CourseService courseService;



    @GetMapping(value = "/courses")
    public List<Course> getAll(){
        return courseService.getAll();
    }
    @GetMapping(value = "/courseById/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) throws IllegalStateException{
        Course c = courseService.getCourseById(id);
        if(c == null) {
            throw new CourseNotFoundException("course id "+id+" not available");
        }
        return new ResponseEntity<Object>(c, HttpStatus.OK);
    }
    @GetMapping(value = "/courseByName/{name}")
    public ResponseEntity<?> getByName(@PathVariable String name){
        List<Course> courses =  courseService.getCoursesByName(name);
        if (courses.isEmpty()){
            try {
                throw new CourseNotFoundException(name+" course is not available");
            }catch (CourseNotFoundException exc){

                System.out.println(exc.getMessage());
            }
        }
        return new ResponseEntity<>(courses,HttpStatus.OK);
    }
    @PostMapping(value = "/courses")
    public ResponseEntity<Course> create(@RequestBody Course course){
       Course c =  courseService.create(course);
       if (c == null){
           try {
               throw new CourseNotCreateException("course not created");
           }catch (CourseNotCreateException exc){

               System.out.println(exc.getMessage());
           }
       }
       return new ResponseEntity<Course>(c,HttpStatus.OK);

    }
    @PutMapping(value = "/courses/{id}")
    public ResponseEntity<?> update(@PathVariable int id , @RequestBody Course course){
        Course c = courseService.getCourseById(id);
        if (c == null){
            try {
                throw new CourseNotFoundException("course id "+id+" not found");
            }catch (CourseNotFoundException exc){
                System.out.println(exc.getMessage());
            }

        }
      else {
            c =  courseService.update(id , course);
        }

       return new ResponseEntity<Object>(c,HttpStatus.OK);
    }
    @DeleteMapping(value = "/courses/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        Course c = courseService.delete(id);
        if (c == null){
            throw new CourseNotFoundException(" course id "+id+" not found");
        }
        return new ResponseEntity<Object>(c,HttpStatus.OK);
    }

}
