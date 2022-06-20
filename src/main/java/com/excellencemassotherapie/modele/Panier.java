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


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_client")
    private Client client;

    @Column(name = "est_paye", nullable = false)
    private boolean paye;

    public Panier() {
    }

    public Panier(Client client, boolean paye) {
        this.client = client;
        this.paye = paye;
    }

    public int getIdPanier() {
        return idPanier;
    }

    public void setIdPanier(int idPanier) {
        this.idPanier = idPanier;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public boolean isPaye() {
        return paye;
    }

    public void setPaye(boolean paye) {
        this.paye = paye;
    }

    @Override
    public String toString() {
        return "Panier{" +
                "idPanier=" + idPanier +
                ", client=" + client.getIdClient() +
                ", paye=" + paye +
                '}';
    }
}
