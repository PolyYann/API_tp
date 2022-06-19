package com.excellencemassotherapie.modele;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "t_paniers")
public class Panier {
    @Id
    @Column(name = "id_panier", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPanier;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "T_Paniers_Produits",foreignKey = @ForeignKey(name = "fk_panier_produit_id_panier"))
    private List<Produit> produit = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "T_Paniers_Soins",foreignKey = @ForeignKey(name = "fk_panier_soin_id_panier"))
    private List<Soin> soin = new ArrayList<>();

    @ManyToMany(mappedBy = "listPaniers")
    @Column(name = "clients")
    private List<Client> listClients = new ArrayList<>();
    @Column(name = "est_paye", nullable = false)
    private boolean paye;

    public Panier() {
    }

    public Panier(List<Produit> produit, List<Soin> soin,
                  List<Client> listClients, boolean paye) {

        this.produit = produit;
        this.soin = soin;
        this.listClients = listClients;
        this.paye = paye;
    }

    public List<Client> getListClients() {
        return listClients;
    }

    public void setListClients(List<Client> listClients) {
        this.listClients = listClients;
    }

    public boolean isPaye() {
        return paye;
    }

    public void setPaye(boolean estPaye) {
        this.paye = estPaye;
    }

    public int getIdPanier() {
        return idPanier;
    }

    public void setIdPanier(int idPanier) {
        this.idPanier = idPanier;
    }

    public List<Produit> getProduit() {
        return produit;
    }

    public void setProduit(List<Produit> produit) {
        this.produit = produit;
    }

    public List<Soin> getSoin() {
        return soin;
    }

    public void setSoin(List<Soin> soin) {
        this.soin = soin;
    }

    @Override
    public String toString() {
        return "Panier{" +
                "idPanier=" + idPanier +
                ", produit=" + produit +
                ", soin=" + soin +
                '}';
    }
}
