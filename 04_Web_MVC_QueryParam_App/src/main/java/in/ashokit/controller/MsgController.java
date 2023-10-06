package in.ashokit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
						//QueryParameter
public class MsgController {//in query parameter data expose in url.we should not use this apporch to send confidential data pass,pin
	@GetMapping("/greet")
	public String greetMsg(@RequestParam("name") String name,Model model)// used to read data in query parameter key is name
	{
		String msgTxt="Good mrng,"+name;
		model.addAttribute("msg",msgTxt);//send data to UI
		return "index";
	}
	@GetMapping("/enquiry")
	public String getInfo(@RequestParam("course") String course,@RequestParam("trainer") String trainer,Model model)
	{
		System.out.println("Course"+course);
		System.out.println("trainer"+trainer);
		model.addAttribute("msg","contact:34636");
		return"index";
	}
	
	
	//
	

}
