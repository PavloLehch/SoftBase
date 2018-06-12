package pl.coderslab.softbase.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.coderslab.softbase.entity.Category;
import pl.coderslab.softbase.entity.Developer;
import pl.coderslab.softbase.entity.OpSystem;
import pl.coderslab.softbase.entity.Program;

@Repository
public interface ProgramRepository extends JpaRepository <Program, Long> {
	
	List<Program> findAllByOrderByDataCreateDesc();
	List<Program> findByNameLike(String name);
	List<Program> findByCategory(Category category);
	List<Program> findByDeveloper(Developer developer);
	List<Program> findFirst10ByOrderByDataCreateDesc();
	List<Program> findFirst10ByOrderByDataUpdateDesc();
	
	List<Program> findByOpSystems (OpSystem opSystem);


}