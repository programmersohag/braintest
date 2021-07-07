package com.example.braintest.repository;

import com.example.braintest.model.Post;
import com.example.braintest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAllByUser(User user);

}
