package in.ashokit.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import in.ashokit.entity.Ticket;
import in.ashokit.request.Passenger;
import in.ashokit.service.TicketService;

@RestController //bcz (BTB)provider= it provide business services to other application Ex-IRCTC to MakeMyTrip
public class TicketRestController {
	
	@Autowired
	private TicketService service;
	
	@PostMapping(value="/ticket",consumes="application/json",produces="application/json")
	public ResponseEntity<Ticket> bookTicket(@RequestBody Passenger passenger)  															//when we use requestBody then we write consumes
	{
		Ticket ticket = service.bookTicket(passenger);
		return new ResponseEntity<>(ticket,HttpStatus.CREATED);
	}
	
	@GetMapping(value="/ticket/{ticketNum}",produces="application/json")
	public ResponseEntity<Ticket> getTicket(@PathVariable("ticketNum") Integer ticketNum)
	{
		Ticket ticket = service.getTicket(ticketNum);
		return new ResponseEntity<>(ticket,HttpStatus.OK);
	}
	
	@GetMapping(value="/tickets",produces="application/json")
	public ResponseEntity<List<Ticket>> getAllTicket()
	{
		List<Ticket> allTicket = service.getAllTicket();
		return new ResponseEntity<>(allTicket,HttpStatus.OK);
	}
	
	
	
	
	
	

}
