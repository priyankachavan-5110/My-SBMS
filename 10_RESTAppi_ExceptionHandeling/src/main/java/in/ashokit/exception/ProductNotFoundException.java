package in.ashokit.exception;

// create Custom Exception class extends with Exception class 

public class ProductNotFoundException extends Exception {

	public ProductNotFoundException()//Default Constructor
	{
		
	}
	public ProductNotFoundException(String msg)//parameterized constructor
	{
		super(msg);
	}

}
