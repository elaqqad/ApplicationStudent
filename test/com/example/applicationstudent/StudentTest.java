package com.example.applicationstudent;


import junit.framework.TestCase;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import java.util.List;
import java.util.Properties;

//START SNIPPET: code
public class StudentTest extends TestCase {

    public void test() throws Exception {
        
    	// setting the properties 
        final Properties p = new Properties();
        p.put("Database", "new://Resource?type=DataSource");
        p.put("StudentDatabase.JdbcDriver", "org.hsqldb.jdbcDriver");
        p.put("StudentDatabase.JdbcUrl", "jdbc:hsqldb:mem:moviedb");

        final Context context = EJBContainer.createEJBContainer(p).getContext();
 
        StudentEJB student = (StudentEJB) context.lookup("java:global/injection-of-entitymanager/Student");
        
        // adding students to the list of students student
        student.createStudent(new Student(new Long(124548),"John nach", "Grand Bretagne", 92));
        student.createStudent(new Student(new Long(122548),"Hilbert da", "France", 92));
        student.createStudent(new Student(new Long(895658),"Always me", "In nancy", 92));
        
        // Testing the size
        List<Student> list = student.findStudents();
        assertEquals("List.size()", 3, list.size());

        for (Student stud : list) {
            student.deleteStudent(stud);
        }
       
         //testing the size again
        assertEquals("Movies.getMovies()", 0, student.findStudents().size());
    }
}