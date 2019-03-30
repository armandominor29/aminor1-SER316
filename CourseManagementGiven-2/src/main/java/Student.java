package main.java;

/*
File:	Student.java
Author:	Armando Minor (aminor1)
Date:	03-29-19

Description: java file for defining students.
*/

import java.awt.List;
import java.util.ArrayList;

/**
Class:	Student

Description: defines student values: asurite, major, overall_grade, course, Courses2
*/
public class Student {
    private String asurite;
    private Major major;
    private double overall_grade;
    private ArrayList<Course> courses = new ArrayList<Course>();
    private ArrayList<Course> Courses2 = null;
    
    /**
    Method: Student
    Inputs: asurite, major
    Returns: n/a (setter)

    Description: sets asurite,major value and calls setOverall_grade method to set initial grade to 0
  */
    public Student(String asurite, Major major){
        this.setAsurite(asurite);
        this.setMajor(major);
        setOverall_grade(0);

    }

    public String getAsurite() {
         return asurite;
    }
    
    public void setAsurite(String asurite ) {
        this.asurite = asurite;
    }
    
    public Major getMajor() {
        return major;
    }
    
    /**
    Method: Register_forCourse
    Inputs: course
    Returns: course boolean

    Description: registers student to specific course
  */
    public boolean register_forCourse(Course course) {
      course.addStudent(this);
      return courses.add(course);
  }
    
    public void setMajor(Major major) {
        this.major = major;
    }
    
    public double getOverall_grade(){
        return overall_grade;
    }
    
    public void setOverall_grade(double overall_grade) {
        this.overall_grade = overall_grade;
    }
    
}
