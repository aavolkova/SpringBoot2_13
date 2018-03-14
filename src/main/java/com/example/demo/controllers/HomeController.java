package com.example.demo.controllers;

import com.example.demo.models.Actor;
import com.example.demo.models.Movie;
import com.example.demo.repositories.ActorRepository;
import com.example.demo.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {

    @Autowired
    ActorRepository actorRepository;

    @Autowired
    MovieRepository movieRepository;

    @RequestMapping("/")
    public String loadData(Model model){

        Actor a = new Actor ();
        a.setName("Sandra Ballock");
        a.setRealname("Sandra Mae Bullowski");


        Movie movie = new Movie();
        movie.setTitle("Emoji Movie");
        movie.setYear(2017);
        movie.setDescription("About Emojis...");


        a.addMovie(movie);
        actorRepository.save(a);

        model.addAttribute("actors", actorRepository.findAll());
        return "index";
    }




}
