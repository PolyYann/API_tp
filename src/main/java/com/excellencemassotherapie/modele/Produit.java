package com.excellencemassotherapie.modele;

import javax.persistence.*;

@Entity
public class Produit {
    @Id
    @Column(name = "id_Produit", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Produit;
    @Column(name = "nom_Produitom", nullable = false)
    private String nom_Produit;
    @Column(name = "description_Produit", nullable = false)
    private String description_Produit;
    @Column(name = "urlImage_Produit", nullable = false)
    private String urlImage_Produit;

    @Column(name = "type_Produit", nullable = false)
    private String type_Produit;
    @Column(name = "quantite_Produit", nullable = false)
    private int quantite_Produit;
    @Column(name = "prix", nullable = false)
    private double prix_Produit;

    public Produit() {
    }

    public Produit(Long id_Produit, String nom, String description_Produit, String urlImage_Produit, String type_Produit, int quantite_Produit, double prix_Produit) {
        this.id_Produit = id_Produit;
        this.nom_Produit = nom;
        this.description_Produit = description_Produit;
        this.urlImage_Produit = urlImage_Produit;
        this.type_Produit = type_Produit;
        this.quantite_Produit = quantite_Produit;
        this.prix_Produit = prix_Produit;
    }

    public Long getId_Produit() {
        return id_Produit;
    }

    public void setId_Produit(Long id) {
        this.id_Produit = id;
    }

    public String getNom_Produit() {
        return nom_Produit;
    }

    public void setNom_Produit(String nom) {
        this.nom_Produit = nom;
    }

    public String getDescription_Produit() {
        return description_Produit;
    }

    public void setDescription_Produit(String description) {
        this.description_Produit = description;
    }

    public String getUrlImage_Produit() {
        return urlImage_Produit;
    }

    public void setUrlImage_Produit(String urlImage) {
        this.urlImage_Produit = urlImage;
    }

    public String getType_Produit() {
        return type_Produit;
    }

    public void setType_Produit(String type_Produit) {
        this.type_Produit = type_Produit;
    }

    public int getQuantite_Produit() {
        return quantite_Produit;
    }

    public void setQuantite_Produit(int quantite) {
        this.quantite_Produit = quantite;
    }

    public double getPrix_Produit() {
        return prix_Produit;
    }

    public void setPrix_Produit(double prix) {
        this.prix_Produit = prix;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id_Produit +
                ", nom='" + nom_Produit + '\'' +
                ", description='" + description_Produit + '\'' +
                ", urlImage='" + urlImage_Produit + '\'' +
                ", type_Produit='" + type_Produit + '\'' +
                ", quantite=" + quantite_Produit +
                ", prix=" + prix_Produit +
                '}';
    }
}
