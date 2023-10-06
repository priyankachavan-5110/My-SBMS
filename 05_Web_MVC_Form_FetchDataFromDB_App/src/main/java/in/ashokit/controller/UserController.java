package in.ashokit.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import in.ashokit.binding.User;
import in.ashokit.service.UserService;
import jakarta.validation.Valid;

@Controller
public class UserController {
	@Autowired
	private UserService userservice;
	 
//view all users
	@GetMapping("/users")
	public String getAllUser(Model model) {
	
		model.addAttribute("userobj", userservice.getAllUsers());//
		return "view_user";
	}
	
//delete
	@GetMapping("/deleteUser")
	public String deleteUser(@RequestParam("id") Integer id,Model model) {
		String deleteUserById = userservice.deleteUserById(id);
		model.addAttribute("userobj",deleteUserById);
		model.addAttribute("msg","User deleted");
		return "forward:/users";
	}
	
	
//update
@GetMapping("/updateForm")
	public String updateUser(@RequestParam("id")Integer id, Model model) {

		User user = userservice.getUserById(id);
		
		model.addAttribute("userobj",user);
		//model.addAttribute("msg","User updated successfully");
		return "register";
	}
	
//load Empty form
	@GetMapping("/")
	public String loadForm(Model model) {
		model.addAttribute("userobj", new User());// "user" object name in form action

		System.out.println("in load form");
		//return "index";
		return "login";
	}
	
//form submission
	@GetMapping("/registeruser") // form action name
	public String handleSubmitButton(@ModelAttribute("userobj") @Valid User user, BindingResult result, Model model) {
		System.out.println("in register method");
		if (result.hasErrors()) {
			return "register";
		}
														// user input pass bcrypt and converted into hashvalue.plain password to encrypt
		String encodedpass = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(10));// salt is a random string
		user.setPassword(encodedpass);// set encoded pass
	
		boolean saveUser = userservice.saveUser(user);// save user to DB
		if (saveUser) {

			model.addAttribute("msg", "User data saved successfully..!!");
		}
		System.out.println(user.toString());

		return "register";
		//return "redirect:/userAccCreationSuccess";
	}

	/*
	 * @GetMapping("/registeruser") public String userAccCreationSuccess() { return
	 * "register"; }
	 */
	
//Login
  @PostMapping("/login")//email&pass come here
	public String handleLoginButton(@ModelAttribute("userobj") @RequestParam("email") String email,@RequestParam("password") String password,Model model) 
	{
		System.out.println("in login");
		User db= userservice.findUserByEmail(email);
		model.addAttribute("userobj",db);
		Boolean isPasswordMatch=BCrypt.checkpw(password,db.getPassword());
		if(isPasswordMatch)
		{
			model.addAttribute("msg", "Welcome..."+db.getName());
		}
		return "welcome";
	}	  
}

