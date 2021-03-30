package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity 
@Table(name = "t_kindergarten")
public class Kindergarten implements Serializable{
		
			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			@Column(name="Kindergarten_id")
			private long id;
			
			@Column(name="Kindergarten_Name")
			private String name;
			
			@Column(name="Kindergarten_Address")
			private String adress;
			
			@Column(name="Kindergarten_Email")
			private String email;
			
			@Column(name="Employee_phone_number")
			private long phone_number;
			
			@OneToMany(targetEntity = Events.class, mappedBy = "id", orphanRemoval = false, fetch = FetchType.LAZY)
			private Set<Events> events;
			
			public long getId() {
				return id;
			}

			public void setId(long id) {
				this.id = id;
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			public String getAdress() {
				return adress;
			}

			public void setAdress(String adress) {
				this.adress = adress;
			}

			public String getEmail() {
				return email;
			}

			public void setEmail(String email) {
				this.email = email;
			}

			public long getPhone_Number() {
				return phone_number;
			}

			public void setPhone_Number(long phone_number) {
				this.phone_number = phone_number;
			}

			public Kindergarten(String name, String adress, String email, long phone_number) {
				super();
				this.name = name;
				this.adress = adress;
				this.email = email;
				this.phone_number = phone_number;
			}

			public Kindergarten() {
				super();
			}
			
}
