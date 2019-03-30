package main.java;

/*
File:	Course.java
Author:	Armando Minor (aminor1)
Date:	03-29-19

Description: java file for managing course statistics.
*/ 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;


/**
Class:	Course

Description: class for managing course statistics
*/
public class Course {
    
    public HashMap<String, Integer> points = new HashMap<>(); // maps student names (asurite) to their points
    private String name; // course name

    /**
    Method: course
    Inputs:String name
    Returns:n/a (setter)

    Description: sets the name for course
  */
    public Course(String name){
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    /**
    Method: printCourseStats
    Inputs:n/a
    Returns: prints method calculateAverageWithoutMinWithoutMax()

    Description: prints course stats
  */
    public void printCourseStats() {
       ArrayList<Integer> values = new ArrayList<Integer>(points.values());

        System.out.print("Average Grades without max and without min: ");
        System.out.println(this.calculateAverageWithoutMinWithoutMax());
    }
    
    
    // REACH at least 95% Code coverage (assign 3)
    // method to draw node graph for
    // should throw null pointer for empty points member
    // negative points should be ignored
    // max value and min value should be removed - (if doubles then only the first occurrence)
    // if just one or two values no values will be omitted $
    
    /**
    Method:calculateAverageWithoutMinWithoutMax
    Inputs:n/a
    Returns: Returns first and only collection value if only one exists.
     		 If collection size is only of size 2 it will take both values and get the average.
     		 For anything of size greater than 2 it will sum the inputs from the array and return the average.

    Description: Method used to calculate average
  */
    public double calculateAverageWithoutMinWithoutMax() throws NullPointerException {
        ArrayList<Integer> collection = new ArrayList<Integer>(points.values());
        
         int counter = 0;
         int min = Integer.MAX_VALUE;
         int max = Integer.MIN_VALUE;
         
         if(collection.size() == 1){
        	 if (collection.get(0)<0) {
        		 return 0;
        	 }
        	 else {
        		 return collection.get(0);
        	 }
         }//END if
         
         else if (collection.size() == 2){
        	 if (collection.get(0)<0 && collection.get(1)>=0) {
        		 return collection.get(1);
        	 }
        	 else if (collection.get(1)<0 && collection.get(0)>=0) {
        		 return collection.get(1);
        	 }
        	 else if (collection.get(1)<0 && collection.get(0)<0) {
        		 return 0;
        	 }
        	 else {
        		 return (double)(collection.get(0) + collection.get(1))/2;
        	 }
    
         } //end else if
         
         else {
        	 int allPoints = 0;
        	 for(int point:collection) {
        		 if (point >= 0) {
        			 counter = counter++;
        			 if (point < min) {
        				 min = point;
        			 }
        			 else if (point > max) {
        				 max = point;
        			 }
        			 allPoints = allPoints + point;
        		 }
        	 } //for
        	 int totalPoints = allPoints-max-min;
             return totalPoints/(double)(counter-1);
         } //else
         }
    
    // REACH at least 95% Code coverage  (assign 3)
    // if student with the name (asurite member) is not yet included student needs to be added to student list 
    // sets points for a student 

    public void set_points(String name, int points) {
    	System.out.println(points);
        this.points.put(name, points);
    }
    
    
    // REACH at least 95% Code coverage  (assign 3)
    // Students should only be added when they are not yet in the course (names (asurite member) needs to be unique)
    
    /**
    Class:	students
    
    Description: returns valid student
  */
    ArrayList<Student> students  = new ArrayList<Student>();
    public boolean addStudent(Student s) {
        students.add(s);
        points.put(s.getAsurite(), -1);
        return true;
    }

    /**
    Class:	GetPoints
    
    Description: returns points
  */
    public HashMap<String, Integer> GetPoints(){
        return points;
    }
    
    public int getStudent_Points(String student) {
        return points.get(student);
    }

    public int getStudent_Points(Student student) {
        return points.get(student.getAsurite());
    }

    /**
    Class:	getStudents
    
    Description: returns students
  */
    public ArrayList<Student> getStudents(){
        return students;
    }
    
    /**
    Class:	countOccurencesLetterGrades
    
    Description: null
  */
    public HashMap<String, Integer> countOccurencesLetterGrades() throws NullPointerException{
     	return null;
   
    }
  
 }