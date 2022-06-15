package com.excellencemassotherapie.modele;


import jakarta.persistence.*;

@Entity
public class Soin {
    @Id
    @Column(name = "id_soin", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSoin;
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

    public Soin(Long idSoin, String nom, int duree, String description, String urlImage, int quantite, double prix) {
        this.idSoin = idSoin;
        this.nom = nom;
        this.duree = duree;
        this.description = description;
        this.urlImage = urlImage;
        this.quantite = quantite;
        this.prix = prix;
    }

    public Long getIdSoin() {
        return idSoin;
    }

    public void setIdSoin(Long idSoin) {
        this.idSoin = idSoin;
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
                "id=" + idSoin +
                ", nom='" + nom + '\'' +
                ", duree=" + duree +
                ", description='" + description + '\'' +
                ", urlImage='" + urlImage + '\'' +
                ", quantite=" + quantite +
                ", prix=" + prix +
                '}';
    }
}
