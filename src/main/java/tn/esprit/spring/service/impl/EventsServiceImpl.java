package tn.esprit.spring.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import tn.esprit.spring.dto.response.ResponseMessage;
import tn.esprit.spring.entity.Events;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.EventsRepository;
import tn.esprit.spring.service.EventsService;
import tn.esprit.spring.service.UserService;



@Service
public class EventsServiceImpl implements EventsService {

	@Autowired
	private EventsRepository eventsRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private EventsService eventsService;

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
	public ResponseEntity<?> createEvents(CreateEventsRequest createEventsRequest)
			throws ParseException {
		Optional<User> user = userService
				.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		

		if (!user.isPresent()) {
			return new ResponseEntity<>(new ResponseMessage(StringsConstants.USER_NOT_EXIST), HttpStatus.NOT_FOUND);
		}

		try {
			
			Events.setUser(user.get());
			EventsService.create(events);
			return new ResponseEntity<>(new ResponseMessage("Events added successfully"), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new ResponseMessage("Error during creating Events"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
