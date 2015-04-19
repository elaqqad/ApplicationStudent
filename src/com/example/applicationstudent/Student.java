package com.example.applicationstudent;


import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Student implements Serializable {
	
	 private static final long serialVersionUID = 1L;
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private Long studentID; 
	 private String name;
	 private String address;
	 private int age; 
	 
	 public Student(Long id,String na,String add, int ag){
		 studentID=id;
		 name=na;
		 address=add;
		 age=ag;
	 }
	
	 public Long getStudentID() {
		 return studentID;
	 }
	 
	 public void setStudentID(Long studentID) {
		 this.studentID = studentID;
	 }
	 
	 public String getName() {
		 return name;
	 }
	
	 public void setName(String name) {
		 this.name = name;
	 }
	 
	 public String getAddress() {
		 return address;
	 }
	
	 public void setAddress(String address) {
		 this.address = address;
	 }
	
	 public int getAge() {
		 return age;
	 }
	
	 public void setAge(int age) {
		 this.age = age;
	 }

}
