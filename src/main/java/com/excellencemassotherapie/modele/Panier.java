package com.excellencemassotherapie.modele;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="t_paniers")
public class Panier {
    @Id
    @Column(name = "id_panier", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPanier;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Column(name = "produits")
    private List<Produit> produit = new ArrayList<Produit>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Soin> soin = new ArrayList<Soin>();

    @ManyToMany(mappedBy = "listPaniers")
    private List<Client> listClients = new ArrayList<Client>();
    public Panier() {
    }

    public Panier(Long idPanier, List<Produit> produit, List<Soin> soin) {
        this.idPanier = idPanier;
        this.produit = produit;
        this.soin = soin;
    }

    public Long getIdPanier() {
        return idPanier;
    }

    public void setIdPanier(Long idPanier) {
        this.idPanier = idPanier;
    }

    public List<Produit> getProduit() {
        return produit;
    }

    public void setProduit(List<Produit> produit) {
        this.produit = produit;
    }

    public List<Soin> getSoin() {
        return soin;
    }

    public void setSoin(List<Soin> soin) {
        this.soin = soin;
    }

    @Override
    public String toString() {
        return "Panier{" +
                "idPanier=" + idPanier +
                ", produit=" + produit +
                ", soin=" + soin +
                '}';
    }
}
