package com.mallmanagement.floor.repository;

import com.mallmanagement.floor.model.ShopSpace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShopSpaceRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<ShopSpace> rowMapper = (rs, rowNum) -> {
        ShopSpace space = new ShopSpace();
        space.setSpaceId(rs.getInt("space_id"));
        space.setFloorId(rs.getInt("floor_id"));
        space.setShopName(rs.getString("shop_name"));
        space.setCategory(rs.getString("category"));
        space.setStatus(rs.getString("status"));
        return space;
    };

    // Add a new space to a floor
    public int save(ShopSpace space) {
        String sql = "INSERT INTO shop_spaces (floor_id, shop_name, category, status) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, space.getFloorId(), space.getShopName(), space.getCategory(), "AVAILABLE");
    }

    // Find all spaces on a specific floor
    public List<ShopSpace> findByFloorId(int floorId) {
        String sql = "SELECT * FROM shop_spaces WHERE floor_id = ?";
        return jdbcTemplate.query(sql, rowMapper, floorId);
    }
}