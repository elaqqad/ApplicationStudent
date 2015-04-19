package com.example.applicationstudent;

import java.util.List;

public interface StudentEJBRemote {
	
	// This interface contains the methods that we should implement in StudentEJB
	public List<Student> findStudents();
	public Student findStudentBy(Long id);
	public void createStudent(Student x);
	public void deleteStudent(Student x);
	public Student updateStudent(Student x);
}
