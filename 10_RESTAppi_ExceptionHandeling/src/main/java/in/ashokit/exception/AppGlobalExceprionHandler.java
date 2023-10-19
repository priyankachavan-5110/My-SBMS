package in.ashokit.exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/*To handle Global Excp we write 
  Class level Annotation @RestControllerAdvice. Excp occur in any class it can handle
  Method level Annotation @ExceptionHandler. Excp occur in any method it can handle
*/

@RestControllerAdvice 
public class AppGlobalExceprionHandler {
									//Exception.class support for any type of Excp
	@ExceptionHandler(value=Exception.class) 
	public ResponseEntity<ExceptionInfo>handelException(Exception e) //handle all Exceptions
	{
			
		ExceptionInfo info=new ExceptionInfo("Excp001",e.getMessage(),LocalDate.now());//if Exp occur show proper msg to clint
		
		return new ResponseEntity<>(info,HttpStatus.INTERNAL_SERVER_ERROR);//Show meaning full msg we use responseEntity in that we set body and status code.
	}
	@ExceptionHandler(value=ProductNotFoundException.class)
	public ResponseEntity<ExceptionInfo>handelProductNotFountExcp(ProductNotFoundException e)//handle ProductNFE 
	{
		ExceptionInfo info=new ExceptionInfo("Excp002",e.getMessage(),LocalDate.now());
		
		return new ResponseEntity<ExceptionInfo>(info,HttpStatus.BAD_REQUEST);
	}

}
