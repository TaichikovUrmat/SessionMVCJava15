package peaksoft.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Agency;
import peaksoft.repo.AgencyRepo;
import peaksoft.service.AgencyService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgencyServiceImpl  implements AgencyService {

    private final AgencyRepo agencyRepo;


    @Override
    public void saveAgency(Agency agency) {
        agencyRepo.saveAgency(agency);
    }

    @Override
    public List<Agency> getAllAgency() {
        return agencyRepo.getAllAgency();
    }

    @Override
    public Agency getById(Long id) {
        return agencyRepo.getById(id);
    }

    @Override
    public void updateAgencyById(Long id, Agency agency) {
       agencyRepo.updateAgencyById(id, agency);
    }

    @Override
    public void deleteById(Long id) {
     agencyRepo.deleteById(id);
    }

    @Override
    public List<Agency> searchAgency(String word) {
        return agencyRepo.searchAgency(word);
    }
}
