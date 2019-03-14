package com.springframework.microservice.data.jpa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* The Ticket is an Entity class which will be mapped to Database columns
*
* @author  Shruti 
* @version 1.0
* @since   03-14-2019 
*/
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


	/**
	   * This method is used to get ticket Id
	   * @return long This returns ticket Id
	  */
	public long getId() {
		return id;
	}
	

	/**
	   * This method is used to set ticket Id
	   * @param long 
	  */
	public void setId(long id) {
		this.id = id;
	}


	/**
	   * This method is used to get ticket price
	   * @return int This returns ticket price
	  */
	public int getPrice() {
		return price;
	}

	/**
	   * This method is used to set ticket price
	   * @param int
	  */
	
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	   * This method is used to get ticket seatNo
	   * @return String This returns ticket seatNo
	  */
	public String getSeatNo() {
		return seatNo;
	}

	/**
	   * This method is used to set ticket seatNo
	   * @param int 
	  */
	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}

	/**
	   * This method is used to get ticket status
	   * @return String returns ticket status 
	  */
	public String getStatus() {
		return status;
	}

	/**
	   * This method is used to set ticket status
	   * @param String 
	  */
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return String.format("Tickets[id=%d, price='%s', status='%s', seatNo='%s']", id, price, status, seatNo);
	}

}
