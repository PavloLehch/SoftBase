package pl.coderslab.softbase.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.coderslab.softbase.entity.Category;
import pl.coderslab.softbase.repository.CategoryRepository;


public class CategoryConverter implements Converter<String, Category> {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public Category convert(String id) {
		return this.categoryRepository.findOne(Long.parseLong(id));
	}

}
