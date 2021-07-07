package com.example.braintest.service.impl;

import com.example.braintest.model.Location;
import com.example.braintest.repository.LocationRepository;
import com.example.braintest.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public Location save(Location entity) {

        return locationRepository.save(entity);
    }

    @Override
    public List<Location> findAll() {
        return locationRepository.findAll();
    }
}
