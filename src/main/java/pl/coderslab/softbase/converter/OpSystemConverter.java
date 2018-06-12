package pl.coderslab.softbase.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.coderslab.softbase.entity.OpSystem;
import pl.coderslab.softbase.repository.OpSystemRepository;


public class OpSystemConverter implements Converter<String, OpSystem> {

	@Autowired
	private OpSystemRepository opSystemRepository;
	
	public OpSystem convert(String id) {
		return this.opSystemRepository.findOne(Long.parseLong(id));
	}

}
