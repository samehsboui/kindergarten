package tn.esprit.spring.dto.request;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import tn.esprit.spring.entity.Kindergarten;

public class CreateEventsRequest {

	private String event_name;

	private String type;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date date;
	
	private Kindergarten kindergarten;

	public String getEvent_name() {
		return event_name;
	}

	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Kindergarten getKindergarten() {
		return kindergarten;
	}

	public void setKindergarten(Kindergarten kindergarten) {
		this.kindergarten = kindergarten;
	}

}
