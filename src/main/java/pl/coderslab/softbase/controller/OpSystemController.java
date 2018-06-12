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

import pl.coderslab.softbase.entity.OpSystem;
import pl.coderslab.softbase.entity.Program;
import pl.coderslab.softbase.repository.OpSystemRepository;
import pl.coderslab.softbase.repository.ProgramRepository;

@Controller
@RequestMapping("/admin/system")
public class OpSystemController {

	@Autowired
	OpSystemRepository opSystemRepo;

	@Autowired
	ProgramRepository programRepo;

	@GetMapping("/addsystem")
	public String addSystem(Model model) {
		OpSystem opSystem = new OpSystem();
		model.addAttribute("opSystem", opSystem);
		return "addSystem";
	}

	@PostMapping("/addsystem")
	public String addSystemPost(@Valid OpSystem opSystem, BindingResult result) {
		if (result.hasErrors()) {
			return "addSystem";
		}
		this.opSystemRepo.save(opSystem);
		return "redirect:/admin/system/listSystems";
	}

	// edit system
	@GetMapping("/editsystem/{id}")
	public String editSystem(@PathVariable long id, Model model) {
		OpSystem opSystem = opSystemRepo.findOne(id);
		model.addAttribute("opSystem", opSystem);
		return "editSystem";
	}

	@PostMapping("/editsystem/{id}")
	public String editSystemPost(@Valid OpSystem opSystem, BindingResult result) {
		if (result.hasErrors()) {
			return "editSystem";
		}
		this.opSystemRepo.saveAndFlush(opSystem);
		return "redirect:/admin/system/listSystems";
	}

	@GetMapping("/deletesystem/{id}")
	public String deleteSystem(@PathVariable long id, Model model) {
		OpSystem opSystem = opSystemRepo.findOne(id);
		List<Program> programs = this.programRepo.findByOpSystems(opSystem);
		if (programs.size() == 0) {
			opSystemRepo.delete(opSystem);
			return "redirect:/admin/system/listSystems";
		} else {
			String alert = "listSystems";
			model.addAttribute("alert", alert);
			return "systemList";
		}
	}

	// list systems
	@ModelAttribute("opSystems")
	public List<OpSystem> getSystems() {
		return this.opSystemRepo.findAll();
	}

	@GetMapping("/listSystems")
	public String listSystems() {
		return "systemList";
	}
}
