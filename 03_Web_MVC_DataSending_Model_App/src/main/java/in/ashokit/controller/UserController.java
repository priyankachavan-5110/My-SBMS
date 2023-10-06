package in.ashokit.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import in.ashokit.binding.User;
@Controller
public class UserController {
	
	@GetMapping("/users")
	public String getUsers(Model model)//interface
	{
		User u1=new User(100,"Ashok","ashok@gmail");
		User u2=new User(101,"Ram","ram@gmail");
		User u3=new User(102,"Shyam","shyam@gmail");
		List<User>userList=Arrays.asList(u1,u2,u3);
		
		model.addAttribute("userData",userList);//key string value List
		return "view-users";
	}
	
	@GetMapping("/user")
	public String getUserData(Model model)
	{
		User userobj=new User(100,"Ashok","ashok@gmail");
		model.addAttribute("user",userobj);//key string value obj
		return "user-data";
	}
	
	@GetMapping("/email")
	public String getUserEmail(Model model)//it provides methods to send data from controller to UI in key value pair
	{
		model.addAttribute("email","priyanka@gmail.com");
		return "index";//model obj data access in view page
	}
	
	
	@GetMapping("/name")
	public ModelAndView getUserName()
	{
		ModelAndView mav=new ModelAndView();//is a class
		//set data to model
		mav.addObject("name","Ashok");//key string value string
		//set view name
		mav.setViewName("index");
		
		return mav;
	}

}
