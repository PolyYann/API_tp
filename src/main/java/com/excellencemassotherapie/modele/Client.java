package com.excellencemassotherapie.modele;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "T_Clients")
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
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "T_Clients_Paniers", joinColumns = @JoinColumn(name = "id_client"),
            inverseJoinColumns = @JoinColumn(name = "id_panier"))
    private List<Panier> listPaniers = new ArrayList<>();

    public Client() {
    }

    public Client(Long idClient, String nom, String telephone, String email,
                  String adresse, List<Panier> listPaniers) {
        this.idClient = idClient;
        this.nom = nom;
        this.telephone = telephone;
        this.email = email;
        this.adresse = adresse;
        this.listPaniers = listPaniers;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
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
