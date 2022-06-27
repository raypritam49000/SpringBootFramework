package com.jersey.rest.webservices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jersey.rest.model.Student;

@Path("student")
public class StudentResources {
	public static List<Student> students;
	static 
	{
		students = new ArrayList<Student>();
		Student st1 = new Student(1,"Pritam Ray","Ropar","8699535682");
		Student st2 = new Student(2,"Amit Kumar","UK","7009842345");
		Student st3 = new Student(3,"Raj Kumar","Prem Nagar","86091265682");
		Student st4 = new Student(4,"Omi Verma","Asron","7700535682");
		students.addAll(Arrays.asList(st1,st2,st3,st4));
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("allstudent")
	public List<Student> getAllStudent(){
		return students;
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("studentbyid/{id}")
	public Student getStudent(@PathParam("id") int id) {
		return students.stream().filter(e->e.getId()==id).collect(Collectors.toList()).get(0);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("add")
	public String createStudent(Student st) {
		students.add(st);
		return "Student are Added Successfully";
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("delete/{id}")
	public String deleteStudent(@PathParam("id") int id) {
		Optional<Student> optional = students.stream().filter(e->e.getId()==id).findFirst();
		Student student = optional.get();
		students.remove(student);
		return "Student are delete successfully";
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("update/{id}")
	public String updateStudent(@PathParam("id") int id,Student st) {
		Student st1 = students.stream().filter(e->e.getId()==id).findFirst().get();
		st1.setId(id);
		st1.setCity(st.getCity());
		st1.setName(st.getName());
		st1.setPhone(st.getPhone());
		return "Student are update successfully";
	}
	
}
