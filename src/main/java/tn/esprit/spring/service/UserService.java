package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.dto.response.JwtResponse;
import tn.esprit.spring.entity.User;

public interface UserService {

	public Optional<User> findByUsername(String username);

	public void updatePassword(String password, User user);

	public Optional<User> findByEmail(String email);

	public User save(User user);

	public List<User> findAllWithoutConnectedUser(Long id);

	public JwtResponse getUserInfo(String token, Optional<User> user);
}
