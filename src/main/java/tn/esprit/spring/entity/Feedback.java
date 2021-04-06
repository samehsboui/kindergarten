package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_Feedback")

public class Feedback implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Feedback_Id")
	private long id;
	
	@Column(name="Message_Date")
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Column(name="note_ambiance")
	private int note_ambiance;
	
	@Column(name="note_emplacement")
	private int note_emplacement;
	
	@Column(name="note_organisation")
	private int note_organisation;
	
	@Column(name="note_objectifsEvent")
	private int note_objectifsEvent;
	
	@Column(name="note_experience")
	private int note_experience;
	
	@ManyToOne
    @JoinColumn(name = "Event_id")
    private Events events;

	public Feedback(Date date, int note_ambiance, int note_emplacement, int note_organisation, int note_objectifsEvent,
			int note_experience, Events events) {
		super();
		this.date = date;
		this.note_ambiance = note_ambiance;
		this.note_emplacement = note_emplacement;
		this.note_organisation = note_organisation;
		this.note_objectifsEvent = note_objectifsEvent;
		this.note_experience = note_experience;
		this.events = events;
	}

	public Feedback() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getNote_ambiance() {
		return note_ambiance;
	}

	public void setNote_ambiance(int note_ambiance) {
		this.note_ambiance = note_ambiance;
	}

	public int getNote_emplacement() {
		return note_emplacement;
	}

	public void setNote_emplacement(int note_emplacement) {
		this.note_emplacement = note_emplacement;
	}

	public int getNote_organisation() {
		return note_organisation;
	}

	public void setNote_organisation(int note_organisation) {
		this.note_organisation = note_organisation;
	}

	public int getNote_objectifsEvent() {
		return note_objectifsEvent;
	}

	public void setNote_objectifsEvent(int note_objectifsEvent) {
		this.note_objectifsEvent = note_objectifsEvent;
	}

	public int getNote_experience() {
		return note_experience;
	}

	public void setNote_experience(int note_experience) {
		this.note_experience = note_experience;
	}

	public Events getEvents() {
		return events;
	}

	public void setEvents(Events events) {
		this.events = events;
	}

	
}
