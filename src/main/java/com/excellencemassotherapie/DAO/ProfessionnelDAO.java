package com.excellencemassotherapie.DAO;

import com.excellencemassotherapie.modele.Professionnel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class ProfessionnelDAO implements ICommonDAO<Professionnel> {
    private final EntityManagerFactory entityManagerFactory = Persistence
            .createEntityManagerFactory("hibernate");
    private EntityManager entityManager = null;


    @Override
    public List<Professionnel> getAll() {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Professionnel> criteriaQuery = criteriaBuilder.createQuery(Professionnel.class);
        Root<Professionnel> professionnelRoot = criteriaQuery.from(Professionnel.class);
        criteriaQuery.select(professionnelRoot);
        Query query = entityManager.createQuery(criteriaQuery);
        List<Professionnel> professionnels = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return professionnels;
    }
    //inutile d'implémentér getById car on ne peut pas modifier
    // les professionnels a partir du site web
    @Override
    public Professionnel getById(int id) {
        return null;
    }
    //inutile d'implémentér getByName car on ne peut pas modifier
    // les professionnels a partir du site web
    @Override
    public Professionnel getByName(String nom) {
        return null;
    }

    @Override
    public void insert(Professionnel professionnel) {
        entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(professionnel);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        entityManager.close();
    }
}
