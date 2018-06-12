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

import pl.coderslab.softbase.entity.Category;
import pl.coderslab.softbase.entity.OpSystem;
import pl.coderslab.softbase.entity.Program;
import pl.coderslab.softbase.repository.CategoryRepository;
import pl.coderslab.softbase.repository.ProgramRepository;

@Controller
@RequestMapping("/admin/category")
public class CategoryController {

	@Autowired
	CategoryRepository categoryRepo;
	
	@Autowired
	ProgramRepository programRepo;

	@GetMapping("/addcategory")
	public String addCategory(Model model) {
		Category category = new Category();
		model.addAttribute("category", category);
		return "addCategory";
	}

	@PostMapping("/addcategory")
	public String addCategoryPost(@Valid Category category, BindingResult result) {
		if (result.hasErrors()) {
			return "addCategory";
		}
		this.categoryRepo.save(category);
		return "redirect:/admin/category/listCategories";
	}

	// edit category
	@GetMapping("/editcategory/{id}")
	public String editCategory(@PathVariable long id, Model model) {
		Category category = categoryRepo.findOne(id);
		model.addAttribute("category", category);
		return "editCategory";
	}

	@PostMapping("/editcategory/{id}")
	public String editCategoryPost(@Valid Category category, BindingResult result) {
		if (result.hasErrors()) {
			return "editCategory";
		}
		this.categoryRepo.saveAndFlush(category);
		return "redirect:/admin/category/listCategories";
	}

	@GetMapping("/deletecategory/{id}")
	public String deleteCategory(@PathVariable long id, Model model) {
		Category category = categoryRepo.findOne(id);
		List<Program> programs = this.programRepo.findByCategory(category);
		if (programs.size() == 0) {
			categoryRepo.delete(category);
			return "redirect:/admin/category/listCategories";
		} else {
			String alert = "listCategories";
			model.addAttribute("alert", alert);
			return "categoryList";
		}
	}
	
	
	// list categories
	@ModelAttribute("categories")
	public List<Category> getCategories() {
		return this.categoryRepo.findAll();
	}

	@GetMapping("/listCategories")
	public String listCategories() {
		return "categoryList";
	}
	
	// search category
	@PostMapping("/listCategories")
	public String searchCategoryByName(@RequestParam String categ, Model model) {

		List<Category> categories = this.categoryRepo.findByCategoryNameLike("%" + categ + "%");
		model.addAttribute("categories", categories);
		return "categoryList";

	}

}
