package com.codingdojo.lookify.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.lookify.models.Lookify;
import com.codingdojo.lookify.services.LookifyService;

@Controller
public class LookifyController {
	private final LookifyService lookifyService;

	public LookifyController(LookifyService lookifyService) {
		this.lookifyService = lookifyService;
	}
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
		List<Lookify> songs = lookifyService.allSongs();
		model.addAttribute("songs", songs);
		model.addAttribute("songg", new Lookify());
		return "dashboard.jsp";
	}
	@RequestMapping("/songs/new")
	public String process_addingSong(Model model) {
		model.addAttribute("song", new Lookify());
		return "newSong.jsp";
		
	}
	@RequestMapping(value = "/dashboard", method = RequestMethod.POST)
	public String createSong(@Valid @ModelAttribute("song") Lookify song, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "newSong.jsp";
		} else {
		lookifyService.createSong(song);
		return "redirect:/dashboard";
		}
	}
	@RequestMapping("/songs/{title}")
	public String viewSong(@PathVariable("title") String title, Model model) {
		Lookify song= lookifyService.findSong(title);
		model.addAttribute("song", song);
		return "viewSong.jsp";
	}
	@RequestMapping(value="/songs/{id}", method = RequestMethod.DELETE)
	public String deleteSong(@PathVariable("id") Long id) {
		lookifyService.deleteSong(id);
		return "redirect:/dashboard";
	}
	@RequestMapping(value="/search", method = RequestMethod.POST)
	public String proess_search(@RequestParam("artist") String artist) {
		String path= "redirect:/search/"+artist;
		return path;
		
	}
	@RequestMapping("/search/{artist}")
	public String viewArtistSongs(@PathVariable("artist") String artist, Model model) {
		ArrayList <Lookify> artistSongsList= lookifyService.findArtistSongs(artist);
		model.addAttribute("artistSongsList", artistSongsList);
		model.addAttribute("artistName", artist);
		model.addAttribute("songg", new Lookify());
		return "artistSongs.jsp";
	}
	
	@RequestMapping("/search/topTen")
	public String topTenSongs(Model model) {
		List<Lookify> topTenSongs = lookifyService.topTenSongs();
		model.addAttribute("topTenSongs", topTenSongs);
		return "topTen.jsp";
		
		
	}
	


}
