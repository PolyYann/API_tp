package com.excellencemassotherapie.modele;

import javax.persistence.*;

@Entity
public class Soin {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nom", nullable = false)
    private String nom;
    @Column(name = "duree", nullable = false)
    private int duree;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "url_img", nullable = false)
    private String urlImage;
    @Column(name = "quantite", nullable = false)
    private int quantite;
    @Column(name = "prix", nullable = false)
    private double prix;

    public Soin() {
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

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
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

    @Override
    public String toString() {
        return "Soin{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", duree=" + duree +
                ", description='" + description + '\'' +
                ", urlImage='" + urlImage + '\'' +
                ", quantite=" + quantite +
                ", prix=" + prix +
                '}';
    }
}
