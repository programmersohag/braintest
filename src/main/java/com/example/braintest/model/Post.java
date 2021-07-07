package com.example.braintest.model;

import com.example.braintest.model.enums.Privacy;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String status;

    @OneToOne
    private Location location;

    @OneToOne
    private User user;

    @Enumerated(value = EnumType.STRING)
    private Privacy privacy;
}
