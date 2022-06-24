CREATE DATABASE IF NOT EXISTS `excellence`;
USE `excellence`;
DROP TABLE IF EXISTS `t_ligne_commande`;
DROP TABLE IF EXISTS `t_paniers`;
DROP TABLE IF EXISTS `t_clients`;
DROP TABLE IF EXISTS `t_produits`;
DROP TABLE IF EXISTS `t_professionnels`;
DROP TABLE IF EXISTS `t_soins`;

CREATE TABLE `t_clients`
(
    `id_client` int          NOT NULL AUTO_INCREMENT,
    `adresse`   varchar(255) NOT NULL,
    `email`     varchar(255) NOT NULL,
    `nom`       varchar(255) NOT NULL,
    `password`  varchar(255) NOT NULL,
    `telephone` varchar(255) NOT NULL,
    PRIMARY KEY (`id_client`)
);


CREATE TABLE `t_paniers`
(
    `id_panier` int    NOT NULL AUTO_INCREMENT,
    `est_paye`  bit(1) NOT NULL,
    `id_client` int DEFAULT NULL,
    PRIMARY KEY (`id_panier`),
    KEY `FK_ID_CLIENT` (`id_client`),
    CONSTRAINT `FK_ID_CLIENT` FOREIGN KEY (`id_client`) REFERENCES `t_clients` (`id_client`)
);

CREATE TABLE `t_produits`
(
    `id_produit`  int          NOT NULL AUTO_INCREMENT,
    `categorie`   int          NOT NULL,
    `description` varchar(255) NOT NULL,
    `nom`         varchar(255) NOT NULL,
    `prix`        double       NOT NULL,
    `url_Image`   varchar(255) NOT NULL,
    PRIMARY KEY (`id_produit`)
);

CREATE TABLE `t_professionnels`
(
    `id_professionnel` int          NOT NULL AUTO_INCREMENT,
    `nom`              varchar(255) NOT NULL,
    `presentation`     varchar(255) NOT NULL,
    `url_img`          varchar(255) NOT NULL,
    PRIMARY KEY (`id_professionnel`)
);

CREATE TABLE `t_soins`
(
    `id_soin`     int          NOT NULL AUTO_INCREMENT,
    `description` varchar(255) NOT NULL,
    `duree`       int          NOT NULL,
    `nom`         varchar(255) NOT NULL,
    `prix`        double       NOT NULL,
    `url_img`     varchar(255) NOT NULL,
    PRIMARY KEY (`id_soin`)
);

CREATE TABLE `t_ligne_commande`
(
    `id_ligne_commande` int NOT NULL AUTO_INCREMENT,
    `Quantite`          int NOT NULL,
    `Id_Panier`         int DEFAULT NULL,
    `Id_Produit`        int DEFAULT NULL,
    `Id_Soin`           int DEFAULT NULL,
    PRIMARY KEY (`id_ligne_commande`),
    KEY `FKi5ybdygpbilq53cyx4sq5jc41` (`Id_Panier`),
    KEY `FK2cw6dbwsakrapbodygrpgdhf` (`Id_Produit`),
    KEY `FKrrcgp9306xbkwm5vyklyhmlxl` (`Id_Soin`),
    CONSTRAINT `FK2cw6dbwsakrapbodygrpgdhf` FOREIGN KEY (`Id_Produit`) REFERENCES `t_produits` (`id_produit`),
    CONSTRAINT `FKi5ybdygpbilq53cyx4sq5jc41` FOREIGN KEY (`Id_Panier`) REFERENCES `t_paniers` (`id_panier`),
    CONSTRAINT `FKrrcgp9306xbkwm5vyklyhmlxl` FOREIGN KEY (`Id_Soin`) REFERENCES `t_soins` (`id_soin`)
);

INSERT INTO `t_clients`
VALUES (1, '123 Main', 'jpd@gmail.com', 'Jean-Pierre Dupont', 'secret', '514-555-5555'),
       (2, '456 duCoin', 'soraya@gmail.com', 'Soraya Ferdanache', 'secret', '514-444-4444'),
       (3, '789 rue du métro', 'y.lebeau@gmail.com', 'Yann Lebeau', 'secret', '514-666-6666');

