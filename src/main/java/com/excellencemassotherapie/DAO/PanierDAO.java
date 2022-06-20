package com.excellencemassotherapie.DAO;

import com.excellencemassotherapie.modele.LigneCommande;
import com.excellencemassotherapie.modele.Panier;
import com.excellencemassotherapie.modele.Produit;
import com.excellencemassotherapie.modele.Soin;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class PanierDAO implements ICommonDAO<Panier> {
    private final EntityManagerFactory entityManagerFactory = Persistence
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
    public List<Panier> getAll() {
        entityManager.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Panier> criteriaQuery = criteriaBuilder.createQuery(Panier.class);
        Root<Panier> panierRoot = criteriaQuery.from(Panier.class);
        criteriaQuery.select(panierRoot);
        Query query = entityManager.createQuery(criteriaQuery);
        List<Panier> paniers = query.getResultList();
        entityManager.getTransaction().commit();
        return paniers;
    }

    @Override
    public Panier getById(int id) {
        entityManager.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Panier> criteriaQuery = criteriaBuilder.createQuery(Panier.class);
        Root<Panier> panierRoot = criteriaQuery.from(Panier.class);
        criteriaQuery.select(panierRoot).where(criteriaBuilder.equal(panierRoot.get("idPanier"), id));
        Query query = entityManager.createQuery(criteriaQuery);
        Panier panier = (Panier) query.getSingleResult();
        entityManager.getTransaction().commit();
        return panier;

    }
    public Panier getByClientAndNonPaye(int idClient) {
        entityManager.getTransaction().begin();
        String hql= "SELECT p FROM Panier p WHERE p.client.idClient = :idClient AND p.paye = false";
        TypedQuery<Panier> query = entityManager.createQuery(hql, Panier.class);
        query.setParameter("idClient", idClient);
       Panier panierClient =query.getSingleResult();

        entityManager.getTransaction().commit();
        return panierClient;
    }

    public void payerPanier(Panier panier) {
        entityManager.getTransaction().begin();
        panier.setPaye(true);
        entityManager.merge(panier);
        entityManager.getTransaction().commit();
    }

    public void checkOut(Panier panier) {
        entityManager.getTransaction().begin();
        panier.setPaye(true);
        entityManager.merge(panier);
        entityManager.getTransaction().commit();
    }

    /**
     * méthode à ne pas implémenté
     */
    @Override
    public Panier getByName(String nomClient) {

        return null;
    }

    @Override
    public void insert(Panier panier) {
        entityManager.getTransaction().begin();
        entityManager.merge(panier);
        entityManager.getTransaction().commit();
    }

}

