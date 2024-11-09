package peaksoft.repo;

import org.springframework.stereotype.Repository;
import peaksoft.entity.House;

import java.util.List;

@Repository
public interface HouseRepo {

    void saveHouse(Long agencyId,House house);

    List<House> getAllHouse();

    House getById(Long id);


}
