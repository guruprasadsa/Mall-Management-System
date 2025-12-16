package com.mallmanagement.floor.repository;

import com.mallmanagement.floor.model.Floor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FloorRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // This converts Database Rows -> Java Objects
    private RowMapper<Floor> floorRowMapper = (rs, rowNum) -> {
        Floor floor = new Floor();
        floor.setFloorId(rs.getInt("floor_id"));
        floor.setFloorNumber(rs.getInt("floor_number"));
        floor.setFloorName(rs.getString("floor_name"));
        floor.setDescription(rs.getString("description"));
        return floor;
    };

    // Method to SAVE a new floor
    public int save(Floor floor) {
        String sql = "INSERT INTO floors (floor_number, floor_name, description) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, floor.getFloorNumber(), floor.getFloorName(), floor.getDescription());
    }

    // Method to GET all floors
    public List<Floor> findAll() {
        String sql = "SELECT * FROM floors";
        return jdbcTemplate.query(sql, floorRowMapper);
    }
    
    // Update an existing floor
    public int update(int id, Floor floor) {
        String sql = "UPDATE floors SET floor_number = ?, floor_name = ?, description = ? WHERE floor_id = ?";
        return jdbcTemplate.update(sql, floor.getFloorNumber(), floor.getFloorName(), floor.getDescription(), id);
    }

    // Delete a floor by ID
    public int deleteById(int id) {
        String sql = "DELETE FROM floors WHERE floor_id = ?";
        return jdbcTemplate.update(sql, id);
    }
}