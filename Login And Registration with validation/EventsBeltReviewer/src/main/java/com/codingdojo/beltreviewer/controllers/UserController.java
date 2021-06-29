package com.codingdojo.beltreviewer.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.beltreviewer.models.Comment;
import com.codingdojo.beltreviewer.models.Event;
import com.codingdojo.beltreviewer.models.User;
import com.codingdojo.beltreviewer.services.CommentService;
import com.codingdojo.beltreviewer.services.EventService;
import com.codingdojo.beltreviewer.services.UserService;
import com.codingdojo.beltreviewer.validators.UserValidator;

@Controller
public class UserController {
	private final UserService userService;
	private final EventService eventService;
	private final CommentService commentService;
	private final UserValidator userValidator;

	public UserController(UserService userService, UserValidator userValidator, EventService eventServic, CommentService commentService) {
		this.userService = userService;
		this.userValidator = userValidator;
		this.eventService=eventServic;
		this.commentService=commentService;
	}
	
	@RequestMapping("/")
	public String registerAndLoginForms(@ModelAttribute("user") User user, HttpSession session) {
		if (session.isNew() || session.getAttribute("userId") == null || user == null) {
			return "login_registration.jsp";

		}
		if (session.getAttribute("userId") != null) { //if the user is already logged in then redirect him to the home page.
			return "redirect:/home";
		}
		return "login_registration.jsp";
	}

//	@RequestMapping("/registration")
//	public String registerForm(@ModelAttribute("user") User user) {
//		return "registrationPage.jsp";
//	}

//	@RequestMapping("/login")
//	public String login(HttpSession session) {
//		if (session.isNew() || session.getAttribute("userId") == null) {
//			return "loginPage.jsp";
//
//		}
//		if (session.getAttribute("userId") != null) { //if the user is already logged in then redirect him to the home page.
//			return "redirect:/home";
//		}
//		return "loginPage.jsp";
//	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		userValidator.validate(user, result); //the result here contains the error from the form the user entered and the errors from the validator
		// if result has errors, return the registration page (don't worry about
		// validations just now)
		if (result.hasErrors()) {
			return "registrationPage.jsp";
		}
		// else, save the user in the database, save the user id in session, and
		// redirect them to the /home route
		User u = userService.registerUser(user);
		session.setAttribute("userId", u.getId());
		return "redirect:/home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model,
			HttpSession session) {
		// if the user is authenticated, save their user id in session
		if (userService.authenticateUser(email, password)) {
			session.setAttribute("userId", userService.findByEmail(email).getId());
			return "redirect:/home";
		}
		// else, add error messages and return the login page
		model.addAttribute("error", "Invalid Credantials, Please try again");
		return "loginPage.jsp";
	}

	@RequestMapping("/home")
	public String home(HttpSession session, Model model) {
		// get user from session, save them in the model and return the home page
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		if (session.isNew() == false || session.getAttribute("userId") != null) {//allow the user to access the home page if he is already logged in, otherwise redirect him to login page
			Long id = (Long) session.getAttribute("userId");
			User user = userService.findUserById(id);
			model.addAttribute("user", user);
			String user_state= user.getState();
			List <Event> StateEvents= eventService.findByState(user_state);
			List <Event> reaminedEvents= eventService.findByStateIsNot(user_state);
			model.addAttribute("event", new Event());
			model.addAttribute("stateEvents", StateEvents);
			model.addAttribute("reaminedEvents", reaminedEvents);
			return "homePage.jsp";
		}
		return "redirect:/";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		// invalidate session
		session.invalidate();
		// redirect to login page
		return "redirect:/";
	}
	@PostMapping("creat_events")
	public String creat_events(@Valid @ModelAttribute("event") Event event, BindingResult result, HttpSession session){
		if (result.hasErrors()) {
			return "homePage.jsp";
		}
		// else, save the user in the database, save the user id in session, and
		// redirect them to the /home route
		User user= userService.findUserById((Long)session.getAttribute("userId"));
		event.setHost(user);
		eventService.createEvent(event);
		return "redirect:/home";
	}
	@RequestMapping("/editEvent/{id}")
	public String editEvent(@PathVariable("id") Long id, Model model, HttpSession session ) {
		
		Event event = eventService.findEventById(id);
		model.addAttribute("event", event);
		session.setAttribute("eventId", id);
		return "editEvent.jsp";
	}
	@PostMapping("/process_editEvent")
	public String process_editEvent(@Valid @ModelAttribute("event") Event event, BindingResult result, HttpSession session) {
		if (result.hasErrors()) {
			return "editEvent.jsp";
		}
		User user= userService.findUserById((Long)session.getAttribute("userId"));
		event.setHost(user);
		Long id= (Long) session.getAttribute("eventId");
		Event e= eventService.findEventById(id);
		e.setName(event.getName());
		e.setDate(event.getDate());
		e.setLocation(event.getLocation());
		e.setStateEvent(event.getStateEvent());
		e.setHost(event.getHost());
		eventService.updateEvent(e);
		return "redirect:/home";
	}
	
	@RequestMapping(value="/deleteEvent/{id}", method = RequestMethod.DELETE)
	public String deleteEvent(@PathVariable("id") Long id) {
		Event event = eventService.findEventById(id);
		eventService.deleteEvent(event);
		return "redirect:/home";
	}
	
	@RequestMapping("/joinEvent/{id}")
	public String joinEvent(@PathVariable("id") Long id, HttpSession session) {
		Event event = eventService.findEventById(id);
		List<User> atendees= event.getUsers();
		User user= userService.findUserById((Long)session.getAttribute("userId"));
		atendees.add(user);
		event.setUsers(atendees);
		eventService.updateEvent(event);
		return "redirect:/home";
	}
	
	@RequestMapping("/cancelJoin/{id}")
	public String cancelJoiningEvent(@PathVariable("id") Long id, HttpSession session) {
		Event event = eventService.findEventById(id);
		List<User> atendees= event.getUsers();
		User user= userService.findUserById((Long)session.getAttribute("userId"));
		atendees.remove(user);
		event.setUsers(atendees);
		eventService.updateEvent(event);
		return "redirect:/home";
	}
	@RequestMapping("/events/{id}")
	public String viewEvent(@PathVariable("id") Long id, Model model) {
		Event event = eventService.findEventById(id);
		model.addAttribute("event", event);
		List<User> attendees= event.getUsers();
		int numbOfAtendees= attendees.size();
		model.addAttribute("numbOfAtendees", numbOfAtendees);
		model.addAttribute("attendees", attendees);
		model.addAttribute("comment", new Comment());
		List<Comment> eventComments= event.getComments();
		model.addAttribute("eventComments", eventComments);
		return "viewEvent.jsp";
		
	}
	
	@PostMapping("/addComment/{id}")
	public String addComment(@PathVariable("id") Long id, @Valid @ModelAttribute("comment") String comment, BindingResult result, HttpSession session) {
		if (result.hasErrors()) {
			return "viewEvent.jsp";
		}
		Event event = eventService.findEventById(id);
		User user= userService.findUserById((Long)session.getAttribute("userId"));
		List<Comment> eventComments= event.getComments();
		Comment com= new Comment();
		com.setEvent(event);
		com.setUser(user);
		com.setComment(comment);
		Comment c=commentService.createComment(com);
		eventComments.add(c);
		event.setComments(eventComments);
		eventService.updateEvent(event);
		List <Comment> userComments= user.getComments();
		userComments.add(c);
		user.setComments(userComments);
		userService.updateUser(user);
		return "redirect:/events/"+id;
	}

}
