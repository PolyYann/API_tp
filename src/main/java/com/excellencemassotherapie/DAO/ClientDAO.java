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

public class ClientDAO implements ICommonDAO<Client> {
    private final EntityManagerFactory entityManagerFactory = Persistence
            .createEntityManagerFactory("hibernate");
    private EntityManager entityManager = null;

    @Override
    public List<Client> getAll() {
        entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Client> criteriaQuery = criteriaBuilder.createQuery(Client.class);
        Root<Client> clientRoot = criteriaQuery.from(Client.class);
        criteriaQuery.select(clientRoot);
        Query query = entityManager.createQuery(criteriaQuery);
        List<Client> clients =  query.getResultList();
        entityManager.close();

        return clients;
    }

    @Override
    public Client getById(int id) {
        entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Client> criteriaQuery = criteriaBuilder.createQuery(Client.class);
        Root<Client> clientRoot = criteriaQuery.from(Client.class);
        criteriaQuery.select(clientRoot).where(criteriaBuilder.equal(clientRoot.get("idClient"), id));
        Query query = entityManager.createQuery(criteriaQuery);
        Client client = (Client) query.getSingleResult();
        entityManager.close();
        return client;
    }

    @Override
    public Client getByName(String nom) {
        entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Client> criteriaQuery = criteriaBuilder.createQuery(Client.class);
        Root<Client> clientRoot = criteriaQuery.from(Client.class);
        criteriaQuery.select(clientRoot).where(criteriaBuilder.equal(clientRoot.get("nom"), nom));
        Query query = entityManager.createQuery(criteriaQuery);
        Client client = (Client) query.getSingleResult();
        entityManager.close();
        return client;
    }

    @Override
    public void insert(Client client) {
        entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(client);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        entityManager.close();

    }


}
