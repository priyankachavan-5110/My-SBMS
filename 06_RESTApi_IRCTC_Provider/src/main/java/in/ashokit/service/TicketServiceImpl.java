package in.ashokit.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.ashokit.entity.Ticket;
import in.ashokit.repo.TicketRepo;
import in.ashokit.request.Passenger;

@Service
public class TicketServiceImpl  implements TicketService{
	@Autowired
	private TicketRepo repo;
	
	@Override
	public Ticket bookTicket(Passenger passenger) {
		Ticket ticket=new Ticket();
		//copy data from one obj to another obj,if two classes variables are same
		BeanUtils.copyProperties(passenger,ticket); //copy passenger data obj to Ticket obj
		ticket.setPrice(1500.00);
		ticket.setTicketStatus("Confirmed");
		ticket = repo.save(ticket);
		return ticket;
	}

	@Override
	public Ticket getTicket(Integer ticketNum) {
		Optional<Ticket> findById = repo.findById(ticketNum);
		if(findById.isPresent())
		{
			return findById.get();
		}
		return null;
	}

	@Override
	public List<Ticket> getAllTicket() {
		
		return repo.findAll();
	}

}
