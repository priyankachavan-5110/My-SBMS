package in.ashokit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.binding.Course;
import in.ashokit.repo.CourseRepository;

@Service //represent class as sprig bean
public class CourseServiceimpl implements CourseService
{
	@Autowired
	private CourseRepository courseRepo;//service class method should talk to repository methods 
	//This interface does not have implementation JPA will crate implementation at run time and inject implementation obj in service bean in runtime
	//by using this autowired we implement jpa repo methods
	
	@Override
	public String upsert(Course course) {
		courseRepo.save(course);//Upsert insert/update based on PK(if key is present then update otherwise insert )
		
		return "success";
	}

	@Override
	public Course getById(Integer cid) {
		Optional<Course>findById=courseRepo.findById(cid);//optional obj is introduced in J8,to avoid nullpointer Exp
		if(findById.isPresent())
		{
			return findById.get();
		}
		return null;
	}

	@Override
	public List<Course> getAllCourse() {
		return courseRepo.findAll();
		
	}

	@Override
	public String deleteById(Integer cid) {
		if(courseRepo.existsById(cid))//JPArepo method check existing id present or not
		{
			courseRepo.deleteById(cid);
		return "Delete success";
		}else{
			return "Entered id not found";}	
	}
	}
