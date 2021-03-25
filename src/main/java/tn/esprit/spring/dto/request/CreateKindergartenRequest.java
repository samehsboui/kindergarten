package tn.esprit.spring.dto.request;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CreateKindergartenRequest {

	private String name;
	private String adresse;
	private String email;
	private long phone_number;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(long phone_number) {
		this.phone_number = phone_number;
	}

}
