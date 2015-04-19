package com.example.applicationstudent;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import java.util.List;


@Stateless
public class StudentEJB implements StudentEJBRemote {
	
	@PersistenceContext(unitName = "StudentApplication", type = PersistenceContextType.EXTENDED)
	private EntityManager entityManager;
	
	// this method returns the list of students in the entity manger
	public List<Student> findStudents() {
		Query query = entityManager.createQuery("SELECT m from Student as m");
        return query.getResultList();	
	}
	
	// this method looks for a student in the entity manger given its Id
	@Override
	public Student findStudentBy(Long id) {
		Query query = entityManager.createQuery("SELECT m from Student as m");
        List<Student> listStudent=query.getResultList();
        for (Student temp : listStudent) {
			if (temp.getStudentID()==id){
				return temp;
			}
		}
		return null;
	}

	// this method adds a student to entity manger
	@Override
	public void createStudent(Student x) {
		entityManager.persist(x);
	}
    
	// This method removes a student to entity manger
	@Override
	public void deleteStudent(Student x) {
		entityManager.remove(x);	
	}

	// I don't know what should be the objective of this method
	@Override
	public Student updateStudent(Student x) {
		return null;
	}
}
