package test.java;

import static org.junit.Assert.*;

import org.junit.Before;

import org.junit.Test;

import main.java.Course;
import main.java.Major;
import main.java.Student;

public class CourseTest {
    Course oneStudent;
    Course oneStudentUnderZero;
    Course twoStudents;
    Course twoStudents2;
    Course twoStudents3;
    Course twoStudents4;
    Course fourStudents;
    Course fourStudents2;
    Course listOfStudents;
    //SER316 TASK 2 SPOT-BUGS FIX (courses not
    //used were removed
    
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testAverageWithoutMinWithoutMax() {
        // oneStudent testing method calculateAverageWithoutMinWithoutMax LOC 85-89-90
        oneStudent = new Course("SER316");
        oneStudent.set_points("Hanna", 50);
        double ans = oneStudent.calculateAverageWithoutMinWithoutMax();
        assertTrue(ans == 50.0);
        
        //oneStudentUnderZero with grade less than 0, testing LOC 85-86-87
        oneStudentUnderZero = new Course("SER317");
        oneStudentUnderZero.set_points("Frank", -10);
        double ans2 = oneStudentUnderZero.calculateAverageWithoutMinWithoutMax();
        assertTrue(ans2 == 0);
        
        //twoStudents, fist one with grade less than 0, testing LOC 85-94-95-96
        twoStudents = new Course("SER318");
        twoStudents.set_points("Joe", -30);
        twoStudents.set_points("Billy", 70);
        double ans3 = twoStudents.calculateAverageWithoutMinWithoutMax();
        assertTrue(ans3 == 70);
        
        //twoStudents2, second one with grade less than 0, testing LOC 85-94-95-98-99
        twoStudents2 = new Course("SER319");
        twoStudents2.set_points("Sirus", 100);
        twoStudents2.set_points("Ken", -40);
        double ans4 = twoStudents2.calculateAverageWithoutMinWithoutMax();
        assertTrue(ans4 == 100);
        
        //twoStudents3 both with grades less than 0, LOC 85-94-95-101-102
        twoStudents3 = new Course("SER326");
        twoStudents3.set_points("Paul", -20);
        twoStudents3.set_points("Geo", -10);
        double ans5 = twoStudents3.calculateAverageWithoutMinWithoutMax();
        assertTrue(ans5 == 0);
        
        //twoStudents4 both with passing grades, testing LOC 85-94-95-104-105
        twoStudents4 = new Course("SER336");
        twoStudents4.set_points("Joe", 80);
        twoStudents4.set_points("Billy", 70);
        double ans6 = twoStudents4.calculateAverageWithoutMinWithoutMax();
        assertTrue(ans6 == 75);
        
        //fourStudents all with passing grades, testing LOC 85-94-110-111-112-113-114-115-116-
        //117-118-119-120-121-122-123-124-125
        fourStudents = new Course("SER346");
        fourStudents.set_points("Nick", 30);
        fourStudents.set_points("Po", 40);
        fourStudents.set_points("Tim", 50);
        fourStudents.set_points("Yang", 60);
        double ans7 = fourStudents.calculateAverageWithoutMinWithoutMax();
        assertTrue(ans7 == 45);
        
        //fourStudents2 one with a negative grade, testing LOC 85-94-110-111-112-113-114-115-116-
        //117-118-119-120-121-122-123-124-125
        fourStudents2 = new Course("SER356");
        fourStudents2.set_points("Nick", 30);
        fourStudents2.set_points("Po", 50);
        fourStudents2.set_points("Tim", 60);
        fourStudents2.set_points("Yang", -40);
        double ans8 = fourStudents2.calculateAverageWithoutMinWithoutMax();
        assertTrue(ans8 == 50);      
        
    }
    
    @Test
    public void test_set_points() {
	// oneStudent tests set_points LOC 133-134-135
    oneStudent = new Course("SER316");
    oneStudent.set_points("Hanna", 50);
    double ans = oneStudent.calculateAverageWithoutMinWithoutMax();
    assertTrue(ans == 50.0);
    }
    
    @Test
    public void test_addStudent() {
    	//Test students with same asurite
        listOfStudents = new Course("SER399");
        listOfStudents.set_points("Hannah", 50);
        Student Freddy = new Student("aminor1", Major.SER);
        Student Bob = new Student("aminor1", Major.SER);
        assertTrue(listOfStudents.addStudent(Freddy));
        assertTrue(listOfStudents.addStudent(Bob));
    }

}
