package com.excellencemassotherapie.modele;

import jakarta.persistence.*;

import java.util.ArrayList;
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
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "T_Clients_Paniers", joinColumns = @JoinColumn(name = "id_client",foreignKey =
    @ForeignKey(name = "fk_panier_client_id_client")))
    private List<Panier> listPaniers = new ArrayList<>();
    @Column(name = "password",  nullable = false)
    private String password;
    public Client() {
    }

    public Client(String nom, String telephone, String email, String adresse,
                  List<Panier> listPaniers, String password) {
        this.nom = nom;
        this.telephone = telephone;
        this.email = email;
        this.adresse = adresse;
        this.listPaniers = listPaniers;
        this.password = password;
    }

    public Client(String nom, String telephone, String email, String adresse,
                  String password) {
        this.nom = nom;
        this.telephone = telephone;
        this.email = email;
        this.adresse = adresse;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
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
                ", listPaniers=" + listPaniers +
                '}';
    }
}
