package com.codingdojo.beltreviewer.models;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(min = 2, message = "First Name must be at least 2 characters")
	private String firstname;
	@Size(min = 2, message = "Last Name must be at least 2 characters")
	private String lastname;
	@Email(message = "Email must be valid")
	private String email;
	@Size(min = 5, message = "Password must be greater than 5 characters")
	private String location;
	private String state;
	private String password;
	@Transient
	private String passwordConfirmation;
	
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "state_id")
	
	
	//event can be attended by many users and the user can attend many events
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "attend_event", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "event_id")
    )
	private List<Event> events;
	
	//user can create many events and the event related  to one user
	@OneToMany(mappedBy = "host", fetch = FetchType.LAZY)
	private List<Event> created_events;
	
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Comment> comments;

	public User() {
	}

	public User(String firstname, String lastname, String email, String location , String state , String password) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.location = location;
		this.state = state;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
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

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}


	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public List<Event> getCreated_events() {
		return created_events;
	}

	public void setCreated_events(List<Event> created_events) {
		this.created_events = created_events;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
}
