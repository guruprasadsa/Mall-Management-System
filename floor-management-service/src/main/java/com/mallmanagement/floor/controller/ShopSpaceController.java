package com.mallmanagement.floor.controller;

import com.mallmanagement.floor.model.ShopSpace;
import com.mallmanagement.floor.service.ShopSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/spaces")
public class ShopSpaceController {

    @Autowired
    private ShopSpaceService shopSpaceService;

    // Add a new shop space
    // URL: http://localhost:8081/api/spaces/add
    @PostMapping("/add")
    public ResponseEntity<String> addSpace(@RequestBody ShopSpace space) {
        return ResponseEntity.ok(shopSpaceService.addShopSpace(space));
    }

    // Get all shops on a specific floor
    // URL: http://localhost:8081/api/spaces/floor/1
    @GetMapping("/floor/{floorId}")
    public List<ShopSpace> getSpacesByFloor(@PathVariable int floorId) {
        return shopSpaceService.getSpacesByFloor(floorId);
    }
}