package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "T_Child")
public class Child implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Child_Id")
	private long id;
	
	@Column(name="Child_FirstName")
	private String firstname;
	
	@Column(name="Child_LastName")
	private String lastname;
	
	@Column(name="Child_Class")
	private String Class;
	
	@Column(name="Child_Age")
	private long Age;

}
