package com.springframework.microservice.data.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springframework.microservice.data.jpa.model.Ticket;

/**
* The TicketRepository is Repository class that will connect to database to
* get ticket data
*
* @author  Shruti 
* @version 1.0
* @since   03-14-2019 
*/
@Repository("TicketRepository")
public interface  TicketRepository extends JpaRepository<Ticket, Long> {
	
	@Query(value="SELECT * FROM tickets  WHERE seatno= ?1 and status='Available'", nativeQuery=true)
	public List<Ticket> findBySeatNo(String seatNo);
}
