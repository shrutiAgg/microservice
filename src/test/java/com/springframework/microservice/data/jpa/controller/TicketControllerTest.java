package com.springframework.microservice.data.jpa.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import com.springframework.microservice.data.jpa.model.Ticket;
import com.springframework.microservice.data.jpa.repository.TicketRepository;

public class TicketControllerTest {
	
	
	@InjectMocks
	TicketController controller;
     
    @Mock
    TicketRepository repository;
 
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void getAllTicketsTest()
    {
        List<Ticket> list = new ArrayList<Ticket>();
        Ticket ticket1 = new Ticket(1,40, "Available", "3A");
        Ticket ticket2 = new Ticket(2,40, "Available", "3B");
         
        list.add(ticket1);
        list.add(ticket2);
        Mockito.when(repository.findAll()).thenReturn(list);
        List<Ticket> ticketList = controller.getTickets();
        assertEquals(2, ticketList.size());
        Mockito.verify(repository, Mockito.times(1)).findAll();
    }
    
    @Test
    public void addTicketsTest()
    {
    	Ticket ticket = new Ticket(1,30,"Available","4B");
    	controller.updateTickets(ticket);
        Mockito.verify(repository, Mockito.times(1)).save(ticket);
    }
    
    @Test
    public void bookTicketsSuccessTest()
    {
        Ticket ticket = new Ticket(1,40, "Available", "3A");
    	List<Ticket> lst=new ArrayList<Ticket>();
    	lst.add(ticket);
    	Mockito.when(repository.findBySeatNo(ticket.getSeatNo())).thenReturn(lst);
    	String result = controller.bookTicket(ticket.getSeatNo());
    	assertEquals("Your ticket is booked", result);
    }
    
    @Test
    public void bookTicketsFailureTest()
    {
        Ticket ticket = new Ticket(1,40, "Booked", "3A");
    	List<Ticket> lst=new ArrayList<Ticket>();
    	Mockito.when(repository.findBySeatNo(ticket.getSeatNo())).thenReturn(lst);
    	String result = controller.bookTicket(ticket.getSeatNo());
    	assertEquals("This ticket is already booked", result);
    }

}
