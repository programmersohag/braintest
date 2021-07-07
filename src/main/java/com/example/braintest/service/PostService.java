package com.example.braintest.service;

import com.example.braintest.model.Post;
import com.example.braintest.model.User;

import java.util.List;

public interface PostService {

    Post save(Post post);

    List<Post> findAll();
    List<Post> findAllByUser(User user);
}
