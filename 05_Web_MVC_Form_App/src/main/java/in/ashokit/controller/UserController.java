package in.ashokit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import in.ashokit.binding.User;

@Controller
@RequestMapping("/user")
public class UserController {
@GetMapping("/")//no url pattern

public String loadForm(Model model)// form is load send empty obj to map fields to user obj
{//load form
	model.addAttribute("user",new User());
	return"index";
}

//handle form submission
@PostMapping("/user")//this method dispatcher servlet call
public String handleSubmitButton(User user,Model model)
{
	System.out.println(user);
	model.addAttribute("msg","User data save successfully");
	//store form data into DB
	return"success";
}
}
