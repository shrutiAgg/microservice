package com.springframework.microservice.data.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.springframework.microservice.data.jpa.model.Ticket;
import com.springframework.microservice.data.jpa.repository.TicketRepository;

/**
* The TicketController is Controller class that receives HTTP Request to
* sell ticket
*
* @author  Shruti 
* @version 1.0
* @since   03-14-2019 
*/
@RestController
@RequestMapping("/postgressApp")
public class TicketController {
	
	@Autowired
	TicketRepository repository;

	/**
	   * This method is used to list down all tickets
	   * @param 
	   * @return List<Ticket> This returns list of Tickets
	  */	 
	@RequestMapping(value = "/tickets", method = RequestMethod.GET)
	public List<Ticket> getTickets() {
		return repository.findAll();
	}

	/**
	   * This method is used to add tickets
	   * @param Ticket
	   * @return 
	  */
	@RequestMapping(value = "/updateTicket", method = RequestMethod.POST)
	public void updateTickets(@RequestBody Ticket tkt) {
		repository.save(tkt);
	}
	
	/**
	   * This method is used to book tickets
	   * @param seatNo
	   * @return String This returns message whether ticket is booked or not
	  */
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