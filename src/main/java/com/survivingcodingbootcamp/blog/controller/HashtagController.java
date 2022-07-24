package com.survivingcodingbootcamp.blog.controller;

import com.survivingcodingbootcamp.blog.repository.HashtagRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HashtagController {

    private HashtagRepository hashtagRepo;

    public HashtagController(HashtagRepository hashtagRepo) {
        this.hashtagRepo = hashtagRepo;
    }

    @RequestMapping("/hashtags/")
    public String showAllHashtags(Model model) {
        model.addAttribute("hashtags", hashtagRepo.findAll());
        return "all-hashtags-template";
    }

    @RequestMapping("/hashtags/{id}")
    private String showHashtag(Model model, @PathVariable long id) {
        model.addAttribute("hashtag", hashtagRepo.findById(id).get());
        return "single-hashtag-template";
    }
}
