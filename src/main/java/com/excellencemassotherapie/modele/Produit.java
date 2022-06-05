package com.excellencemassotherapie.modele;

import javax.persistence.*;

@Entity
public class Produit {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nom", nullable = false)
    private String nom;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "url_img", nullable = false)
    private String urlImage;
    @Column(name = "type", nullable = false)
    private String type;
    @Column(name = "quantite", nullable = false)
    private int quantite;
    @Column(name = "prix", nullable = false)
    private double prix;

    public Produit() {
    }

    public Produit(Long id, String nom, String description, String urlImage, String type, int quantite, double prix) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.urlImage = urlImage;
        this.type = type;
        this.quantite = quantite;
        this.prix = prix;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
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
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", urlImage='" + urlImage + '\'' +
                ", type='" + type + '\'' +
                ", quantite=" + quantite +
                ", prix=" + prix +
                '}';
    }
}
