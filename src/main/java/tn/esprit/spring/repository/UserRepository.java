package tn.esprit.spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	public Optional<User> findByUsername(String username);

	public boolean existsByUsername(String username);

	public boolean existsByEmail(String email);

	public Optional<User> findByEmail(String email);

	@Modifying
	@Query("UPDATE User u SET u.password = :password WHERE u.id = :id")
	public void updatePassword(@Param("password") String password, @Param("id") Long id);

	@Query(value = "SELECT * FROM users WHERE id != :id", nativeQuery = true)
	public List<User> findAllWithoutConnectedUser(@Param("id") Long id);
	
	@Query("select u from User u where u.username like :x")
	public Page<User> chercher(@Param("x") String mc,Pageable pageable); 
}
