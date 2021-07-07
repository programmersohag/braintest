package com.example.braintest.service.impl;

import com.example.braintest.model.Post;
import com.example.braintest.model.User;
import com.example.braintest.model.enums.Privacy;
import com.example.braintest.repository.PostRepository;
import com.example.braintest.repository.UserRepository;
import com.example.braintest.service.PostService;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostServiceImpl(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Post save(Post entity) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username).orElse(null);
        entity.setUser(user);
        return postRepository.save(entity);
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public List<Post> findAllByUser() {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(userName).orElse(null);
        return postRepository.findAllByUser(user);
    }

    @Override
    public List<Post> findAllByPrivacy() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof AnonymousAuthenticationToken) {
            return postRepository.findAllByPrivacy(Privacy.PUBLIC);
        }
        return postRepository.findAllByPrivacy(Privacy.PRIVATE);
    }
}
