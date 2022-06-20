package com.excellencemassotherapie.modele;


import jakarta.persistence.*;

@Entity
@Table(name="t_produits")
public class Produit {
    @Id
    @Column(name = "id_produit", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProduit;
    @Column(name = "nom", nullable = false)
    private String nom;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "url_Image", nullable = false)
    private String urlImage;

    @Column(name = "categorie", nullable = false)
    private int categorie;
    @Column(name = "prix", nullable = false)
    private double prix;

    public Produit() {
    }

    public Produit(String nom, String description, String urlImage, int categorie, double prix) {
        this.nom = nom;
        this.description = description;
        this.urlImage = urlImage;
        this.categorie = categorie;
        this.prix = prix;
    }

    public Produit(int idProduit, String nom, String description, String urlImage, int categorie, double prix) {
        this.idProduit = idProduit;
        this.nom = nom;
        this.description = description;
        this.urlImage = urlImage;
        this.categorie = categorie;
        this.prix = prix;
    }

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public int getCategorie() {
        return categorie;
    }

    public void setCategorie(int type) {
        this.categorie = type;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "idProduit=" + idProduit +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", urlImage='" + urlImage + '\'' +
                ", type='" + categorie + '\'' +
                ", prix=" + prix +
                '}';
    }
}
