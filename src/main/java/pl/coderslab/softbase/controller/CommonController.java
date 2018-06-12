package pl.coderslab.softbase.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.coderslab.softbase.entity.Category;
import pl.coderslab.softbase.entity.Developer;
import pl.coderslab.softbase.entity.News;
import pl.coderslab.softbase.entity.Program;
import pl.coderslab.softbase.repository.CategoryRepository;
import pl.coderslab.softbase.repository.DeveloperRepository;
import pl.coderslab.softbase.repository.NewsRepository;
import pl.coderslab.softbase.repository.ProgramRepository;

@Controller
@RequestMapping("/common")
public class CommonController {

	@Autowired
	CategoryRepository categoryRepo;

	@Autowired
	ProgramRepository programRepo;

	@Autowired
	NewsRepository newsRepo;

	@Autowired
	DeveloperRepository developerRepo;

	// take from DB categories
	@ModelAttribute("categories")
	public List<Category> getCategories() {
		return this.categoryRepo.findAll();
	}

	// take from DB 10 added programs
	@ModelAttribute("programsNew")
	public List<Program> lastAddProgram() {
		return this.programRepo.findFirst10ByOrderByDataCreateDesc();
	}

	// take from DB 10 updated programs
	@ModelAttribute("programsUpdate")
	public List<Program> lastUpdateProgram() {
		return this.programRepo.findFirst10ByOrderByDataUpdateDesc();
	}

	// show categories and 10 last added and updated programs
	@GetMapping("/start")
	public String listCategories() {
		return "commonHome";
	}

	// show program by id
	@GetMapping("/findprog/{id}")
	public String findProgram(@PathVariable long id, Model model) {
		Program programNew = programRepo.findOne(id);
		model.addAttribute("program", programNew);
		return "commonProgramDetails";
	}
	
	// search programs by category
	@GetMapping("/listprogramscategory/{id}")
	public String listProgramsByCategory(@PathVariable long id, Model model) {
		Category category = this.categoryRepo.findOne(id);
		List<Program> programs = new ArrayList<Program>();
		for (Program program : this.programRepo.findByCategory(category)) {
			programs.add(program);
		}
		model.addAttribute("programs", programs);
		model.addAttribute("category", category);
		return "commonHomeWithProgramsCategory";
	}

	// last 10 news
	@GetMapping("/news")
	public String last10News(Model model) {
		List<News> lastNewses = this.newsRepo.findFirst10ByOrderByNewsDataCreateDesc();
		model.addAttribute("lastNewses", lastNewses);
		return "commonLastAddNews";
	}

	// show details news by id
	@GetMapping("/news/{id}")
	public String newsById(@PathVariable long id, Model model) {
		News news = this.newsRepo.findOne(id);
		model.addAttribute("news", news);
		return "commonNewsDetails";
	}

	// show contact information
	@GetMapping("/contact")
	public String contactView() {
		return "commonContactInfo";
	}

	// show search
	@GetMapping("/search")
	public String searchView() {
		return "commonSearchForm";
	}

	// search programs by name or category or developer
	@PostMapping("/search")
	public String searchProgramByNameCategoryDeveloper(@RequestParam String search, @RequestParam String find,
			Model model) throws ParseException {
		if (find.equals("")) {
			return "commonSearchForm";
		} else if (search.equals("name")) {
			List<Program> programs = this.programRepo.findByNameLike("%" + find + "%");
			model.addAttribute("programs", programs);
			model.addAttribute("search", search+": ");
			model.addAttribute("find", "\""+find+"\")");
			String programsList = "Programs list (";
			model.addAttribute("programsList", programsList);
			return "commonSearchForm";
		} else if (search.equals("category")) {
			List<Category> categories = this.categoryRepo.findByCategoryNameLike("%" + find + "%");
			List<Program> programs = new ArrayList<Program>();
			for (Category category : categories) {
				for (Program program : this.programRepo.findByCategory(category)) {
					programs.add(program);
				}
			}
			model.addAttribute("programs", programs);
			model.addAttribute("search", search+": ");
			model.addAttribute("find", "\""+find+"\")");
			String programsList = "Programs list (";
			model.addAttribute("programsList", programsList);
			return "commonSearchForm";
		} else if (search.equals("developer")) {
			List<Developer> developers = this.developerRepo.findByDevNameLike("%" + find + "%");
			List<Program> programs = new ArrayList<Program>();
			for (Developer developer : developers) {
				for (Program program : this.programRepo.findByDeveloper(developer)) {
					programs.add(program);
				}
			}
			model.addAttribute("programs", programs);
			model.addAttribute("search", search+": ");
			model.addAttribute("find", "\""+find+"\")");
			String programsList = "Programs list (";
			model.addAttribute("programsList", programsList);
			return "commonSearchForm";
			
		} else if (search.equals("title")) {
			List<News> newses = this.newsRepo.findByNewsTitleLike("%" + find + "%");
			model.addAttribute("newses", newses);
			model.addAttribute("searchNews", search+": ");
			model.addAttribute("findNews", "\""+find+"\")");
			String newsesList = "News list (";
			model.addAttribute("newsesList", newsesList);
			return "commonSearchForm";
		} else if (search.equals("categoryNews")) {
			List<Category> categories = this.categoryRepo.findByCategoryNameLike("%" + find + "%");
			List<News> newses = new ArrayList<News>();
			for (Category category : categories) {
				for (News news : this.newsRepo.findByCategory(category)) {
					newses.add(news);
				}
			}
			model.addAttribute("newses", newses);
			model.addAttribute("searchNews", "categoty: ");
			model.addAttribute("findNews", "\""+find+"\")");
			String newsesList = "News list (";
			model.addAttribute("newsesList", newsesList);
			return "commonSearchForm";
		} else if (search.equals("date")) {
			SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
			List<News> newses = this.newsRepo.findByNewsDataCreateLike(date.parse(find));
			model.addAttribute("newses", newses);
			model.addAttribute("searchNews", search+": ");
			model.addAttribute("findNews", "\""+find+"\")");
			String newsesList = "News list (";
			model.addAttribute("newsesList", newsesList);
			return "commonSearchForm";
		} else {
			return "commonSearchForm";
		}

	}
	

}
