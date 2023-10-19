package in.ashokit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import in.ashokit.Entity.Book;


/* Without writing RestController class and lot of code
  easy we can perform CRUD operation using DataRest. 
  for complex operation it will not recommended.
  repository expose as RestApi
*/
@RepositoryRestResource(path="books")//to expose our repository as rest api method(restcontroller)
public interface BookRepository extends JpaRepository<Book, Integer> {
	@Override
	@RestResource(exported = false)
	void deleteById(Integer bookid);
	@Override
	@RestResource(exported = false)
	Book save(Book book);

}
