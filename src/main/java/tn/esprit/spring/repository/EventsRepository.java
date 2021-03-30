package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import tn.esprit.spring.entity.Events;

@Repository
public interface EventsRepository extends JpaRepository<Events, Long> {

	@Query(value = "SELECT * FROM T_Events WHERE user_id = :userId", nativeQuery = true)
	List<Events> getMyEvents(@Param("userId") Long userId);

	
}
