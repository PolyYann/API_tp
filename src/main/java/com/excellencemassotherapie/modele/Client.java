package com.excellencemassotherapie.modele;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "t_clients")
public class Client {
    @Id
    @Column(name = "id_client", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idClient;
    @Column(name = "nom", nullable = false)
    private String nom;
    @Column(name = "telephone", nullable = false)
    private String telephone;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "adresse", nullable = false)
    private String adresse;
    @Column(name = "password",  nullable = false)
    private String password;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_panier")
    private List<Panier> listPaniers;

    public Client() {
    }

    public Client(String nom, String telephone, String email, String adresse, String password, List<Panier> listPaniers) {
        this.nom = nom;
        this.telephone = telephone;
        this.email = email;
        this.adresse = adresse;
        this.password = password;
        this.listPaniers = listPaniers;
    }

    public Client(String nom, String telephone, String email, String adresse, String password) {
        this.nom = nom;
        this.telephone = telephone;
        this.email = email;
        this.adresse = adresse;
        this.password = password;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Panier> getListPaniers() {
        return listPaniers;
    }

    public void setListPaniers(List<Panier> listPaniers) {
        this.listPaniers = listPaniers;
    }

    @Override
    public String toString() {
        return "Client{" +
                "idClient=" + idClient +
                ", nom='" + nom + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", adresse='" + adresse + '\'' +
                ", password='" + password + '\'' +
                ", listPaniers=" + listPaniers +
                '}';
    }
}
