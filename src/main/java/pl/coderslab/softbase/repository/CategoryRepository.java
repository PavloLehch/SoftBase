package pl.coderslab.softbase.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.coderslab.softbase.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	List<Category> findByCategoryNameLike (String categoryName);

}
