package com.excellencemassotherapie.modele;


import jakarta.persistence.*;

@Entity
@Table(name="t_professionnels")
public class Professionnel {
    @Id
    @Column(name = "id_professionnel", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProfessionnel;
    @Column(name = "nom", nullable = false)
    private String nom;
    @Column(name = "presentation", nullable = false)
    private String presentation;
    @Column(name = "url_img", nullable = false)
    private String urlImage;

    public Professionnel() {
    }

    public Professionnel( String nom, String presentation, String urlImage) {

        this.nom = nom;
        this.presentation = presentation;
        this.urlImage = urlImage;
    }

    public int getIdProfessionnel() {
        return idProfessionnel;
    }

    public void setIdProfessionnel(int idSoin) {
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
