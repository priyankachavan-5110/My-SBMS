package in.ashokit.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import in.ashokit.request.Passenger;
import in.ashokit.response.Ticket;
import reactor.core.publisher.Mono;

@Service
public class MakeMyTripServiceImpl implements MakeMyTripService {//this service class we implement integration logic for B2B 
	
	@Override
	public Mono<Ticket> bookTicket(Passenger passenger) {
		String apiUrl="http://34.217.24.220:8080/ticket"; //provider irctc url
		
		WebClient webclient=WebClient.create();
		Mono<Ticket> bodyToMono=webclient.post()
				.uri(apiUrl)
				.body(BodyInserters.fromValue(passenger))
				.retrieve()
				.bodyToMono(Ticket.class);
		
		return bodyToMono;
	}

	@Override
	public Mono<Ticket> getTicket(Integer ticketNum) {
		String apiUrl="http://34.217.24.220:8080/ticket/{ticketNum}";
		
		WebClient webclient=WebClient.create();
		Mono<Ticket> bodyToMono=webclient.get()
										.uri(apiUrl,ticketNum)
										.retrieve()
										.bodyToMono(Ticket.class);
	
		return bodyToMono;
	}
	@Override
	public Mono<Ticket[]> getAllTicket() {
		String apiUrl="http://34.217.24.220:8080/tickets";
		
		WebClient webclient=WebClient.create();
		Mono<Ticket[]> bodyToMono=webclient.get()
											.uri(apiUrl)
											.retrieve()
											.bodyToMono(Ticket[].class);
	
		return bodyToMono;
	}

}
