package peaksoft.repo.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Agency;
import peaksoft.entity.House;
import peaksoft.repo.HouseRepo;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class HouseRepoImpl implements HouseRepo {

    @PersistenceContext
    private final EntityManager entityManager;

    @Transactional
    @Override
    public void saveHouse(Long agencyId, House house) {

        Agency agency = entityManager.find(Agency.class, agencyId);
        agency.getHouse().add(house);
        house.setAgency(agency);
        entityManager.persist(house);
        entityManager.flush();
    }
    @Override
    public List<House> getAllHouse() {
        return entityManager.createQuery("select h from House  h", House.class).getResultList();
    }
    @Override
    public House getById(Long id) {
        try {
            return entityManager.createQuery("select h  from House  h where  h.id = :id ", House.class)
                    .setParameter("id", id).getSingleResult();
        } catch (NoResultException e) {
            throw new RuntimeException("House with id " + id + " not found" + e.getMessage());
        }

    }
}
