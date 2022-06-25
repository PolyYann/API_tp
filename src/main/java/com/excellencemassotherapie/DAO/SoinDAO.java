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
    public List<Soin> getAll() {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Soin> criteriaQuery = criteriaBuilder.createQuery(Soin.class);
        Root<Soin> soinRoot = criteriaQuery.from(Soin.class);
        criteriaQuery.select(soinRoot);
        Query query = entityManager.createQuery(criteriaQuery);
        List<Soin> soinList = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return soinList;
    }

    @Override
    public Soin getById(int id) {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Soin> criteriaQuery = criteriaBuilder.createQuery(Soin.class);
        Root<Soin> soinRoot = criteriaQuery.from(Soin.class);
        criteriaQuery.select(soinRoot).where(criteriaBuilder.equal(soinRoot.get("id"), id));
        Query query = entityManager.createQuery(criteriaQuery);
        Soin soin = (Soin) query.getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return soin;
    }

    @Override
    public Soin getByName(String nom) {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Soin> criteriaQuery = criteriaBuilder.createQuery(Soin.class);
        Root<Soin> soinRoot = criteriaQuery.from(Soin.class);
        criteriaQuery.select(soinRoot).where(criteriaBuilder.equal(soinRoot.get("nom"), nom));
        Query query = entityManager.createQuery(criteriaQuery);
        Soin soin = (Soin) query.getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return soin;
    }
    public List<Soin> trouverParLike(String like) {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
      String  hql = "SELECT s FROM Soin s WHERE s.nom LIKE :like or s.description LIKE :like";
        Query query = entityManager.createQuery(hql);
        query.setParameter("like", "%"+like + "%");
        List<Soin> soins = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return soins;
    }
    @Override
    public void insert(Soin soin) {

        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(soin);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
        }

    }
}
