package pl.coderslab.softbase.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.coderslab.softbase.entity.Developer;
import pl.coderslab.softbase.repository.DeveloperRepository;


public class DeveloperConverter implements Converter<String, Developer> {

	@Autowired
	private DeveloperRepository developerRepository;
	
	public Developer convert(String id) {
		return this.developerRepository.findOne(Long.parseLong(id));
	}

}
