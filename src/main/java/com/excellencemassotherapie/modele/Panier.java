package com.excellencemassotherapie.modele;

import jakarta.persistence.*;


@Entity
@Table(name="T_Paniers")
public class Panier {
    @Id
    @Column(name = "id_panier", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPanier;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_produit")
    private Produit produit;
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_soin")
    private Soin soin;

    public Panier() {
    }

    public Panier(Long idPanier, Produit produit, Soin soin) {
        this.idPanier = idPanier;
        this.produit = produit;
        this.soin = soin;
    }

    public Long getIdPanier() {
        return idPanier;
    }

    public void setIdPanier(Long idProduit) {
        this.idPanier = idProduit;
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
                "id=" + idPanier +
                ", produit=" + produit +
                ", soin=" + soin +
                '}';
    }
}
