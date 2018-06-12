package pl.coderslab.softbase.controller;

import java.util.ArrayList;
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
import pl.coderslab.softbase.entity.Developer;
import pl.coderslab.softbase.entity.News;
import pl.coderslab.softbase.entity.Program;
import pl.coderslab.softbase.repository.CategoryRepository;
import pl.coderslab.softbase.repository.NewsRepository;

@Controller
@RequestMapping("/admin/news")
public class NewsController {

	@Autowired
	NewsRepository newsRepo;

	@Autowired
	CategoryRepository categoryRepo;

	@GetMapping("/addnews")
	public String addNews(Model model) {
		News news = new News();
		model.addAttribute("news", news);
		return "addNews";
	}

	@PostMapping("/addnews")
	public String addNewsPost(@Valid News news, BindingResult result) {
		if (result.hasErrors()) {
			return "addNews";
		}
		this.newsRepo.save(news);
		return "redirect:/admin/news/listNewses";
	}

	// edit news
	@GetMapping("/editnews/{id}")
	public String editNews(@PathVariable long id, Model model) {
		News news = newsRepo.findOne(id);
		model.addAttribute("news", news);
		return "editNews";
	}

	@PostMapping("/editnews/{id}")
	public String editNewsPost(@Valid News news, BindingResult result) {
		if (result.hasErrors()) {
			return "editNews";
		}
		this.newsRepo.saveAndFlush(news);
		return "redirect:/admin/news/listNewses";
	}

	// find news by id
	@GetMapping("/findnews/{id}")
	public String findProgram(@PathVariable long id, Model model) {
		News news = newsRepo.findOne(id);
		model.addAttribute("news", news);
		return "newsDetails";
	}

	// delete news
	@GetMapping("/deletenews/{id}")
	public String deleteNews(@PathVariable long id) {
		News news = newsRepo.findOne(id);
		newsRepo.delete(news);
		return "redirect:/admin/news/listNewses";
	}

	// creation list newses
	@ModelAttribute("newses")
	public List<News> getNewses() {
		return this.newsRepo.findAllByOrderByNewsDataCreateDesc();
	}

	// show list newses
	@GetMapping("/listNewses")
	public String listNewses(Model model) {
		int newsRecordLength = this.newsRepo.findAllByOrderByNewsDataCreateDesc().size();
		model.addAttribute("newsRecordLength", "now in Catalog " + newsRecordLength + " records");
		return "newsList";
	}

	// creation list categories
	@ModelAttribute("categories")
	public List<Category> getCategories() {
		return this.categoryRepo.findAll();
	}

	// search news by category or title
	@PostMapping("/listNewses")
	public String searchNewsByTitleOrCategory(@RequestParam String search, @RequestParam String titleCat, Model model) {
		if (search.equals("title")) {
			List<News> newses = this.newsRepo.findByNewsTitleLike("%" + titleCat + "%");
			model.addAttribute("newses", newses);
			int newsRecordLength = newses.size();
			model.addAttribute("newsRecordLength", "find in Catalog " + newsRecordLength + " records with title " + titleCat);
			return "newsList";
		} else if (search.equals("category")) {
			List<Category> categories = this.categoryRepo.findByCategoryNameLike("%" + titleCat + "%");
			List<News> newses = new ArrayList<News>();
			for (Category category : categories) {
				for (News news : this.newsRepo.findByCategory(category)) {
					newses.add(news);
				}
			}
			model.addAttribute("newses", newses);
			int newsRecordLength = newses.size();
			model.addAttribute("newsRecordLength", "find in Catalog " + newsRecordLength + " records with category " + titleCat);
			return "newsList";
		} else {
			return "newsList";
		}

	}

}
