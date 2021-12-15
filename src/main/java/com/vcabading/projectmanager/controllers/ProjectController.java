package com.vcabading.projectmanager.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.vcabading.projectmanager.models.Project;
import com.vcabading.projectmanager.services.ProjectService;
import com.vcabading.projectmanager.services.UserService;

////////////////////////////////////////////////////////////////////
//	PROJECT CONTROLLER
////////////////////////////////////////////////////////////////////

@Controller
public class ProjectController {
	// //// FIELDS ////////////////////////////////////////////////

	@Autowired
	private UserService userServ;

	@Autowired
	private ProjectService projectServ;

	// //// PROJECT SHOW //////////////////////////////////////////

	// //// CREATE NEW PROJECT ////////////////////////////////////

	// **** GET: Create form **************************************
	@GetMapping("project/new")
	public String ProjectNewGet(Model model, HttpSession session) {
		// ---- Check if User is Logged In -----------------------
		if (session.isNew() || session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		// ---- Get New Book --------------------------
		Project newProject = new Project();
		model.addAttribute("newProject", newProject);
		return "projectnew.jsp";
	}
	
	//	**** POST: Add New Project to database *************************
	@PostMapping("/project/new")
	public String projectNewPost(@Valid @ModelAttribute("newProject") Project project, 
			BindingResult result, Model model, HttpSession session) {
		// 	---- Check if User is Logged In  ------------------------
		if (session.isNew() || session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		//	---- Get the Log In User --------------------------------
		if (result.hasErrors()) {
			return "projectnew.jsp";
		} else {
			//newBook.setUser(loggedInUser);
			//newBook.setOwner(loggedInUser);
			this.projectServ.create(project);
			return "redirect:/dashboard";
		}
	}
}
