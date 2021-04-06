package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity 
@Table(name = "T_Events")
public class Events implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Event_id")
	private long id;
	
	
	@Column(name="Event_Name")
	private String event_name;
	
	@ManyToOne
    @JoinColumn(name = "Kindergarten_id")
    private Kindergarten kindergarten;
	
//	@OneToMany(targetEntity = Feedback.class, mappedBy = "id", orphanRemoval = false, fetch = FetchType.LAZY)
//	private Feedback feedback;
//	
	@Column(name="Type")
	private String type;
	
	
	@Column(name="User_Date")
	@Temporal(TemporalType.DATE)
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


	public Events() {
		super();
	}


	public Events(String event_name, Kindergarten kindergarten, String type, Date date) {
		super();
		this.event_name = event_name;
		this.kindergarten = kindergarten;
//		this.feedback = feedback;
		this.type = type;
		this.date = date;
	}


	
	
	
}



