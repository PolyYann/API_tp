package com.excellencemassotherapie.modele;

import jakarta.persistence.*;


@Entity
public class Panier {
    @Id
    @Column(name = "id_panier", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduit;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_produit")
    private Produit produit;
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_soin")
    private Soin soin;

    public Panier() {
    }

    public Panier(Long idProduit, Produit produit, Soin soin) {
        this.idProduit = idProduit;
        this.produit = produit;
        this.soin = soin;
    }

    public Long getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Long idProduit) {
        this.idProduit = idProduit;
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
                "id=" + idProduit +
                ", produit=" + produit +
                ", soin=" + soin +
                '}';
    }
}
