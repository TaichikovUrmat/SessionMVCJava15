package peaksoft.service;

import org.springframework.stereotype.Service;
import peaksoft.entity.Agency;

import java.util.List;

public interface AgencyService {

    void saveAgency(Agency agency);

    List<Agency> getAllAgency();

    Agency getById(Long id);

    void updateAgencyById(Long id,Agency agency);

    void deleteById(Long id);

    List<Agency> searchAgency(String word);
}
