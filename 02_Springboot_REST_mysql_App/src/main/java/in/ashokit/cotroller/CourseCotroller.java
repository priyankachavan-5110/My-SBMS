package in.ashokit.cotroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.binding.Course;
import in.ashokit.service.CourseService;

@RestController
public class CourseCotroller {
	@Autowired
	private CourseService courseService;
	
	
	@GetMapping("/course/{cid}")
	public ResponseEntity<Course>getCourse(@PathVariable Integer cid)   //Pathvariable to read data from URL
	{
		Course course =courseService.getById(cid);
		return new ResponseEntity<>(course,HttpStatus.OK);   //Response sending Course data (for Get Request  we give ok)
	}
	@GetMapping("/courses")
	public ResponseEntity<List<Course>>getAllCourses()
	{
		List<Course>allcourses=courseService.getAllCourse();
		return new ResponseEntity<>(allcourses,HttpStatus.OK);
		
	}
	@PostMapping("/course")
	public ResponseEntity<String> createCourse(@RequestBody Course course) //to read data from Reqbody in Reqbody json data will come.that json data converted into java obj Ex-course
	{
		String status=courseService.upsert(course);
		return new ResponseEntity<>(status,HttpStatus.CREATED);  //(for Post Request  we give created)
	}
	
	@PutMapping("/course")
	public ResponseEntity<String> updateCourse(@RequestBody Course course)//if secret data or sensitive data we send through Request body
	{
		String status= courseService.upsert(course);
		System.out.println(status);
		return new ResponseEntity<>(status,HttpStatus.OK);
	}
	@DeleteMapping("/course/{cid}")
	public ResponseEntity<String> deleteCourse(@PathVariable Integer cid)//send/read data from  url
	{
		System.out.println("Id to delete record: "+cid);
		String status =courseService.deleteById(cid);
		return new ResponseEntity<>(status,HttpStatus.OK);
	
	
}
}
