package com.example.jmusicDemo.controllers;

import com.example.jmusicDemo.data_access.ArtistRepository;
import com.example.jmusicDemo.data_access.GenreRepository;
import com.example.jmusicDemo.data_access.TrackRepository;
import com.example.jmusicDemo.models.Search;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewController {

    @RequestMapping (value = "/", method = RequestMethod.GET)
    public String home(Model model){
        int amount = 5;
        model.addAttribute("artistList", ArtistRepository.getRandomArtists(amount));
        model.addAttribute("genreList", GenreRepository.getRandomGenres(amount));
        model.addAttribute("trackList", TrackRepository.getRandomTracks(amount));
        model.addAttribute("search",new Search());

        return "Index";
    }



}
