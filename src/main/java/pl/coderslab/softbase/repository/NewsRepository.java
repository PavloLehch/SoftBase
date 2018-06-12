package pl.coderslab.softbase.repository;

import java.util.Date;
//import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.coderslab.softbase.entity.Category;
import pl.coderslab.softbase.entity.News;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
	
	List<News> findAllByOrderByNewsDataCreateDesc();
	List<News> findByNewsTitleLike(String name);
	List<News> findByCategory(Category category);
	List<News> findFirst10ByOrderByNewsDataCreateDesc();
	List<News> findByNewsDataCreateLike(Date date);
	
}