INSERT INTO `t_produits`
VALUES (1, 1, 'huile essentielle de citron', 'he citron', 12.95, 'img/1he/he_citron.jpg'),
       (2, 1, 'huile essentielle de cypres', 'he cypres', 14.95, 'img/1he/he_cypres.jpg'),
       (3, 1, 'huile essentielle de geranium', 'he geranium', 18.95, 'img/1he/he_geranium.jpg'),
       (4, 1, 'huile essentielle de lavande', 'he lavande', 18.95, 'img/1he/he_lavande.jpg'),
       (5, 1, 'huile essentielle de marjolaine', 'he marjolaine', 13.95,
        'img/1he/he_marjolaine.jpg'),
       (6, 1, 'huile essentielle de melaleuca', 'he maleleuca', 21.95, 'img/1he/he_melaleuca.jpg'),
       (7, 1, 'huile essentielle de menthe poivree', 'he menthe_proivree', 9.95,
        'img/1he/he_menthe_poivree.jpg'),
       (8, 1, 'huile essentielle de pamplemousse', 'he pamplemousse', 12.95,
        'img/1he/he_pamplemousse.jpg'),
       (9, 1, 'huile essentielle de pin', 'he pin', 23.95, 'img/1he/he_pin.jpg'),
       (10, 1, 'huile essentielle de pruche', 'he pruche', 23.95, 'img/1he/he_pruche.jpg'),
       (11, 1, 'huile essentielle de the des bois', 'he the des bois', 20.95,
        'img/1he/he_the_des_bois.jpg'),
       (12, 2, 'Soin du visage - creme rénovatrice de bioterra', 'bioterra-creme renovatrice',
        45.95, 'img/2soin_visage/bioterra_creme_renovatrice.jpg'),
       (13, 2, 'Soin du visage - game complete de bioterra', 'bioterra-game complete', 175.95,
        'img/2soin_visage/bioterra_game_complete.jpg'),
       (14, 2, 'Soin du visage - gel facial exfoliant de bioterra', 'bioterra-gel facial exfoliant',
        59.95, 'img/2soin_visage/bioterra_gel_facial_exfoliant.jpg'),
       (15, 2, 'Soin du visage - gel nettoyant de bioterra', 'bioterra-gel nettoyant', 45.95,
        'img/2soin_visage/bioterra_gel_nettoyant.jpg'),
       (16, 2, 'Soin du visage - masque facial de bioterra', 'bioterra-masque acial', 47.95,
        'img/2soin_visage/bioterra_masque_facial.jpg'),
       (17, 2, 'Soin du visage - serogel anti age de bioterra', 'bioterra-serogel anti age', 75.95,
        'img/2soin_visage/bioterra_serogel_anti_age.jpg'),
       (18, 3, 'Taping neuroproprioceptif - protape', 'Protape', 27.95, 'img/3douleur/protape.jpg'),
       (19, 3, 'Myorub - creme soulagement de la douleur ', 'myorub', 38.95,
        'img/3douleur/myorub.jpg');

INSERT INTO `t_professionnels`
VALUES (1, 'Laurianne Labrecque', 'LONGUE PRÉSENTATION À TROUVER',
        'img/professionnels/laurianne_labrecque.jpg'),
       (2, 'Luc Gauthier', 'LONGUE PRÉSENTATION À TROUVER', 'img/professionnels/luc_gauthier.jpg'),
       (3, 'Marie-Eve Beaulieu', 'LONGUE PRÉSENTATION À TROUVER',
        'img/professionnels/marie-eve_beaulieu.jpg'),
       (4, 'Véronique Brien', 'LONGUE PRÉSENTATION À TROUVER',
        'img/professionnels/veronique_brien.jpg');


INSERT INTO `t_soins`
VALUES (1, 'un massage de détente dans une ambiance relaxante', 60, 'massage de détente', 129,
        'img/soins/massage_detente.jpg'),
       (2, 'un soin de type facial, massage du visage et de la tête dans une ambiance relaxante',
        90, 'massage-facial', 119, 'img/soins/massage_facial.jpg'),
       (3, 'un massage de détente aux pierre chaudesc dans une ambiance relaxante', 90,
        'massage aux pierres chaudes', 149, 'img/soins/massage_pierre_chaude.jpg'),
       (4, 'un massage thérapeutique dans une ambiance relaxante', 60, 'massage therapeutique', 109,
        'img/soins/massage_therapeutique.jpg'),
       (5, 'un taping neuro proprioceptif pour le soulagement des muscles', 25,
        'Taping neuroproprioceptif', 25, 'img/soins/taping.jpg');
commit;