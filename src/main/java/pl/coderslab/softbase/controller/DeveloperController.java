package pl.coderslab.softbase.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.coderslab.softbase.entity.Developer;
import pl.coderslab.softbase.entity.Program;
import pl.coderslab.softbase.repository.DeveloperRepository;
import pl.coderslab.softbase.repository.ProgramRepository;

@Controller
@RequestMapping("/admin/developer")
public class DeveloperController {

	@Autowired
	DeveloperRepository developerRepo;
	
	@Autowired
	ProgramRepository programRepo;

	@GetMapping("/adddeveloper")
	public String addDeveloper(Model model) {
		Developer developer = new Developer();
		model.addAttribute("developer", developer);
		return "addDeveloper";
	}

	@PostMapping("/adddeveloper")
	public String addDeveloperPost(@Valid Developer developer, BindingResult result) {
		if (result.hasErrors()) {
			return "addDeveloper";
		}
		this.developerRepo.save(developer);
		return "redirect:/admin/developer/listDevelopers";
	}

	// edit category
	@GetMapping("/editdeveloper/{id}")
	public String editDeveloper(@PathVariable long id, Model model) {
		Developer developer = developerRepo.findOne(id);
		model.addAttribute("developer", developer);
		return "editDeveloper";
	}

	@PostMapping("/editdeveloper/{id}")
	public String editDeveloperPost(@Valid Developer developer, BindingResult result) {
		if (result.hasErrors()) {
			return "editDeveloper";
		}
		this.developerRepo.saveAndFlush(developer);
		return "redirect:/admin/developer/listDevelopers";
	}

	@GetMapping("/deletedeveloper/{id}")
	public String deleteCategory(@PathVariable long id, Model model) {
		Developer developer = developerRepo.findOne(id);
		List<Program> programs = this.programRepo.findByDeveloper(developer);
		if (programs.size() == 0) {
			developerRepo.delete(developer);
			return "redirect:/admin/developer/listDevelopers";
		} else {
			String alert = "listDevelopers";
			model.addAttribute("alert", alert);
			return "developerList";
		}
	}
	
	
	// list developers
	@ModelAttribute("developers")
	public List<Developer> getDevelopers() {
		return this.developerRepo.findAll();
	}

	@GetMapping("/listDevelopers")
	public String listDevelopers() {
		return "developerList";
	}

	// search developer
		@PostMapping("/listDevelopers")
		public String searchDeveloperByName(@RequestParam String develop, Model model) {

			List<Developer> developers = this.developerRepo.findByDevNameLike("%" + develop + "%");
			model.addAttribute("developers", developers);
			return "developerList";

		}

}
