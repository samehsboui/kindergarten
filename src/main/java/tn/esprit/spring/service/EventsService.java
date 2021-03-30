package tn.esprit.spring.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.http.ResponseEntity;

import tn.esprit.spring.dto.request.CreateEventsRequest;
import tn.esprit.spring.dto.response.ResponseMessage;
import tn.esprit.spring.entity.Events;


public class EventsService {
	
	public List<Events> getMyEvents(Long id);

	public ResponseEntity<ResponseMessage> deleteEvents(Long id);

	public ResponseEntity<List<Events>> getMyEvents();

	public ResponseEntity<?> createEvents(CreateEventsRequest createEventsRequest) throws ParseException;

	public void create(Events events);

}
