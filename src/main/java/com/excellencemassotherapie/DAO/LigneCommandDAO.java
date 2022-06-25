package com.excellencemassotherapie.DAO;

import com.excellencemassotherapie.modele.LigneCommande;
import com.excellencemassotherapie.modele.Panier;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class LigneCommandDAO implements ICommonDAO<LigneCommande> {
    private static EntityManagerFactory entityManagerFactory = Persistence
            .createEntityManagerFactory("hibernate");
    private EntityManager entityManager = null;

    @Override
    public List<LigneCommande> getAll() {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<LigneCommande> criteriaQuery = criteriaBuilder.createQuery(LigneCommande.class);
        Root<LigneCommande> ligneCommandeRoot = criteriaQuery.from(LigneCommande.class);
        criteriaQuery.select(ligneCommandeRoot);
        Query query = entityManager.createQuery(criteriaQuery);
        List<LigneCommande> ligneCommandeList = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return ligneCommandeList;
    }

    @Override
    public LigneCommande getById(int id) {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<LigneCommande> criteriaQuery = criteriaBuilder.createQuery(LigneCommande.class);
        Root<LigneCommande> ligneCommandeRoot = criteriaQuery.from(LigneCommande.class);
        criteriaQuery.select(ligneCommandeRoot).where(criteriaBuilder.equal(ligneCommandeRoot.get("id"), id));
        Query query = entityManager.createQuery(criteriaQuery);
        LigneCommande ligneCommande = (LigneCommande) query.getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return ligneCommande;
    }

    @Override
    public LigneCommande getByName(String nom) {
        return null;
    }

    @Override
    public void insert(LigneCommande lc) {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(lc);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void modifieQuantite(int id, int quantite) {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        LigneCommande lc = entityManager.find(LigneCommande.class, id);
        lc.setQuantite(quantite);
        entityManager.merge(lc);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void modifierPanier(LigneCommande lc, int id) {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        String hql = "select p from Panier p where p.idPanier = :id";
        Query query = entityManager.createQuery(hql);
        query.setParameter("id", id);
        Panier panier = (Panier) query.getSingleResult();
        LigneCommande ligneCommande = entityManager.find(LigneCommande.class, lc);
        ligneCommande.setPanier(panier);
        entityManager.merge(ligneCommande);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
