package com.example.jmusicDemo.controllers;

import com.example.jmusicDemo.data_access.ArtistRepository;
import com.example.jmusicDemo.data_access.GenreRepository;
import com.example.jmusicDemo.data_access.TrackRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping(value = "/")
    public String home(Model model){
        int amount = 5;
        model.addAttribute("artistList", ArtistRepository.getRandomArtists(amount));
        model.addAttribute("genreList", GenreRepository.getRandomGenres(amount));
        model.addAttribute("trackList", TrackRepository.getRandomTracks(amount));
        return "home";
    }



}
