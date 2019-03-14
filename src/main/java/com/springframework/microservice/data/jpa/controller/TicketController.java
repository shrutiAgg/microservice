package com.springframework.microservice.data.jpa.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.springframework.microservice.data.jpa.model.Ticket;
import com.springframework.microservice.data.jpa.repository.TicketRepository;
//import com.springframework.microservice.data.jpa.service.TicketService;

@RestController
@RequestMapping("/postgressApp")
public class TicketController {
	/*@Resource
	TicketService ticketService;*/
	
	@Autowired
	TicketRepository repository;


	@RequestMapping(value = "/tickets", method = RequestMethod.GET)
	public List<Ticket> getTickets() {
		return repository.findAll();
	}

	@RequestMapping(value = "/updateTicket", method = RequestMethod.POST)
	public void updateTickets(@RequestBody Ticket tkt) {
		repository.save(tkt);
	}
	
	@RequestMapping(value = "/bookTicket/{seatNo}", method = RequestMethod.PUT)
	public String bookTicket(@PathVariable String seatNo) {
		List<Ticket> tkt = repository.findBySeatNo(seatNo);
		if(tkt.size()<1) {
			return "This ticket is already booked";
		}
		else {
			Ticket ticket = tkt.get(0);
			ticket.setStatus("Booked");
			repository.save(ticket);
			return "Your ticket is booked";
		}
		
	}

}