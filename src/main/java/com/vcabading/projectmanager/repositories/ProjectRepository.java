package com.vcabading.projectmanager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vcabading.projectmanager.models.Project;


/////////////////////////////////////////////////////////////
//	PROJECT REPOSITORY
/////////////////////////////////////////////////////////////

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
	
	List<Project> findAll();
}
