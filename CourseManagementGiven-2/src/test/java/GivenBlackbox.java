package test.java;

import static org.junit.Assert.*; 
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import main.java.Course;
import main.java.CourseGrades1;
import main.java.CourseGrades2;
import main.java.CourseGrades5;
import main.java.CourseGrades4;
import main.java.CourseGrades0;
import main.java.CourseGrades3;

import java.lang.reflect.Constructor;

@RunWith(Parameterized.class)
public class GivenBlackbox {
    private Class<Course> classUnderTest;
    
    
    @SuppressWarnings("unchecked")
    public GivenBlackbox(Object classUnderTest) {
        this.classUnderTest = (Class<Course>) classUnderTest;
    }
    
    // Defining all the classes that need to be tested
    @Parameters
    public static Collection<Object[]> courseGradesUnderTest() {
        Object[][] classes = { 
                {CourseGrades0.class},
                {CourseGrades1.class},
                {CourseGrades2.class},
                {CourseGrades3.class},
                {CourseGrades4.class},
                {CourseGrades5.class}
        };
        return Arrays.asList(classes);
    }
    
    // method to call the correct constructor
    private Course createCourse(String name) throws Exception {
        Constructor<Course> constructor = classUnderTest.getConstructor(String.class);
        return constructor.newInstance(name);
    }
    

    // A sample course
    Course twoStudent;
    HashMap<String, Integer> twoStudentExpected = new HashMap<String, Integer>(); 
    
    // All test for courses
    Course fiveStudents;
    HashMap<String, Integer> fiveStudentsExpected = new HashMap<String, Integer>(); 
  
    Course studentEdgeCases;
    HashMap<String, Integer> studentEdgeCasesExpected = new HashMap<String, Integer>(); 
    
    Course negativeStudents;
    HashMap<String, Integer> negativeStudentsExpected = new HashMap<String, Integer>(); 
    
    Course noStudents;
    HashMap<String, Integer> noStudentsExpected = new HashMap<String, Integer>(); 
    
    Course exceedingStudents;
    HashMap<String, Integer> exceedingStudentExpected = new HashMap<String, Integer>(); 
    
    Course zeroStudent;
    HashMap<String, Integer> zeroStudentExpected = new HashMap<String, Integer>(); 
    
    Course fractionStudents;
    HashMap<String, Integer> fractionStudentsExpected = new HashMap<String, Integer>();
    
