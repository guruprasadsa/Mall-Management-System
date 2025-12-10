package com.mallmanagement.floor.model;

public class ShopSpace {
    private Integer spaceId;
    private Integer floorId;      // Foreign Key to link with Floor
    private String shopName;      // e.g. "Nike"
    private String category;      // e.g. "Fashion"
    private String status;        // e.g. "AVAILABLE", "OCCUPIED"

    // Empty Constructor
    public ShopSpace() {}

    // Full Constructor
    public ShopSpace(Integer spaceId, Integer floorId, String shopName, String category, String status) {
        this.spaceId = spaceId;
        this.floorId = floorId;
        this.shopName = shopName;
        this.category = category;
        this.status = status;
    }

    // Getters and Setters
    public Integer getSpaceId() { return spaceId; }
    public void setSpaceId(Integer spaceId) { this.spaceId = spaceId; }

    public Integer getFloorId() { return floorId; }
    public void setFloorId(Integer floorId) { this.floorId = floorId; }

    public String getShopName() { return shopName; }
    public void setShopName(String shopName) { this.shopName = shopName; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}