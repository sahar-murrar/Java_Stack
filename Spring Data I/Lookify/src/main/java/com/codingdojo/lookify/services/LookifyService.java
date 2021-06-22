package com.codingdojo.lookify.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.lookify.models.Lookify;
import com.codingdojo.lookify.repositories.LookifyRepository;

@Service
public class LookifyService {
	private final LookifyRepository lookifyRepository;

	public LookifyService(LookifyRepository lookifyRepository) {
		this.lookifyRepository = lookifyRepository;
	}

	// returns all the songs
	public List<Lookify> allSongs() {
		return lookifyRepository.findAll();
	}

	// creates a song
	public Lookify createSong(Lookify lookify) {
		return lookifyRepository.save(lookify);
	}

	// retrieves a song
	public Lookify findSong(Long id) {
		Optional<Lookify> optionalSong = lookifyRepository.findById(id);
		if (optionalSong.isPresent()) {
			return optionalSong.get();
		} else {
			return null;
		}
	}

	public Lookify findByTitle(String title) {
		List<Lookify> allSongs = lookifyRepository.findAll();
		for (int i = 0; i < allSongs.size(); i++) {
			Lookify song = allSongs.get(i);
			if (song.getTitle().equals(title)) {
				return song;

			}
		}
		return null;
	}

	public Lookify findSong(String title) {
		Optional<Lookify> optionalSong = lookifyRepository.findByTitle(title);
		if (optionalSong.isPresent()) {
			return optionalSong.get();
		} else {
			return null;
		}
	}

	public void deleteSong(Long id) {
		Optional<Lookify> optionalSong = lookifyRepository.findById(id);
		if (optionalSong.isPresent()) {
			lookifyRepository.deleteById(id);
		} else {
			System.out.println("There is no song with this id");
		}
	}

	public ArrayList<Lookify> findArtistSongs(String artist) {
		List<Lookify> allSongs = lookifyRepository.findAll();
		ArrayList<Lookify> artistSongs = new ArrayList<Lookify>();
		for (int i = 0; i < allSongs.size(); i++) {
			Lookify song = allSongs.get(i);
			if (song.getArtist().equals(artist)) {
				artistSongs.add(song);
			}

		}
		return artistSongs;

	}

	public List<Lookify> topTenSongs() {
		List<Lookify> allSongs = lookifyRepository.findAll();
		Collections.sort(allSongs, Comparator.comparingDouble(Lookify::getRating).reversed()); //sort the list in descinding order according to the rating
		for (int i = allSongs.size()-1; i >0; i--) { //traverse on the array from the last and remove all the indexes that are large than 9 because we want only the top 10 songs
			if(allSongs.size() <10) { //if the list is already contains less than 10 songs so return the list directly without removing from it.
				return allSongs;
			}
			if (i !=9) {
				allSongs.remove(i);
			}
			else {
				return allSongs;
			}
		}

		return allSongs;

	}

}
