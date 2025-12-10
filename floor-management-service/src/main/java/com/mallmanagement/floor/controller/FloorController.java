package com.mallmanagement.floor.controller;

import com.mallmanagement.floor.model.Floor;
import com.mallmanagement.floor.service.FloorManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/floors")
public class FloorController {

    @Autowired
    private FloorManagementService floorService;

    // Endpoint to ADD a floor
    // URL: http://localhost:8081/api/floors/add
    @PostMapping("/add")
    public ResponseEntity<String> addFloor(@RequestBody Floor floor) {
        String result = floorService.addFloor(floor);
        return ResponseEntity.ok(result);
    }

    // Endpoint to GET all floors
    // URL: http://localhost:8081/api/floors/all
    @GetMapping("/all")
    public List<Floor> getFloors() {
        return floorService.getAllFloors();
    }
}