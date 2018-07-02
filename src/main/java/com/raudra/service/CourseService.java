package com.raudra.service;

import com.raudra.entiry.Course;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public interface CourseService {
    public List<Course> getAll();
    public Course getCourseById(int id);
    public List<Course> getCoursesByName(String name);
    public Course create(Course course);
    public Course update(int id , Course course);
    public Course delete(int id);
}
