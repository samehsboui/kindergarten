package tn.esprit.spring.controller;

import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import io.swagger.annotations.Api;
import tn.esprit.spring.dto.request.CreateEventsRequest;
import tn.esprit.spring.dto.response.ResponseMessage;
import tn.esprit.spring.entity.Events;
import tn.esprit.spring.repository.EventsRepository;
import tn.esprit.spring.service.EventsService;
import tn.esprit.spring.service.impl.EmailCfg;
import tn.esprit.spring.service.impl.EmailMsg;
import tn.esprit.spring.utils.StringsConstants;

@CrossOrigin(origins = StringsConstants.FRONT_BASE_URL, maxAge = 3600)
@Api("Events Controller")
@RestController
@RequestMapping(StringsConstants.EVENTS_URL)
public class EventsController {
	
	
	@Autowired
    private EmailCfg emailCfg;

	@Autowired
	private EventsService eventsService;
	
	@Autowired
	private EventsRepository eventsRepository;

	@PostMapping(value = "/createEvent")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?> createEvents(@Valid @RequestBody CreateEventsRequest createEventsRequest)
			throws ParseException {
		return eventsService.createEvents(createEventsRequest);
	}

	@GetMapping(value = "/myEvents")
	@PreAuthorize("hasRole('USER')")
	public List<Events> getMyEvents() {
		return eventsRepository.findAll();
		}

	@DeleteMapping(value = "/deleteEvent/{id}")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<ResponseMessage> deleteEvents(@PathVariable Long id) {
		return eventsService.deleteEvents(id);
	}

	
	 @PostMapping(value = "/sendMail")
	 @PreAuthorize("hasRole('USER')")
	    public void sendFeedback(@RequestBody EmailMsg feedback,
	                             BindingResult bindingResult){
	        if(bindingResult.hasErrors()){
	            throw new ValidationException("Feedback is not valid");
	        }

	        // Create a mail sender
	        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	        mailSender.setHost(this.emailCfg.getHost());
	        mailSender.setPort(this.emailCfg.getPort());
	        mailSender.setUsername(this.emailCfg.getUsername());
	        mailSender.setPassword(this.emailCfg.getPassword());

	        // Create an email instance
	        SimpleMailMessage mailMessage = new SimpleMailMessage();
	        mailMessage.setFrom(feedback.getEmail());
	        mailMessage.setTo("rc@feedback.com");
	        mailMessage.setSubject("New feedback from " + feedback.getName());
	        mailMessage.setText(feedback.getFeedback());

	        // Send mail
	        mailSender.send(mailMessage);
	    }

}
