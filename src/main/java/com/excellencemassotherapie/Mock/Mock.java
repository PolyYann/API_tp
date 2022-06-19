package com.excellencemassotherapie.Mock;

import com.excellencemassotherapie.modele.Client;
import com.excellencemassotherapie.modele.Produit;
import com.excellencemassotherapie.modele.Professionnel;
import com.excellencemassotherapie.modele.Soin;

import java.util.ArrayList;
import java.util.List;

public class Mock {

    static final Produit prod1 = new Produit("he citron", "huile essentielle de citron", "img/1he/he_citron.jpg",
            1, 12.95,0);
    static final Produit prod2 = new Produit("he cypres", "huile essentielle de cypres", "img/1he/he_cypres.jpg",
            1, 14.95,0);
    static final Produit prod3 = new Produit("he geranium", "huile essentielle de geranium", "img/1he/he_geranium.jpg"
            , 1, 18.95,0);
    static final Produit prod4 = new Produit("he lavande", "huile essentielle de lavande", "img/1he/he_lavande.jpg",
            1, 18.95,0);
    static final Produit prod5 = new Produit("he marjolaine", "huile essentielle de marjolaine",
            "img/1he/he_marjolaine.jpg", 1, 13.95,0);
    static final Produit prod6 = new Produit("he maleleuca", "huile essentielle de melaleuca",
            "img/1he/he_melaleuca.jpg", 1, 21.95,0);
    static final Produit prod7 = new Produit("he menthe_proivree", "huile essentielle de menthe poivree",
            "img/1he/he_menthe_poivree.jpg", 1, 9.95,0);
    static final Produit prod8 = new Produit("he pamplemousse", "huile essentielle de pamplemousse",
            "img/1he/he_pamplemousse.jpg", 1, 12.95,0);
    static final Produit prod9 = new Produit("he pin", "huile essentielle de pin", "img/1he/he_pin.jpg", 1, 23.95,0);
    static final Produit prod10 = new Produit("he pruche", "huile essentielle de pruche", "img/1he/he_pruche.jpg",
            1, 23.95,0);
    static final Produit prod11 = new Produit("he the des bois", "huile essentielle de the des bois",
            "img/1he/he_the_des_bois.jpg", 1, 20.95,0);
    static final Produit prod12 = new Produit("bioterra-creme renovatrice", "Soin du visage - creme rénovatrice de " +
            "bioterra", "img/2soin_visage/bioterra_creme_renovatrice.jpg", 2, 45.95,0);
    static final Produit prod13 = new Produit("bioterra-game complete", "Soin du visage - game complete de bioterra",
            "img/2soin_visage/bioterra_game_complete.jpg", 2, 175.95,0);
    static final Produit prod15 = new Produit("bioterra-gel facial exfoliant", "Soin du visage - gel facial exfoliant " +
            "de bioterra", "img/2soin_visage/bioterra_gel_facial_exfoliant.jpg", 2, 59.95,0);
    static final Produit prod16 = new Produit("bioterra-gel nettoyant", "Soin du visage - gel nettoyant de bioterra",
            "img/2soin_visage/bioterra_gel_nettoyant.jpg", 2, 45.95,0);
    static final Produit prod17 = new Produit("bioterra-masque acial", "Soin du visage - masque facial de bioterra",
            "img/2soin_visage/bioterra_masque_facial.jpg", 2, 47.95,0);
    static final Produit prod18 = new Produit("bioterra-serogel anti age", "Soin du visage - serogel anti age de " +
            "bioterra", "img/2soin_visage/bioterra_serogel_anti_age.jpg", 2, 75.95,0);
    static final Produit prod19 = new Produit("Protape", "Taping neuroproprioceptif - protape",
            "img/3douleur/protape.jpg", 3, 27.95,0);
    static final Produit prod20 = new Produit("myorub", "Myorub - creme soulagement de la douleur ",
            "img/3douleur/myorub.jpg", 3, 38.95,0);


    public static List<Produit> getProduits() {
        List<Produit> produitList = new ArrayList<>();
        ajouterList(produitList, prod1, prod2, prod3);
        ajouterList(produitList, prod4, prod5, prod6);
        ajouterList(produitList, prod7, prod8, prod9);
        ajouterList(produitList, prod10, prod11, prod12);
        ajouterList(produitList, prod13, prod15, prod16);
        ajouterList(produitList, prod17, prod18, prod19);
        produitList.add(prod20);
        return produitList;
    }

    private static void ajouterList(List list, Object obj1, Object obj2, Object obj3) {
        list.add(obj1);
        list.add(obj2);
        list.add(obj3);
    }

    static final Soin soin1 = new Soin("massage de détente", 60, "un massage de détente dans une ambiance relaxante",
            "img/soins/massage_detente.jpg", 129.00,0);
    static final Soin soin2 = new Soin("massage-facial", 90, "un soin de type facial, massage du visage et de la tête" +
            " dans une ambiance relaxante", "img/soins/massage_facial.jpg", 119.00,0);
    static final Soin soin3 = new Soin("massage aux pierres chaudes", 90, "un massage de détente aux pierre chaudesc " +
            "dans une ambiance relaxante", "img/soins/massage_pierre_chaude.jpg", 149.00,0);
    static final Soin soin4 = new Soin("massage therapeutique", 60, "un massage thérapeutique dans une ambiance relaxante"
            , "img/soins/massage_therapeutique.jpg", 109.00,0);
    static final Soin soin5 = new Soin("Taping neuroproprioceptif", 25, "un taping neuro proprioceptif pour " +
            "le soulagement des muscles", "img/soins/taping.jpg", 25.00,0);

    public static List<Soin> getSoins() {
        List<Soin> soinList = new ArrayList<>();
        ajouterList(soinList, soin1, soin2, soin3);
        soinList.add(soin4);
        soinList.add(soin5);
        return soinList;
    }
    //mock Professionnel
    static final Professionnel prof1 = new Professionnel("Laurianne Labrecque", "LONGUE PRÉSENTATION À TROUVER",
            "img/professionnels/laurianne_labrecque.jpg");
    static final Professionnel prof2 = new Professionnel("Luc Gauthier", "LONGUE PRÉSENTATION À TROUVER",
            "img/professionnels/luc_gauthier.jpg");
    static final Professionnel prof3 = new Professionnel("Marie-Eve Beaulieu", "LONGUE PRÉSENTATION À TROUVER",
            "img/professionnels/marie-eve_beaulieu.jpg");
    static final Professionnel prof4 = new Professionnel("Véronique Brien", "LONGUE PRÉSENTATION À TROUVER",
            "img/professionnels/veronique_brien.jpg");

    public static List<Professionnel> getProfessionnels() {
        List<Professionnel> professionnelList = new ArrayList<>();
        ajouterList(professionnelList, prof1, prof2, prof3);
        professionnelList.add(prof4);
        return professionnelList;
    }

    //mock Client
    static final Client client1 = new Client("Jean-Pierre Dupont", "514-555-5555", "jpd@gmail.com","123 Main","secret");
    static final Client client2 = new Client("Soraya Ferdanache", "514-444-4444", "soraya@gmail.com","456 duCoin",
            "secret");
    static final Client client3 = new Client("Yann Lebeau", "514-666-6666", "y.lebeau@gmail.com","789 rue du métro",
            "secret");

    public static List<Client> getClients() {
        List<Client> clientList = new ArrayList<>();
       ajouterList(clientList, client1, client2, client3);
        return clientList;
    }


}
