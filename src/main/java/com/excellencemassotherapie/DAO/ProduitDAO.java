package com.excellencemassotherapie.DAO;

import com.excellencemassotherapie.modele.Produit;
import com.excellencemassotherapie.modele.Professionnel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class ProduitDAO implements ICommonDAO<Produit> {
    private EntityManagerFactory entityManagerFactory = Persistence
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
    public List<Produit> getAll() {

        entityManager.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Produit> criteriaQuery = criteriaBuilder.createQuery(Produit.class);
        Root<Produit> produitRoot = criteriaQuery.from(Produit.class);
        criteriaQuery.select(produitRoot);
        Query query = entityManager.createQuery(criteriaQuery);
        return (List<Produit>) query.getResultList();
    }

    @Override
    public Produit getById(int id) {
        entityManager.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Produit> criteriaQuery = criteriaBuilder.createQuery(Produit.class);
        Root<Produit> produitRoot = criteriaQuery.from(Produit.class);
        criteriaQuery.select(produitRoot).where(criteriaBuilder.equal(produitRoot.get("id"), id));
        Query query = entityManager.createQuery(criteriaQuery);
        return (Produit) query.getSingleResult();

    }

    @Override
    public Produit getByName(String nom) {
        entityManager.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Produit> criteriaQuery = criteriaBuilder.createQuery(Produit.class);
        Root<Produit> produitRoot = criteriaQuery.from(Produit.class);
        criteriaQuery.select(produitRoot).where(criteriaBuilder.equal(produitRoot.get("nom"), "nom"));
        Query query = entityManager.createQuery(criteriaQuery);
        return (Produit) query.getSingleResult();
    }

    @Override
    public void insert(Produit produit) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(produit);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }



    }


