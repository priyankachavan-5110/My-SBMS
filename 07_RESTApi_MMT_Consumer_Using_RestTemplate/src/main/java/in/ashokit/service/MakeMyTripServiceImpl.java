package in.ashokit.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import in.ashokit.request.Passenger;
import in.ashokit.response.Ticket;

@Service
public class MakeMyTripServiceImpl implements MakeMyTripService {//this service class we implement integration logic for B2B 

	
	@Override
	public Ticket bookTicket(Passenger passenger) {
		String apiUrl="http://34.217.24.220:8080/ticket";
		//String apiUrl="http://localhost:8080/ticket"; //provider irctc url
		
		RestTemplate rt=new RestTemplate();// RestTemplate object send request to REST Api(from MMT to IRCTC)
		
		ResponseEntity<Ticket> responseEntity = rt.postForEntity(apiUrl, passenger,Ticket.class); //send post req to given url(apiUrl,reqBodyData,resBodyType).we send data to provider application,here we are not sending data to database
		Ticket responseBody = responseEntity.getBody();//responseBody convert into  Ticket obj
		return responseBody;
	}

	@Override
	public List<Ticket> getAllTicket() {
		String apiUrl="http://34.217.24.220:8080/tickets";
		
		RestTemplate rt=new RestTemplate();
		ResponseEntity<Ticket[]> responseEntity = rt.getForEntity(apiUrl,Ticket[].class);//it give ticket array(All tickets)
		Ticket[] body = responseEntity.getBody();
		List<Ticket> tickets = Arrays.asList(body);
		 return tickets;
	}

	@Override
	public Ticket getTicket(Integer ticketNum) {
		String apiUrl="http://34.217.24.220:8080/ticket/{ticketNum}";
		
		RestTemplate rt=new RestTemplate();
		ResponseEntity<Ticket> responseEntity = rt.getForEntity(apiUrl,Ticket.class,ticketNum);
		Ticket body = responseEntity.getBody();
		return body;
	}

}
