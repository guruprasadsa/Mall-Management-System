package com.mallmanagement.floor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import com.mallmanagement.floor.model.Floor;
import com.mallmanagement.floor.repository.FloorRepository;
import com.mallmanagement.floor.service.FloorManagementService;

@SpringBootTest
class FloorServiceTest {

    @Autowired
    private FloorManagementService floorService;

    @MockitoBean
    private FloorRepository floorRepository;

    @Test
    void testAddFloorSuccess() {
        // 1. Setup the data
        Floor floor = new Floor(1, 1, "Ground Floor", "Main Entry");

        // 2. Mock the repository (Fake the database interaction)
        // "When save() is called, pretend it returned 1 (1 row affected)"
        when(floorRepository.save(floor)).thenReturn(1);

        // 3. Run the actual service method
        String result = floorService.addFloor(floor);

        // 4. Verify the result
        assertEquals("Floor added successfully!", result);
    }
}