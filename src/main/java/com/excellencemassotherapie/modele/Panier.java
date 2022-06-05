package com.excellencemassotherapie.modele;

import javax.persistence.*;

@Entity
public class Panier {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_produit")
    private Produit produit;
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_soin")
    private Soin soin;

    public Panier() {
    }

    public Panier(Long id, Produit produit, Soin soin) {
        this.id = id;
        this.produit = produit;
        this.soin = soin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Soin getSoin() {
        return soin;
    }

    public void setSoin(Soin soin) {
        this.soin = soin;
    }

    @Override
    public String toString() {
        return "Panier{" +
                "id=" + id +
                ", produit=" + produit +
                ", soin=" + soin +
                '}';
    }
}
