package in.ashokit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import in.ashokit.request.Passenger;
import in.ashokit.response.Ticket;
import in.ashokit.service.MakeMyTripService;

@Controller// (CTB)bcz we take req from UI and response to UI
public class MakeMyTripController {
	
	@Autowired
	private MakeMyTripService service;
	
//load form
@GetMapping("/")
	public String index(Model model)
	{
		model.addAttribute("passenger", new Passenger());
		return "index";
	}
//Book ticket
@PostMapping("/ticket")
public String handelBookTicket(Passenger passenger,Model model)
{
	Ticket ticket = service.bookTicket(passenger);
	model.addAttribute("ticket",ticket);
	return "view-ticket";
}

@GetMapping("/tickets")
public String viewTickets(Model model)
{
	List<Ticket> allTicket = service.getAllTicket();
	model.addAttribute("ticket", allTicket);
	return "all-data";
}
//to display empty search page 
@GetMapping("/search")
public String search(Model model)
{
	model.addAttribute("ticket",new Ticket());//send empty obj to load page
	return "search";
}
@PostMapping("/search-ticket")
public String searchTicket(@RequestParam("ticketNum") Integer ticketNum,Model model)
{
	Ticket ticket = service.getTicket(ticketNum);
	model.addAttribute("ticket", ticket);
	return"search";
	}

}
