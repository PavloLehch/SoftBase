package pl.coderslab.softbase.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@GetMapping("/login")
	public String login(HttpServletRequest request) {
		HttpSession sess = request.getSession();
		sess.setAttribute("authorized", "true");
		return "redirect:/admin/program/listPrograms";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession sess = request.getSession();
		sess.invalidate();
		return "redirect:/";
	}

}
