package com.excellencemassotherapie.DAO;

import com.excellencemassotherapie.modele.Produit;
import com.excellencemassotherapie.modele.Professionnel;
import com.excellencemassotherapie.modele.Soin;
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
        List<Produit> produitList = query.getResultList();
        entityManager.getTransaction().commit();
        return produitList;
    }

    @Override
    public Produit getById(int id) {
        entityManager.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Produit> criteriaQuery = criteriaBuilder.createQuery(Produit.class);
        Root<Produit> produitRoot = criteriaQuery.from(Produit.class);
        criteriaQuery.select(produitRoot).where(criteriaBuilder.equal(produitRoot.get("id"), id));
        Query query = entityManager.createQuery(criteriaQuery);
        Produit produit = (Produit) query.getSingleResult();
        entityManager.getTransaction().commit();
        return produit;

    }
    public List<Produit> trouverParLike(String like) {
        entityManager.getTransaction().begin();
        String  hql = "SELECT p FROM Produit p WHERE p.nom LIKE :like or p.description LIKE :like";
        Query query = entityManager.createQuery(hql);
        query.setParameter("like", "%"+like + "%");
        List<Produit> produits = query.getResultList();
        entityManager.getTransaction().commit();
        return produits;
    }
    @Override
    public Produit getByName(String nom) {
        entityManager.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Produit> criteriaQuery = criteriaBuilder.createQuery(Produit.class);
        Root<Produit> produitRoot = criteriaQuery.from(Produit.class);
        criteriaQuery.select(produitRoot).where(criteriaBuilder.equal(produitRoot.get("nom"), "nom"));
        Query query = entityManager.createQuery(criteriaQuery);
        Produit produit = (Produit) query.getSingleResult();
        entityManager.getTransaction().commit();
        return produit;
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


