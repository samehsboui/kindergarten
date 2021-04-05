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
import tn.esprit.spring.dto.request.CreateKindergartenRequest;
import tn.esprit.spring.dto.response.ResponseMessage;
import tn.esprit.spring.entity.Kindergarten;
import tn.esprit.spring.repository.KindergartenRepository;
import tn.esprit.spring.service.KindergartenService;
import tn.esprit.spring.utils.StringsConstants;

@CrossOrigin(origins = StringsConstants.FRONT_BASE_URL, maxAge = 3600)
@Api("Kindergarten Controller")
@RestController
@RequestMapping(StringsConstants.KINDERGARTEN_URL)
public class KindergartenController {

	@Autowired
	private KindergartenService kindergartenService;

	@Autowired
	private KindergartenRepository kindergartenRepository;

	@PostMapping(value = "/createKindergarten")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?> createKindergarten(@Valid @RequestBody CreateKindergartenRequest createKindergartenRequest)
			throws ParseException {
		return kindergartenService.createKindergarten(createKindergartenRequest);
	}

	@GetMapping(value = "/myKindergarten")
	@PreAuthorize("hasRole('USER')")
	public List<Kindergarten> getMyKindergarten() {
		return kindergartenRepository.findAll();
	}

	@DeleteMapping(value = "/deleteKindergarten/{id}")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<ResponseMessage> deleteKindergarten(@PathVariable Long id) {
		return kindergartenService.deletekindergarten(id);
	}
}
