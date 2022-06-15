package com.excellencemassotherapie.modele;


import jakarta.persistence.*;

@Entity
public class Professionnel {
    @Id
    @Column(name = "id_proffessionnel", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSoin;
    @Column(name = "nom", nullable = false)
    private String nom;
    @Column(name = "presentation", nullable = false)
    private String presentation;
    @Column(name = "url_img", nullable = false)
    private String urlImage;

    public Professionnel() {
    }

    public Professionnel(Long idSoin, String nom, String presentation, String urlImage) {
        this.idSoin = idSoin;
        this.nom = nom;
        this.presentation = presentation;
        this.urlImage = urlImage;
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

    public String getPresentation() {
        return presentation;
    }

    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    @Override
    public String toString() {
        return "Professionnel{" +
                "id=" + idSoin +
                ", nom='" + nom + '\'' +
                ", presentation='" + presentation + '\'' +
                ", urlImage='" + urlImage + '\'' +
                '}';
    }
}
