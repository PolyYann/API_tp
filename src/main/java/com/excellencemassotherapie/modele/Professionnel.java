package com.excellencemassotherapie.modele;


import jakarta.persistence.*;

@Entity
@Table(name="T_Professionnels")
public class Professionnel {
    @Id
    @Column(name = "id_professionnel", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProfessionnel;
    @Column(name = "nom", nullable = false)
    private String nom;
    @Column(name = "presentation", nullable = false)
    private String presentation;
    @Column(name = "url_img", nullable = false)
    private String urlImage;

    public Professionnel() {
    }

    public Professionnel(Long idProfessionnel, String nom, String presentation, String urlImage) {
        this.idProfessionnel = idProfessionnel;
        this.nom = nom;
        this.presentation = presentation;
        this.urlImage = urlImage;
    }

    public Long getIdProfessionnel() {
        return idProfessionnel;
    }

    public void setIdProfessionnel(Long idSoin) {
        this.idProfessionnel = idSoin;
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
                "id=" + idProfessionnel +
                ", nom='" + nom + '\'' +
                ", presentation='" + presentation + '\'' +
                ", urlImage='" + urlImage + '\'' +
                '}';
    }
}
