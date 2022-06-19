package com.excellencemassotherapie.DAO;

import com.excellencemassotherapie.modele.Client;
import com.excellencemassotherapie.modele.Panier;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
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
        return (List<Panier>) query.getResultList();
    }

    @Override
    public Panier getById(int id) {
        entityManager.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Panier> criteriaQuery = criteriaBuilder.createQuery(Panier.class);
        Root<Panier> panierRoot = criteriaQuery.from(Panier.class);
        criteriaQuery.select(panierRoot).where(criteriaBuilder.equal(panierRoot.get("id"), id));
        Query query = entityManager.createQuery(criteriaQuery);
        return (Panier) query.getSingleResult();

    }

    public void payerPanier(Panier panier) {
        entityManager.getTransaction().begin();
        panier.setPaye(true);
        entityManager.merge(panier);
        entityManager.getTransaction().commit();
    }

    public Panier getByClientAndNonPaye(int idClient) {
        Panier panierClient = null;
        entityManager.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Panier> criteriaQuery = criteriaBuilder.createQuery(Panier.class);
        Root<Panier> panierRoot = criteriaQuery.from(Panier.class);
        criteriaQuery.select(panierRoot);
        Query query = entityManager.createQuery(criteriaQuery);
        List<Panier> listPanier = (List<Panier>) query.getResultList();
        for (Panier panier : listPanier) {
            if (panier.getClient().getIdClient() == idClient && !panier.isPaye()) {
                panierClient = panier;
            }
        }
        return panierClient;

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
        entityManager.persist(panier);
        entityManager.getTransaction().commit();
    }
}

