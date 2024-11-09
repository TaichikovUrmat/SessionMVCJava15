package peaksoft.repo;

import org.springframework.stereotype.Repository;
import peaksoft.entity.Agency;

import java.util.List;

@Repository
public interface AgencyRepo {

    void saveAgency(Agency agency);

    List<Agency> getAllAgency();

    Agency getById(Long id);

    void updateAgencyById(Long id,Agency agency);

    void deleteById(Long id);
    List<Agency> searchAgency(String word);
}
