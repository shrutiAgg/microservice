package com.springframework.microservice.data.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springframework.microservice.data.jpa.model.Ticket;

@Repository("TicketRepository")
public interface  TicketRepository extends JpaRepository<Ticket, Long> {
	
	@Query(value="SELECT * FROM tickets  WHERE seatno= ?1 and status='Available'", nativeQuery=true)
	public List<Ticket> findBySeatNo(String seatNo);
}
