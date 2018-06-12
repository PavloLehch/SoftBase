package pl.coderslab.softbase.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.coderslab.softbase.entity.Developer;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Long> {
	
	List <Developer> findByDevNameLike (String devName);

}