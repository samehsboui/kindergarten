package tn.esprit.spring.dto.request;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CreateEventsRequest {

	private long id;

	private String event_name;

	private String type;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date date;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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
	
	


}
