package tn.esprit.spring.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import tn.esprit.spring.entity.Feedback;
import tn.esprit.spring.utils.StringsConstants;

@CrossOrigin(origins = StringsConstants.FRONT_BASE_URL, maxAge = 3600)
@Api("Feedback Controller")
@RestController
@RequestMapping(StringsConstants.FEEDBACK_URL)
public class FeedbackController {
	
	
	@GetMapping(value = "/feedbackNote")
	@PreAuthorize("hasRole('USER')")
	public float getFeedbackNote(@RequestBody Feedback feedback) {
		float noteTotal= (float) (feedback.getNote_ambiance()+feedback.getNote_emplacement()+feedback.getNote_experience()+
				feedback.getNote_objectifsEvent()+feedback.getNote_organisation())/5 ; 
				return noteTotal;
	}

}
