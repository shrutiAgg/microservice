package com.springframework.microservice.data.jpa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tickets")
public class Ticket implements Serializable  {

	@Id
	@GeneratedValue
	private long id;
	
	@Column(name = "price")
	private int price;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "seatno")
	private String seatNo;

	public Ticket() {
		super();
	}
	
	
	public Ticket(long id, int price, String status, String seatNo) {
		super();
		this.id = id;
		this.status = status;
		this.price = price;
		this.seatNo = seatNo;
	}


	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return String.format("Tickets[id=%d, price='%s', status='%s', seatNo='%s']", id, price, status, seatNo);
	}

}
