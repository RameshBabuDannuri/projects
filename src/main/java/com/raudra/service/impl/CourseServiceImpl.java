package com.raudra.service.impl;

import com.raudra.entiry.Course;
import com.raudra.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Service
public  class CourseServiceImpl implements CourseService {
    List<Course> courses = new ArrayList<>();

      public CourseServiceImpl() {
      Course course1 = new Course(1, "java", 1000);
      Course course2 = new Course(2, "java", 1200);
      Course course3 = new Course(3, "c", 3000);
      Course course4 = new Course(4, "python", 4000);
      courses.add(course1);
      courses.add(course2);
      courses.add(course3);
      courses.add(course4);
      course1.setDescription("java is best Course");
  }
    public List<Course> getAll(){
        return courses;
    }
    public Course getCourseById(int id){
        Iterator itr  = courses.iterator();

        while (itr.hasNext()){
            Course course = (Course) itr.next();
            if (id == course.getId()){
                return course;
            }
        }
        return null;
    }

    public List<Course> getCoursesByName(String name) {
        List<Course> coursesByName = new ArrayList<>();
        Iterator itr  = courses.iterator();

        while (itr.hasNext()){
            Course course = (Course) itr.next();
            if (name.equalsIgnoreCase(course.getName())){
                coursesByName.add(course);
            }
        }
        return coursesByName;
    }

    @Override
    public Course create(Course course) {
        Course newCourse = getCourseById(course.getId());
        if (newCourse == null) {
            courses.add(course);
            return course;
        }
        return null;
    }

    @Override
    public Course update(int id , Course course) {
        Course temp = getCourseById(id);
        if (temp!=null){
            temp.setId(course.getId());
            temp.setName(course.getName());
            temp.setPrice(course.getPrice());
            temp.setDescription(course.getDescription());
            temp.setEnabled(course.isEnabled());
            temp.setStartDate(course.getStartDate());
            temp.setEndDate(course.getEndDate());

            return temp;
        }
        return null;
    }

    @Override
    public Course delete(int id) {
        Iterator itr  = courses.iterator();

        while (itr.hasNext()){
            Course course = (Course) itr.next();
            if (id == course.getId()){
                itr.remove();
                return course;
            }
        }
        return null;

    }

}
