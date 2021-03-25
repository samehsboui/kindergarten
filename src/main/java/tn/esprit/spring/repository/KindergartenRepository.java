package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Kindergarten;

@Repository
public interface KindergartenRepository extends JpaRepository<Kindergarten, Long> {

	@Query(value = "SELECT * FROM t_kindergarten WHERE user_id = :userId", nativeQuery = true)
	List<Kindergarten> getMykindergarten(@Param("userId") Long userId);

}