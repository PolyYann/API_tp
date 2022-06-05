package com.excellencemassotherapie.modele;

import javax.persistence.*;

@Entity
public class Professionnel {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nom", nullable = false)
    private String nom;
    @Column(name = "presentation", nullable = false)
    private String presentation;
    @Column(name = "url_img", nullable = false)
    private String urlImage;

    public Professionnel() {
    }

    public Professionnel(Long id, String nom, String presentation, String urlImage) {
        this.id = id;
        this.nom = nom;
        this.presentation = presentation;
        this.urlImage = urlImage;
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
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", presentation='" + presentation + '\'' +
                ", urlImage='" + urlImage + '\'' +
                '}';
    }
}
