package com.excellencemassotherapie.modele;

import jakarta.persistence.*;

@Entity
@Table(name="T_Clients")
public class Client {
    @Id
    @Column(name = "id_client", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;
    @Column(name = "nom", nullable = false)
    private String nom;
    @Column(name = "telephone", nullable = false)
    private String telephone;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "adresse", nullable = false)
    private String adresse;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_panier")
    private Panier panier;

    public Client() {
    }

    public Client(Long idClient, String nom, String telephone, String email, String adresse, Panier panier) {
        this.idClient = idClient;
        this.nom = nom;
        this.telephone = telephone;
        this.email = email;
        this.adresse = adresse;
        this.panier = panier;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long id) {
        this.idClient = id;
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
                "id=" + idClient +
                ", nom='" + nom + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", adresse='" + adresse + '\'' +
                ", panier=" + panier +
                '}';
    }
}
