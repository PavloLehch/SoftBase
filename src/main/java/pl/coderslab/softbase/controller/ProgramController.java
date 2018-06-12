package pl.coderslab.softbase.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.coderslab.softbase.entity.Category;
import pl.coderslab.softbase.entity.Developer;
import pl.coderslab.softbase.entity.OpSystem;
import pl.coderslab.softbase.entity.Program;
import pl.coderslab.softbase.repository.CategoryRepository;
import pl.coderslab.softbase.repository.DeveloperRepository;
import pl.coderslab.softbase.repository.OpSystemRepository;
import pl.coderslab.softbase.repository.ProgramRepository;
import pl.coderslab.softbase.validation.DataUpdate;

@Controller
@RequestMapping("/admin/program")
public class ProgramController {

	@Autowired
	ProgramRepository programRepo;

	@Autowired
	CategoryRepository categoryRepo;

	@Autowired
	OpSystemRepository opSystemRepo;

	@Autowired
	DeveloperRepository developerRepo;

	// add new program
	@GetMapping("/addprog")
	public String addProg(Model model) {
		Program program = new Program();
		model.addAttribute("program", program);
		return "addProgram";
	}

	@PostMapping("/addprog")
	public String addProgPost(@Validated({ DataUpdate.class }) Program program, BindingResult result) {
		if (result.hasErrors()) {
			return "addProgram";
		}
		this.programRepo.save(program);
		return "redirect:/admin/program/listPrograms";
	}

	// edit program
	@GetMapping("/editprog/{id}")
	public String editProg(@PathVariable long id, Model model) {
		Program program = programRepo.findOne(id);
		model.addAttribute("program", program);
		return "editProgram";
	}

	@PostMapping("/editprog/{id}")
	public String editProgPost(@Valid Program program, BindingResult result) {
		if (result.hasErrors()) {
			return "editProgram";
		}
		this.programRepo.saveAndFlush(program);
		return "redirect:/admin/program/findprog/{id}";
	}

	// find program by id
	@GetMapping("/findprog/{id}")
	public String findProgram(@PathVariable long id, Model model) {
		Program program = programRepo.findOne(id);
		model.addAttribute("program", program);
		return "programDetails";
	}

	// delete program by id
	@GetMapping("/deleteprog/{id}")
	public String deleteProgram(@PathVariable long id) {
		Program program = programRepo.findOne(id);
		program.getOpSystems().clear();
		program.setDeveloper(null);
		program.setCategory(null);
		programRepo.delete(program);
		return "redirect:/admin/program/listPrograms";
	}

	// list programs
	@ModelAttribute("programs")
	public List<Program> getPrograms() {
		return this.programRepo.findAllByOrderByDataCreateDesc();
	}

	@GetMapping("/listPrograms")
	public String listPrograms(Model model) {
		int programsRecordLength = this.programRepo.findAllByOrderByDataCreateDesc().size();
		model.addAttribute("programsRecordLength", "now in Catalog " + programsRecordLength + " records");
		return "programList";
	}

	// list categories
	@ModelAttribute("categories")
	public List<Category> getCategories() {
		return this.categoryRepo.findAll();
	}

	// list systems
	@ModelAttribute("opSystems")
	public List<OpSystem> getSystems() {
		return this.opSystemRepo.findAll();
	}

	// list developers
	@ModelAttribute("developers")
	public List<Developer> getDevelopers() {
		return this.developerRepo.findAll();
	}

	// search programs by name or category or developer
	@PostMapping("/listPrograms")
	public String searchProgramByNameCategoryDeveloper(@RequestParam String search, @RequestParam String nameCatDev,
			Model model) {

		if (search.equals("name")) {
			List<Program> programs = this.programRepo.findByNameLike("%" + nameCatDev + "%");
			model.addAttribute("programs", programs);
			int programsRecordLength = programs.size();
			model.addAttribute("programsRecordLength", "find in Catalog " + programsRecordLength + " records with name " + nameCatDev);
			return "programList";
		} else if (search.equals("category")) {
			List<Category> categories = this.categoryRepo.findByCategoryNameLike("%" + nameCatDev + "%");
			List<Program> programs = new ArrayList<Program>();
			for (Category category : categories) {
				for (Program program : this.programRepo.findByCategory(category)) {
					programs.add(program);
				}
			}
			model.addAttribute("programs", programs);
			int programsRecordLength = programs.size();
			model.addAttribute("programsRecordLength", "find in Catalog " + programsRecordLength + " records with category " + nameCatDev);
			return "programList";
		} else if (search.equals("developer")) {
			List<Developer> developers = this.developerRepo.findByDevNameLike("%" + nameCatDev + "%");
			List<Program> programs = new ArrayList<Program>();
			for (Developer developer : developers) {
				for (Program program : this.programRepo.findByDeveloper(developer)) {
					programs.add(program);
				}
			}
			model.addAttribute("programs", programs);
			int programsRecordLength = programs.size();
			model.addAttribute("programsRecordLength", "find in Catalog " + programsRecordLength + " records with developer " + nameCatDev);
			return "programList";
		} else {
			return "programList";
		}

	}
	// search programs from category
	@GetMapping("/listProgramsCategory/{id}")
	public String listProgramsByCategory(@PathVariable long id, Model model) {
		Category category = this.categoryRepo.findOne(id);
		List<Program> programs = new ArrayList<Program>();
		for (Program program : this.programRepo.findByCategory(category)) {
			programs.add(program);
		}
		model.addAttribute("programs", programs);
		int programsRecordLength = programs.size();
		model.addAttribute("programsRecordLength", "find in Catalog " + programsRecordLength + " records with category " + category);
		return "programList";
	}
	
	// search programs from developer
		@GetMapping("/listProgramsDeveloper/{id}")
		public String listProgramsByDeveloper(@PathVariable long id, Model model) {
			Developer developer = this.developerRepo.findOne(id);
			List<Program> programs = new ArrayList<Program>();
			for (Program program : this.programRepo.findByDeveloper(developer)) {
				programs.add(program);
			}
			model.addAttribute("programs", programs);
			int programsRecordLength = programs.size();
			model.addAttribute("programsRecordLength", "find in Catalog " + programsRecordLength + " records with developer " + developer);
			return "programList";
		}

}