    @Before
    public void setUp() throws Exception {
        
        // all courses should be created like this
        
        
        // Course created with two Students having
        twoStudent = createCourse("SER316");
        twoStudent.set_points("Hanna",100);
        twoStudent.set_points("Karla",100);
        
        // Course created with five Students
        fiveStudents = createCourse("SER321");
        fiveStudents.set_points("Joe",100);
        fiveStudents.set_points("Bobby",70);
        fiveStudents.set_points("Carl",55);
        fiveStudents.set_points("Hank",40);
        fiveStudents.set_points("George",30);
        
        // Course created with student edge Cases
        studentEdgeCases = createCourse("SER401");
        studentEdgeCases.set_points("Jim",81);
        studentEdgeCases.set_points("Bob",80);
        studentEdgeCases.set_points("Cale",79);
        studentEdgeCases.set_points("Henry",66);
        studentEdgeCases.set_points("Geo",65);
        studentEdgeCases.set_points("Sam",64);
        studentEdgeCases.set_points("Mike",51);
        studentEdgeCases.set_points("Kon",50);
        studentEdgeCases.set_points("Poll",49);
        studentEdgeCases.set_points("Lonnie",36);
        studentEdgeCases.set_points("Mark",35);
        studentEdgeCases.set_points("Sim",34);
        studentEdgeCases.set_points("Xen",1);
        studentEdgeCases.set_points("Rachael",0);
        
        negativeStudents = createCourse("SER315");
        negativeStudents.set_points("Halo",-1);
        negativeStudents.set_points("Karly",-50);
        
        noStudents = createCourse("SER214");
        
        exceedingStudents = createCourse("SER218");
        exceedingStudents.set_points("Ken",101);
        exceedingStudents.set_points("Doll",200);
        
        zeroStudent = createCourse("SER415");
        zeroStudent.set_points("Katie",0);
        zeroStudent.set_points("Orie",0);
        
        fractionStudents = createCourse("SER412");
        fractionStudents.set_points("Katie",4/9);
        fractionStudents.set_points("Orie",1/3);
        
        // this would be the expected result after the method countOccurencesLetterGrades is called
        twoStudentExpected.put("A", 2);
        twoStudentExpected.put("B", 0);
        twoStudentExpected.put("C", 0);
        twoStudentExpected.put("D", 0);
        twoStudentExpected.put("F", 0);
        
        fiveStudentsExpected.put("A", 1);
        fiveStudentsExpected.put("B", 1);
        fiveStudentsExpected.put("C", 1);
        fiveStudentsExpected.put("D", 1);
        fiveStudentsExpected.put("F", 1);
        
        studentEdgeCasesExpected.put("A", 1);
        studentEdgeCasesExpected.put("B", 3);
        studentEdgeCasesExpected.put("C", 3);
        studentEdgeCasesExpected.put("D", 3);
        studentEdgeCasesExpected.put("F", 4);
        
        negativeStudentsExpected.put("A", 0);
        negativeStudentsExpected.put("B", 0);
        negativeStudentsExpected.put("C", 0);
        negativeStudentsExpected.put("D", 0);
        negativeStudentsExpected.put("F", 0);
        
        noStudentsExpected.put("A", 0);
        noStudentsExpected.put("B", 0);
        noStudentsExpected.put("C", 0);
        noStudentsExpected.put("D", 0);
        noStudentsExpected.put("F", 0);
        
        exceedingStudentExpected.put("A", 2);
        exceedingStudentExpected.put("B", 0);
        exceedingStudentExpected.put("C", 0);
        exceedingStudentExpected.put("D", 0);
        exceedingStudentExpected.put("F", 0);
        
        zeroStudentExpected.put("A", 0);
        zeroStudentExpected.put("B", 0);
        zeroStudentExpected.put("C", 0);
        zeroStudentExpected.put("D", 0);
        zeroStudentExpected.put("F", 2);
        
        fractionStudentsExpected.put("A", 0);
        fractionStudentsExpected.put("B", 0);
        fractionStudentsExpected.put("C", 0);
        fractionStudentsExpected.put("D", 1);
        fractionStudentsExpected.put("F", 1);
    }


    // Sample test
    @Test
    public void twoStudent() {
        HashMap<String, Integer> ans = twoStudent.countOccurencesLetterGrades();
        System.out.println(ans);
        assertTrue(ans.equals(twoStudentExpected));
    }
    
    //Testing five students each having a unique grade A-F
    @Test
    public void fiveStudents() {
        HashMap<String, Integer> ans = fiveStudents.countOccurencesLetterGrades();
        System.out.println("TESTING fiveStudents" + ans);
        assertTrue(ans.equals(fiveStudentsExpected));
    }
    
    //Testing edge cases for each grade
    @Test
    public void studentEdgeCases() {
        HashMap<String, Integer> ans = studentEdgeCases.countOccurencesLetterGrades();
        System.out.println("TESTING StudentEdgeCases" + ans);
        assertTrue(ans.equals(studentEdgeCasesExpected));
    }
    
    //Testing for negative values
    @Test
    public void negativeStudents() {
        HashMap<String, Integer> ans = negativeStudents.countOccurencesLetterGrades();
        System.out.println("TESTING negativeStudents" + ans);
        assertTrue(ans.equals(negativeStudentsExpected));
    }
    
    //Testing empty student set
    @Test
    public void noStudents() {
        HashMap<String, Integer> ans = noStudents.countOccurencesLetterGrades();
        System.out.println("TESTING noStudents" + ans);
        assertTrue(ans.equals(noStudentsExpected));
    }

    //Testing exceeding student set
    @Test
    public void exceedingStudents() {
        HashMap<String, Integer> ans = exceedingStudents.countOccurencesLetterGrades();
        System.out.println("TESTING exceedingStudents" + ans);
        assertTrue(ans.equals(exceedingStudentExpected));
    }

    //Testing zero score student set
    @Test
    public void zeroStudent() {
        HashMap<String, Integer> ans = zeroStudent.countOccurencesLetterGrades();
        System.out.println("TESTING zeroStudent" + ans);
        assertTrue(ans.equals(zeroStudentExpected));
    }
    
    //Testing zero score student set
    @Test
    public void fractionStudents() {
        HashMap<String, Integer> ans = fractionStudents.countOccurencesLetterGrades();
        System.out.println("TESTING fractionStudents" + ans);
        assertTrue(ans.equals(fractionStudentsExpected));
    }
}
