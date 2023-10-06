package in.ashokit.service;

import java.util.List;

import in.ashokit.binding.Course;

public interface CourseService {
	
public String upsert(Course course);//it is polymorphic metghod.single method( update&insert)
public Course getById(Integer cid);//get single course data using id
public List<Course> getAllCourse();//get all courses 
public String deleteById(Integer cid);//delete particular id data



}
