package com.vcabading.projectmanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.vcabading.projectmanager.services.ProjectService;
import com.vcabading.projectmanager.services.UserService;

////////////////////////////////////////////////////////////////////
//	PROJECT CONTROLLER
////////////////////////////////////////////////////////////////////

@Controller
public class ProjectController {
	//	//// FIELDS ////////////////////////////////////////////////

	@Autowired
	private UserService userServ;

	@Autowired
	private ProjectService bookServ;

	//	//// PROJECT SHOW //////////////////////////////////////////
}
