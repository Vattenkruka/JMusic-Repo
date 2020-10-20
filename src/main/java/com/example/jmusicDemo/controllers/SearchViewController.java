package com.example.jmusicDemo.controllers;

import com.example.jmusicDemo.data_access.TrackRepository;
import com.example.jmusicDemo.models.Search;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SearchViewController {
    @RequestMapping(value = "/search", method= RequestMethod.GET)
    public String getSearch(Search search, Model model){

        model.addAttribute("query", search.getQuery());
        model.addAttribute("results", TrackRepository.getTracksWhichContainsWord(search.getQuery()));

        return "search";
    }
}
