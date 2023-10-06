package in.ashokit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CourseController {//Path Parameter
	@GetMapping("/course/{cname}")//("/course/{cname}/info")
public String getCourseInfo(@PathVariable("cname") String cname,Model model)//in Pathvariable represent value directly
{
		String msgTxt=cname+"devops new batch";
		model.addAttribute("msg",msgTxt);	
		return"index";
	}
}
