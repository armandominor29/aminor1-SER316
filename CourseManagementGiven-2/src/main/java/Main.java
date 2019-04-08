package main.java;

/*
File:Course.java
Author:Armando Minor (aminor1)
Date:03-29-19

Description: java file for managing course statistics.
 */

//SER316 TASK 2 SPOT-BUGS FIX
//Removed unnecessary imports
import java.util.HashMap;


/**.
Class:Main

Description:Creates students and courses for implementation 
 */
public class Main {
    static HashMap<String, Student> students = new HashMap<>();
    static HashMap<String, CourseGrades0> courses = new HashMap<>();
    //SER316 TASK 2 SPOT-BUGS FIX
    //Removed unused HashMap
    /**
    Method: main
    Inputs: args
    Returns: n/a

    Description: main executes methods in Course.java, Major.java, and Student.java.
     */
    public static void main(String[] args)throws Exception {

        students.put("anna", new Student("anna", Major.valueOf("SER")));
        students.put("karl", new Student("karl", Major.valueOf("CS")));
        students.put("franz", new Student("franz", Major.valueOf("CS")));
        students.put("harry", new Student("harry", Major.valueOf("SER")));
        students.put("aneesh", new Student("aneesh", Major.valueOf("SER")));
        students.put("rebecca", new Student("rebecca", Major.valueOf("SER")));
        students.put("alex", new Student("alex", Major.valueOf("SER")));
        students.put("rose", new Student("rose", Major.valueOf("SER")));



        courses.put("SER316", new CourseGrades0("SER316"));
        courses.put("SER315", new CourseGrades0("SER315"));
        courses.put("SC232", new CourseGrades0("CS232"));
        //SER316 TASK 2 SPOT-BUGS FIX
        //fixed Integer warning (Bad Practice Error)
        int newInt = Integer.valueOf(40);
         
        
        System.out.println("Anna has scored "
                //SER316 TASK 2 SPOT-BUGS FIX
            + newInt
            + " marks which makes her the topper.");
        courses.get("SER315").set_points("anna", 40);
        courses.get("SER315").set_points("harry", 20);
        courses.get("SER315").set_points("aneesh", 30);
        courses.get("SER315").set_points("rebecca", 10);
        courses.get("SER315").set_points("alex", 30);
        courses.get("SER315").set_points("rose", 23);


        courses.get("SER315").printCourseStats();
    }
}
