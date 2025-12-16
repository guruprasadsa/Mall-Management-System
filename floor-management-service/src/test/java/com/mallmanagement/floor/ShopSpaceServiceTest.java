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

import com.mallmanagement.floor.model.ShopSpace;
import com.mallmanagement.floor.repository.ShopSpaceRepository;
import com.mallmanagement.floor.service.ShopSpaceService;

@SpringBootTest
class ShopSpaceServiceTest {

    @Autowired
    private ShopSpaceService shopSpaceService;

    @MockitoBean
    private ShopSpaceRepository shopSpaceRepository;

    @Test
    void testAddShopSpaceSuccess() {
        ShopSpace space = new ShopSpace(1, 1, "Nike", "Fashion", "AVAILABLE");
        when(shopSpaceRepository.save(any(ShopSpace.class))).thenReturn(1);

        String result = shopSpaceService.addShopSpace(space);

        assertEquals("Shop Space allocated successfully!", result);
        verify(shopSpaceRepository).save(any(ShopSpace.class));
    }

    @Test
    void testAddShopSpaceFailure() {
        ShopSpace space = new ShopSpace(1, 1, "Nike", "Fashion", "AVAILABLE");
        when(shopSpaceRepository.save(any(ShopSpace.class))).thenReturn(0);

        String result = shopSpaceService.addShopSpace(space);

        assertEquals("Failed to allocate space.", result);
        verify(shopSpaceRepository).save(any(ShopSpace.class));
    }

    @Test
    void testGetSpacesByFloorReturnsData() {
        int floorId = 1;
        ShopSpace space1 = new ShopSpace(1, floorId, "Nike", "Fashion", "AVAILABLE");
        ShopSpace space2 = new ShopSpace(2, floorId, "Zara", "Fashion", "OCCUPIED");
        List<ShopSpace> spaces = Arrays.asList(space1, space2);
        when(shopSpaceRepository.findByFloorId(eq(floorId))).thenReturn(spaces);

        List<ShopSpace> result = shopSpaceService.getSpacesByFloor(floorId);

        assertEquals(2, result.size());
        assertTrue(result.contains(space1));
        assertTrue(result.contains(space2));
        verify(shopSpaceRepository).findByFloorId(eq(floorId));
    }

    @Test
    void testGetSpacesByFloorEmpty() {
        int floorId = 1;
        when(shopSpaceRepository.findByFloorId(eq(floorId))).thenReturn(Collections.emptyList());

        List<ShopSpace> result = shopSpaceService.getSpacesByFloor(floorId);

        assertTrue(result.isEmpty());
        verify(shopSpaceRepository).findByFloorId(eq(floorId));
    }

    @Test
    void testUpdateShopSpaceSuccess() {
        int spaceId = 1;
        ShopSpace space = new ShopSpace(spaceId, 1, "Updated Nike", "Fashion", "OCCUPIED");
        when(shopSpaceRepository.update(eq(spaceId), any(ShopSpace.class))).thenReturn(1);

        String result = shopSpaceService.updateShopSpace(spaceId, space);

        assertEquals("Shop Space updated successfully!", result);
        verify(shopSpaceRepository).update(eq(spaceId), any(ShopSpace.class));
    }

    @Test
    void testUpdateShopSpaceFailure() {
        int spaceId = 99;
        ShopSpace space = new ShopSpace(spaceId, 1, "Non Existing", "Fashion", "OCCUPIED");
        when(shopSpaceRepository.update(eq(spaceId), any(ShopSpace.class))).thenReturn(0);

        String result = shopSpaceService.updateShopSpace(spaceId, space);

        assertEquals("Shop Space not found or update failed.", result);
        verify(shopSpaceRepository).update(eq(spaceId), any(ShopSpace.class));
    }

    @Test
    void testDeleteShopSpaceSuccess() {
        int spaceId = 1;
        when(shopSpaceRepository.deleteById(spaceId)).thenReturn(1);

        String result = shopSpaceService.deleteShopSpace(spaceId);

        assertEquals("Shop Space deleted successfully!", result);
        verify(shopSpaceRepository).deleteById(spaceId);
    }

    @Test
    void testDeleteShopSpaceFailure() {
        int spaceId = 99;
        when(shopSpaceRepository.deleteById(spaceId)).thenReturn(0);

        String result = shopSpaceService.deleteShopSpace(spaceId);

        assertEquals("Shop Space not found or delete failed.", result);
        verify(shopSpaceRepository).deleteById(spaceId);
    }
}