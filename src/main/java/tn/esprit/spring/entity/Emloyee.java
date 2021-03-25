package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity 
@Table(name = "T_Employee")
public class Emloyee implements Serializable {
	

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="Employee_Id")
		private long id;
		
		@Column(name="Employee_FirstName")
		private String firstname;
		
		@Column(name="Employee_LastName")
		private String lastname;
		
		@Column(name="Employee_Email")
		private String email;
		
		@Column(name="Employee_number_phone")
		private long number_phone;
		
		@Column(name="Employee_Post")
		@Enumerated(EnumType.STRING)
		private Post post ;
		
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

		public Post getPost() {
			return post;
		}

		public void setPost(Post post) {
			this.post = post;
		}

	}
