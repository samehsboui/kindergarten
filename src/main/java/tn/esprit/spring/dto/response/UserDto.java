package tn.esprit.spring.dto.response;

import java.util.HashSet;
import java.util.Set;


import tn.esprit.spring.entity.Role;

public class UserDto {


	private String fullName;
	private String email;
	private String address;
	private String tel;
	private Set<Role> roles = new HashSet<>();

	
	
	public UserDto(String fullName, String email, String address, String tel, Set<Role> roles) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.address = address;
		this.tel = tel;
		this.roles = roles;
		
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public Set<Role> getRoles() {
		return roles;
	}


	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}


	
}
