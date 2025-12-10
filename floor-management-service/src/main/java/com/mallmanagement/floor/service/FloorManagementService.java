package com.mallmanagement.floor.service;

import com.mallmanagement.floor.model.Floor;
import com.mallmanagement.floor.repository.FloorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FloorManagementService {

    @Autowired
    private FloorRepository floorRepository;

    // Logic to add a floor
    public String addFloor(Floor floor) {
        int rowsAffected = floorRepository.save(floor);
        
        if(rowsAffected > 0) {
            return "Floor added successfully!";
        } else {
            return "Failed to add floor.";
        }
    }

    // Logic to get all floors
    public List<Floor> getAllFloors() {
        return floorRepository.findAll();
    }
}