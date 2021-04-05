package tn.esprit.spring.service.impl;

import java.text.ParseException;
import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import tn.esprit.spring.dto.request.CreateKindergartenRequest;
import tn.esprit.spring.dto.response.ResponseMessage;
import tn.esprit.spring.entity.Kindergarten;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.KindergartenRepository;
import tn.esprit.spring.service.KindergartenService;
import tn.esprit.spring.service.UserService;

@Service
public class KindergartenServiceImpl implements KindergartenService {

	@Autowired
	private KindergartenRepository kindergartenRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private KindergartenService kindergartenService;

	@Override
	public List<Kindergarten> getMyKindergarten(Long userId) {
		return kindergartenRepository.getMykindergarten(userId);
	}

	@Override
	public void create(Kindergarten kindergarten) {
		kindergartenRepository.save(kindergarten);
	}

	@Override
	public ResponseEntity<ResponseMessage> deletekindergarten(Long id) {
		Optional<Kindergarten> kindergarten = kindergartenRepository.findById(id);
		if (!kindergarten.isPresent()) {
			return new ResponseEntity<>(new ResponseMessage("kindergarten doesn't exist"), HttpStatus.NOT_FOUND);
		} else {
			try {
				kindergartenRepository.delete(kindergarten.get());
				return new ResponseEntity<>(new ResponseMessage("kindergarten deleted successfully"), HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(new ResponseMessage("Error while deleting kindergarten"),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	}

	@Override
	public ResponseEntity<List<Kindergarten>> getMyKindergarten() {
		Optional<User> user = userService
				.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		List<Kindergarten> kindergarten = new ArrayList<>();
		if (!user.isPresent()) {
			return new ResponseEntity<>(kindergarten, HttpStatus.NOT_FOUND);
		}
		kindergarten = kindergartenService.getMyKindergarten(user.get().getId());
		kindergarten.forEach(kdg -> {

		});
		return new ResponseEntity<>(kindergarten, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> createKindergarten(CreateKindergartenRequest createKindergartenRequest)
			throws ParseException {
		Optional<User> user = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());

		if (!user.isPresent()) {
			return new ResponseEntity<>(new ResponseMessage(""), HttpStatus.NOT_FOUND);
		}
		try {

			Kindergarten kindergarten = new Kindergarten(createKindergartenRequest.getAdresse(),
					createKindergartenRequest.getEmail(), createKindergartenRequest.getName(),
					createKindergartenRequest.getPhone_number());
			kindergartenRepository.save(kindergarten);
			return new ResponseEntity<>(new ResponseMessage("kindergarten added successfully"), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new ResponseMessage("Error during creating kindergarten"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public Optional<Kindergarten> findById(long id) {
		return kindergartenRepository.findById(id);
	}

}
