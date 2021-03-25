package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity 
@Table(name = "T_Claim")
public class Claim implements Serializable  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Claim_Id")
	private long id;
	
		@Column(name="Claim_Date")
		@Temporal(TemporalType.DATE)
		private Date date;
		
		@Column(name="Claim_Subject")
		private String subject;
		
		@Column(name="Claim_Text")
		private String text;
		
//		@ManyToOne
//		User user;

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

		public String getSubject() {
			return subject;
		}

		public void setSubject(String subject) {
			this.subject = subject;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}
	}


