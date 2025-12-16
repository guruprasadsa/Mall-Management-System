package com.mallmanagement.floor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
        verify(floorRepository).save(floor);
    }

    @Test
    void testAddFloorFailure() {
        Floor floor = new Floor(1, 1, "Ground Floor", "Main Entry");
        when(floorRepository.save(floor)).thenReturn(0);

        String result = floorService.addFloor(floor);

        assertEquals("Failed to add floor.", result);
        verify(floorRepository).save(floor);
    }

    @Test
    void testGetAllFloorsReturnsData() {
        Floor floor1 = new Floor(1, 1, "Ground Floor", "Main Entry");
        Floor floor2 = new Floor(2, 2, "First Floor", "Shops and Food Court");
        List<Floor> floors = Arrays.asList(floor1, floor2);
        when(floorRepository.findAll()).thenReturn(floors);

        List<Floor> result = floorService.getAllFloors();

        assertEquals(2, result.size());
        assertTrue(result.contains(floor1));
        assertTrue(result.contains(floor2));
        verify(floorRepository).findAll();
    }

    @Test
    void testGetAllFloorsEmpty() {
        when(floorRepository.findAll()).thenReturn(Collections.emptyList());

        List<Floor> result = floorService.getAllFloors();

        assertTrue(result.isEmpty());
        verify(floorRepository).findAll();
    }

    @Test
    void testUpdateFloorSuccess() {
        int id = 1;
        Floor floor = new Floor(id, 2, "Updated Floor", "Updated Description");
        when(floorRepository.update(eq(id), any(Floor.class))).thenReturn(1);

        String result = floorService.updateFloor(id, floor);

        assertEquals("Floor updated successfully!", result);
        verify(floorRepository).update(eq(id), any(Floor.class));
    }

    @Test
    void testUpdateFloorFailure() {
        int id = 99;
        Floor floor = new Floor(id, 2, "Non Existing", "Does not exist");
        when(floorRepository.update(eq(id), any(Floor.class))).thenReturn(0);

        String result = floorService.updateFloor(id, floor);

        assertEquals("Floor not found or update failed.", result);
        verify(floorRepository).update(eq(id), any(Floor.class));
    }

    @Test
    void testDeleteFloorSuccess() {
        int id = 1;
        when(floorRepository.deleteById(id)).thenReturn(1);

        String result = floorService.deleteFloor(id);

        assertEquals("Floor deleted successfully!", result);
        verify(floorRepository).deleteById(id);
    }

    @Test
    void testDeleteFloorFailure() {
        int id = 99;
        when(floorRepository.deleteById(id)).thenReturn(0);

        String result = floorService.deleteFloor(id);

        assertEquals("Floor not found or delete failed.", result);
        verify(floorRepository).deleteById(id);
    }
}