package in.ashokit.service;

import java.util.List;

import in.ashokit.entity.Ticket;
import in.ashokit.request.Passenger;

public interface TicketService {
	
	public Ticket bookTicket(Passenger passenger);	//take passenger data as i/p-->return ticket data as o/p
	
	public Ticket getTicket(Integer ticketNum);	//take ticketNum as i/p--> ticket data as o/p
	
	public List<Ticket>getAllTicket();

}
