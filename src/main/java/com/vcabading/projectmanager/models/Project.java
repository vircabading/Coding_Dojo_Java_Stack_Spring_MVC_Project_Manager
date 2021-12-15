package com.vcabading.projectmanager.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

///////////////////////////////////////////////////////////////
//	PROJECT MODEL CLASS
///////////////////////////////////////////////////////////////

@Entity
@Table(name="projects")
public class Project {

	//	//// FIELDS ///////////////////////////////////////////
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotEmpty(message="Title must not be empty")
	private String title;
	
	@NotNull
	@Size(min=3, message="Description must be at least 3 characters long")
	private String description;
	
	@NotNull
	@NotEmpty(message="Due Date must not be empty")
	@Future(message="Due Date must be in the future")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dueDate;
	
	//	---- MANY:TO:ONE RELATIONSHIP -------------------------
	@ManyToOne( fetch = FetchType.LAZY )
	@JoinColumn( name="owner_id" )
	private User owner;
	
	@Column(updatable=false)		// this will not allow createdAt to be updated after creation
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	@PrePersist
	protected void onCreate()	{
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
	//	//// CONSTRUCTORS ////////////////////////////////////

	public Project() {
	}

	//	//// GETTERS AND SETTERS /////////////////////////////
	
	public Project(String title, String description, Date dueDate) {
		super();
		this.title = title;
		this.description = description;
		this.dueDate = dueDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

}
