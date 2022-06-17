package com.excellencemassotherapie.modele;

import jakarta.persistence.*;

@Entity
@Table(name="T_Clients")
public class Client {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String telephone;
    private String email;
    private String adresse;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_panier")
    private Panier panier;

    public Client() {
    }

    public Client(Long id, String nom, String telephone, String email, String adresse, Panier panier) {
        this.id = id;
        this.nom = nom;
        this.telephone = telephone;
        this.email = email;
        this.adresse = adresse;
        this.panier = panier;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Panier getPanier() {
        return panier;
    }

    public void setPanier(Panier panier) {
        this.panier = panier;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", adresse='" + adresse + '\'' +
                ", panier=" + panier +
                '}';
    }
}
