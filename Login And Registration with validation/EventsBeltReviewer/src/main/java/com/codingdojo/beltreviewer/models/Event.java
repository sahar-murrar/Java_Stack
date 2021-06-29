package com.codingdojo.beltreviewer.models;

import java.time.LocalDate;
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
import javax.validation.constraints.Future;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "events")
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String stateEvent;
	@Future
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;
	private String location;
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "state_id")
//	private String state_event;
//	

	// event can be attended by many users and the user can attend many events
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "attend_event", joinColumns = @JoinColumn(name = "event_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> users;

	// user can create many events and the event related to one user
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User host;

	// event has many comments and the comment related to one event
	@OneToMany(mappedBy = "event", fetch = FetchType.LAZY)
	private List<Comment> comments;

	public Event() {

	}


	public Event(String name, String stateEvent, LocalDate date, String location, List<User> users, User host,
			List<Comment> comments) {
		this.name = name;
		this.stateEvent = stateEvent;
		this.date = date;
		this.location = location;
		this.users = users;
		this.host = host;
		this.comments = comments;
	}
	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getStateEvent() {
		return stateEvent;
	}



	public void setStateEvent(String stateEvent) {
		this.stateEvent = stateEvent;
	}



	public LocalDate getDate() {
		return date;
	}



	public void setDate(LocalDate date) {
		this.date = date;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
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



	public List<User> getUsers() {
		return users;
	}



	public void setUsers(List<User> users) {
		this.users = users;
	}



	public User getHost() {
		return host;
	}



	public void setHost(User host) {
		this.host = host;
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
