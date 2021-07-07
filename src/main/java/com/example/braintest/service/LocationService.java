package com.example.braintest.service;

import com.example.braintest.model.Location;

import java.util.List;

public interface LocationService {

    Location save(Location entity);

    List<Location> findAll();



}
