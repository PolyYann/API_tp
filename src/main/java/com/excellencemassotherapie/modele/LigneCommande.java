package com.excellencemassotherapie.modele;

import jakarta.persistence.*;

@Entity
@Table(name = "t_ligne_commande")
public class LigneCommande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ligne_commande", nullable = false)
    private int idligneCommande;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Id_Produit")
    private Produit produit;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Id_Soin")
    private Soin soin;
    @Column(name = "Quantite", nullable = false)
    private int quantite;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Id_Panier")
    private Panier panier;


    public LigneCommande() {
    }

    public LigneCommande(Soin soin, int quantite, Panier panier) {
        this.soin = soin;
        this.quantite = quantite;
        this.panier = panier;
    }

    public LigneCommande(Produit produit, int quantite, Panier panier) {
        this.produit = produit;
        this.quantite = quantite;
        this.panier = panier;
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

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getIdligneCommande() {
        return idligneCommande;
    }

    public void setIdligneCommande(int idligneCommande) {
        this.idligneCommande = idligneCommande;
    }

    public Panier getPanier() {
        return panier;
    }

    public void setPanier(Panier panier) {
        this.panier = panier;
    }

    @Override
    public String toString() {
        return "ligneCommande{" +
                "idligneCommande=" + idligneCommande +
                ", produit=" + produit +
                ", soin=" + soin +
                ", quantite=" + quantite +
                '}';
    }
}
