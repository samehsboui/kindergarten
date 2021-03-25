package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity 
@Table(name = "T_Admin")
public class Admin implements Serializable {
		

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="Admin_Id")
		private long id;
		
		@Column(name="Admin_FirstName")
		private String firstname;
		
		@Column(name="Admin_LastName")
		private String lastname;
		
		@Column(name="Admin_email")
		private String email;
		
		@Column(name="Admin_number_phone")
		private long number_phone;

		@OneToOne
		private User user;
		
		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public long getNumber_phone() {
			return number_phone;
		}

		public void setNumber_phone(long number_phone) {
			this.number_phone = number_phone;
		}
		
}
