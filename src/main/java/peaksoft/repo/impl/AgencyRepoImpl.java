package peaksoft.repo.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import peaksoft.entity.Agency;
import peaksoft.repo.AgencyRepo;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Transactional
public class AgencyRepoImpl implements AgencyRepo {


    @PersistenceContext
    private final EntityManager entityManager;


    @Override
    public void saveAgency(Agency agency) {
         entityManager.persist(agency);
    }

    @Override
    public List<Agency> getAllAgency() {
        return entityManager.createQuery("select a from Agency a ", Agency.class).getResultList();
    }

    @Override
    public Agency getById(Long id) {
        try {
            return entityManager.createQuery("select a from Agency  a where  a.id = :id ",Agency.class)
                    .setParameter("id", id).getSingleResult();
        }catch (NoResultException e) {
            throw  new RuntimeException("Agency with id " + id + " not found" + e.getMessage());
        }
    }

    @Override
    public void updateAgencyById(Long id, Agency agency) {
        Agency agency1 = entityManager.find(Agency.class, id);
        if(agency1 == null) {
            try {
                throw new NoResultException("Agency with id " + id + " not found");
            } catch (NoResultException e) {
                System.out.println(e.getMessage());
            }
        }
        agency1.setName(agency.getName());
        agency1.setCountry(agency.getCountry());
        agency1.setEmail(agency.getEmail());
        agency1.setPhoneNumber(agency.getPhoneNumber());
        agency1.setImageLink(agency.getImageLink());
        entityManager.merge(agency1);  // update
    }

    @Override
    public void deleteById(Long id) {
        Agency agency = entityManager.find(Agency.class, id);
        entityManager.remove(agency);
    }

    @Override
    public List<Agency> searchAgency(String word) {
        return null;
    }
}
