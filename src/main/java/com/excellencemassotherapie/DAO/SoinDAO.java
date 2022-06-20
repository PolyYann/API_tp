package com.excellencemassotherapie.DAO;

import com.excellencemassotherapie.modele.Soin;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class SoinDAO implements ICommonDAO<Soin> {
    private static EntityManagerFactory entityManagerFactory = Persistence
            .createEntityManagerFactory("hibernate");
    private EntityManager entityManager = null;

    @Override
    public void connect() {
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public void disconnect() {
        entityManager.close();
    }

    @Override
    public List<Soin> getAll() {
        entityManager.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Soin> criteriaQuery = criteriaBuilder.createQuery(Soin.class);
        Root<Soin> soinRoot = criteriaQuery.from(Soin.class);
        criteriaQuery.select(soinRoot);
        Query query = entityManager.createQuery(criteriaQuery);
        List<Soin> soinList = query.getResultList();
        entityManager.getTransaction().commit();
        return soinList;
    }

    @Override
    public Soin getById(int id) {

        entityManager.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Soin> criteriaQuery = criteriaBuilder.createQuery(Soin.class);
        Root<Soin> soinRoot = criteriaQuery.from(Soin.class);
        criteriaQuery.select(soinRoot).where(criteriaBuilder.equal(soinRoot.get("id"), id));
        Query query = entityManager.createQuery(criteriaQuery);
        Soin soin = (Soin) query.getSingleResult();
        entityManager.getTransaction().commit();
        return soin;
    }

    @Override
    public Soin getByName(String nom) {
        entityManager.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Soin> criteriaQuery = criteriaBuilder.createQuery(Soin.class);
        Root<Soin> soinRoot = criteriaQuery.from(Soin.class);
        criteriaQuery.select(soinRoot).where(criteriaBuilder.equal(soinRoot.get("nom"), nom));
        Query query = entityManager.createQuery(criteriaQuery);
        Soin soin = (Soin) query.getSingleResult();
        entityManager.getTransaction().commit();
        return soin;
    }
    @Override
    public void insert(Soin soin) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(soin);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }
}
