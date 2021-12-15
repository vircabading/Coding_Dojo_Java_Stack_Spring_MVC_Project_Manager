package com.vcabading.projectmanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcabading.projectmanager.models.Project;
import com.vcabading.projectmanager.repositories.ProjectRepository;

/////////////////////////////////////////////////////
//	PROJECT SERVICE
/////////////////////////////////////////////////////

@Service
public class ProjectService {

	//	//// FIELDS /////////////////////////////////

	@Autowired
	ProjectRepository projectRepo;

	//	//// CREATE /////////////////////////////////

	//	---- Create a Project -----------------------
	public Project create(Project project) {
		return this.projectRepo.save(project);
	}

	//	//// RETRIEVE ///////////////////////////////

	//	---- Retrieve All ---------------------------
	public List<Project> retrieveAll() {
		return this.projectRepo.findAll();
	}

	//	---- Retrieve Project by ID -----------------
	public Project retrieveproject(Long id) {
		Optional<Project> optProject = this.projectRepo.findById(id);
		if (optProject.isPresent()) {
			Project project = optProject.get();
			return project;
		} else {
			return null;
		}
	}

	//	//// UPDATE /////////////////////////////////

	public Project update(Project project) {
		Optional<Project> optProject = this.projectRepo.findById(project.getId());
		if (optProject.isPresent()) {
			return this.projectRepo.save(project);
		} else {
			return null;
		}
	}

	//	//// DELETE /////////////////////////////////

	public void delete(Long id) {
		this.projectRepo.deleteById(id);
	}
}