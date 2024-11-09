package peaksoft.service;

import peaksoft.entity.House;

import java.util.List;

public interface HouseService {

    void saveHouse(Long agencyId,House house);

    List<House> getAllHouse();

    House getById(Long id);

}
