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
	// Endpoint to POST a new floor
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
    
 // URL: http://localhost:8081/api/floors/update/{id}
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateFloor(@PathVariable int id, @RequestBody Floor floor) {
        return ResponseEntity.ok(floorService.updateFloor(id, floor));
    }

    // URL: http://localhost:8081/api/floors/delete/{id}
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFloor(@PathVariable int id) {
        return ResponseEntity.ok(floorService.deleteFloor(id));
    }
}