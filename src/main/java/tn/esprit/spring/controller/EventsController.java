package tn.esprit.spring.controller;

import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
import tn.esprit.spring.service.EventsService;
import tn.esprit.spring.utils.StringsConstants;

@CrossOrigin(origins = StringsConstants.FRONT_BASE_URL, maxAge = 3600)
@Api("Events Controller")
@RestController
@RequestMapping(StringsConstants.EVENTS_URL)
public class EventsController {

	@Autowired
	private EventsService eventsService;

	@PostMapping(value = "/create")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?> createEvents(@Valid @RequestBody CreateEventsRequest createEventsRequest)
			throws ParseException {
		return eventsService.createEvents(createEventsRequest);
	}

	@GetMapping(value = "/my")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<List<Events>> getMyRendezVous() {
		return eventsService.getMyEvents();
	}

	@DeleteMapping(value = "/delete/{id}")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<ResponseMessage> deleteRendezVous(@PathVariable Long id) {
		return eventsService.deleteEvents(id);
	}

}
