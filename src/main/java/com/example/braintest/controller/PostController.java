package com.example.braintest.controller;

import com.example.braintest.model.Post;
import com.example.braintest.service.LocationService;
import com.example.braintest.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("post")
public class PostController {

    private final PostService postService;
    private final LocationService locationService;

    public PostController(PostService postService, LocationService locationService) {
        this.postService = postService;
        this.locationService = locationService;
    }

    @GetMapping("")
    public ModelAndView view(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("post");
        modelAndView.addObject("post", new Post());
        modelAndView.addObject("locations", locationService.findAll());
        return  modelAndView;
    }

    @PostMapping("add")
    public ModelAndView add(@ModelAttribute Post post){
        Post post1 = postService.save(post);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("post");
        return  modelAndView;
    }
}
