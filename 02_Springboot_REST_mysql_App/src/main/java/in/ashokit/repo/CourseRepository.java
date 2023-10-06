package in.ashokit.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.ashokit.binding.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Serializable> //its type of primaykey value
{

}
