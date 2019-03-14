package com.springframework.microservice.data.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springframework.microservice.data.jpa.repository.TicketRepository;

/**
* The TicketRestApplication is an application that
* sells ticket
*
* @author  Shruti 
* @version 1.0
* @since   03-14-2019 
*/
@SpringBootApplication(scanBasePackages="com.springframework")
public class TicketRestApplication  {

	@Autowired
	TicketRepository repository;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(TicketRestApplication.class, args);
	}
	

}
