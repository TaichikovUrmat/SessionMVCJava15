package peaksoft.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.House;
import peaksoft.repo.HouseRepo;
import peaksoft.service.HouseService;

import java.util.List;

@Service

@RequiredArgsConstructor
public class HouseServiceImpl implements HouseService {

    private final HouseRepo houseRepo;

    @Override
    public void saveHouse(Long agencyId, House house) {
        houseRepo.saveHouse(agencyId, house);
    }

    @Override
    public List<House> getAllHouse() {
        return houseRepo.getAllHouse();
    }

    @Override
    public House getById(Long id) {
        return houseRepo.getById(id);
    }
}
