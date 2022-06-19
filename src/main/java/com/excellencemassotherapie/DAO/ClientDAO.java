package com.excellencemassotherapie.DAO;

import com.excellencemassotherapie.modele.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class ClientDAO implements ICommonDAO<Client> {
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
    public List<Client> getAll() {
        entityManager.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Client> criteriaQuery = criteriaBuilder.createQuery(Client.class);
        Root<Client> clientRoot = criteriaQuery.from(Client.class);
        criteriaQuery.select(clientRoot);
        Query query = entityManager.createQuery(criteriaQuery);
        return (List<Client>) query.getResultList();
    }

    @Override
    public Client getById(int id) {
        entityManager.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Client> criteriaQuery = criteriaBuilder.createQuery(Client.class);
        Root<Client> clientRoot = criteriaQuery.from(Client.class);
        criteriaQuery.select(clientRoot).where(criteriaBuilder.equal(clientRoot.get("idClient"), id));
        Query query = entityManager.createQuery(criteriaQuery);
        return (Client) query.getSingleResult();
    }

    @Override
    public Client getByName(String nom) {
        entityManager.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Client> criteriaQuery = criteriaBuilder.createQuery(Client.class);
        Root<Client> clientRoot = criteriaQuery.from(Client.class);
        criteriaQuery.select(clientRoot).where(criteriaBuilder.equal(clientRoot.get("nom"), nom));
        Query query = entityManager.createQuery(criteriaQuery);
        return (Client) query.getSingleResult();
    }

    @Override
    public void insert(Client client) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(client);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
