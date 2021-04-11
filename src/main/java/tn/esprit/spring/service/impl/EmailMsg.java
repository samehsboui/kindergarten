package tn.esprit.spring.service.impl;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class EmailMsg {

	 @NotNull
	    private String name;

	    @NotNull
	    @Email
	    private String email;

	    @NotNull
	    @Min(10)
	    private String feedback;

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getFeedback() {
	        return feedback;
	    }

	    public void setFeedback(String feedback) {
	        this.feedback = feedback;
	    }
}
