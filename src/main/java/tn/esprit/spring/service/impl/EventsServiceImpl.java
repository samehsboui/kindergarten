package tn.esprit.spring.service.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import tn.esprit.spring.dto.request.CreateEventsRequest;
import tn.esprit.spring.dto.response.ResponseMessage;
import tn.esprit.spring.entity.Events;
import tn.esprit.spring.entity.Feedback;
import tn.esprit.spring.entity.Kindergarten;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.EventsRepository;
import tn.esprit.spring.repository.FeedbackRepository;
import tn.esprit.spring.service.EventsService;
import tn.esprit.spring.service.KindergartenService;
import tn.esprit.spring.service.UserService;
import tn.esprit.spring.utils.StringsConstants;



@Service
public class EventsServiceImpl implements EventsService {

	
	
	 
	@Autowired
	private EventsRepository eventsRepository;
	
	@Autowired
	private FeedbackRepository feedbackRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private EventsService eventsService;
	
	@Autowired
	private KindergartenService kindergartenService;

	@Override
	public List<Events> getMyEvents(Long userId) {
		return eventsRepository.getMyEvents(userId);
	}

	@Override
	public void create(Events events) {
		eventsRepository.save(events);
	}

	@Override
	public ResponseEntity<ResponseMessage> deleteEvents(Long id) {
		Optional<Events> events = eventsRepository.findById(id);
		if (!events.isPresent()) {
			return new ResponseEntity<>(new ResponseMessage("events doesn't exist"), HttpStatus.NOT_FOUND);
		} else {
			try {
				eventsRepository.delete(events.get());
				return new ResponseEntity<>(new ResponseMessage("event deleted successfully"), HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(new ResponseMessage("Error while deleting event"),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	}

	@Override
	public ResponseEntity<List<Events>> getMyEvents() {
		Optional<User> user = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		List<Events> events = new ArrayList<>();
		if (!user.isPresent()) {
			return new ResponseEntity<>(events, HttpStatus.NOT_FOUND);
		}
		events = eventsService.getMyEvents(user.get().getId());
		
		return new ResponseEntity<>(events, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> createEvents(CreateEventsRequest createEventsRequest) throws ParseException {
		Optional<Kindergarten> kindergarten = kindergartenService.findById(createEventsRequest.getKindergarten().getId());
		// Optional<Feedback> feedback = feedbackRepository.findById(createEventsRequest.getFeedback().getId());


		if (!kindergarten.isPresent()) {
			return new ResponseEntity<>(new ResponseMessage("kindergarten Not found"), HttpStatus.NOT_FOUND);
		}

		try {
			Events events = new Events(createEventsRequest.getEvent_name(), kindergarten.get(),
					createEventsRequest.getType(), createEventsRequest.getDate());
			eventsRepository.save(events);
			
//			 MimeMessage message = sender.createMimeMessage();
//		        MimeMessageHelper helper = new MimeMessageHelper(message);
//
//		        try {
//		            helper.setTo("rakiadaly73@gmail.com");
//		            helper.setText("Greetings :)");
//		            helper.setSubject("Mail From Kindergarten");
//		        } catch (MessagingException e) {
//		            e.printStackTrace();
//		            
//		        }
//		        sender.send(message);
	        
			return new ResponseEntity<>(new ResponseMessage("Events added successfully"), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new ResponseMessage("Error during creating Events"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
