package tn.esprit.spring.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.http.ResponseEntity;

import tn.esprit.spring.dto.request.CreateKindergartenRequest;
import tn.esprit.spring.dto.response.ResponseMessage;
import tn.esprit.spring.entity.Kindergarten;



public interface KindergartenService {

	
	public List<Kindergarten> getMyKindergarten(Long id);

	public ResponseEntity<ResponseMessage> deletekindergarten(Long id);

	public ResponseEntity<List<Kindergarten>> getMyKindergarten();

	public ResponseEntity<?> createKindergarten(CreateKindergartenRequest createKindergartenRequest) throws ParseException;

	public void create(Kindergarten kindergarten);
}
