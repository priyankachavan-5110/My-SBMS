package in.ashokit.rest;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.exception.ExceptionInfo;

/*Local Exp Handling
handle exp of particular class only so that 
we use @ExceptionHandler Annotation on controller method*/

@RestController
public class MsgController {
	
	@GetMapping("/welcome")
	public String getWelcomeMsg()
	{
		int i=10/0;
		return "Welcome to ashokit...";
	}
	
	@ExceptionHandler(value=Exception.class)//this@ used Whenever Exp occur in our Controller class this method handle exp
	 										//(Exception.class)it handle all type of exception
	public ResponseEntity<ExceptionInfo>handelException(Exception e) 
	{
		ExceptionInfo info=new ExceptionInfo("Excp001",e.getMessage(),LocalDate.now());//if Exp occur show proper msg to client
		return new ResponseEntity<>(info,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	

}
