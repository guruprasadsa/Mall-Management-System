package com.mallmanagement.floor.service;

import com.mallmanagement.floor.model.ShopSpace;
import com.mallmanagement.floor.repository.ShopSpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopSpaceService {

    @Autowired
    private ShopSpaceRepository shopSpaceRepository;

    public String addShopSpace(ShopSpace space) {
        int rows = shopSpaceRepository.save(space);
        if(rows > 0) return "Shop Space allocated successfully!";
        return "Failed to allocate space.";
    }

    public List<ShopSpace> getSpacesByFloor(int floorId) {
        return shopSpaceRepository.findByFloorId(floorId);
    }

    public String updateShopSpace(int spaceId, ShopSpace space) {
        int rows = shopSpaceRepository.update(spaceId, space);
        if (rows > 0) {
            return "Shop Space updated successfully!";
        }
        return "Shop Space not found or update failed.";
    }

    public String deleteShopSpace(int spaceId) {
        int rows = shopSpaceRepository.deleteById(spaceId);
        if (rows > 0) {
            return "Shop Space deleted successfully!";
        }
        return "Shop Space not found or delete failed.";
    }
}