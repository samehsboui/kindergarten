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
@Table(name = "T_Parent")
public class Parent implements Serializable {

			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			@Column(name="Parent_Id")
			private long id;
			
			@Column(name="Parent_CIN")
			private long cin;
			
			@Column(name="Parent_FirstName")
			private String firstname;
			
			@Column(name="Parent_LastName")
			private String lastname;
			
			@Column(name="Parent_email")
			private String email;
			
			@Column(name="Parent_number_phone")
			private long number_phone;
			
//			@OneToOne
//			private User user;

			public long getId() {
				return id;
			}

			public void setId(long id) {
				this.id = id;
			}

			public long getCin() {
				return cin;
			}

			public void setCin(long cin) {
				this.cin = cin;
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


