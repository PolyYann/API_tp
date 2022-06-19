CREATE DATABASE IF NOT EXISTS `excellence`;
USE `excellence`;

DROP TABLE IF EXISTS `t_paniers_produits`;
DROP TABLE IF EXISTS `t_paniers_soins`;
DROP TABLE IF EXISTS `t_clients_paniers`;
DROP TABLE IF EXISTS `t_paniers`;
DROP TABLE IF EXISTS `t_clients`;
DROP TABLE IF EXISTS `t_soins`;
DROP TABLE IF EXISTS `t_produits`;
DROP TABLE IF EXISTS `t_professionnels`;

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

CREATE TABLE `t_soins`
(
    `id_soin`     int          NOT NULL AUTO_INCREMENT,
    `description` varchar(255) NOT NULL,
    `duree`       int          NOT NULL,
    `nom`         varchar(255) NOT NULL,
    `prix`        double       NOT NULL,
    `quantite`    int          NOT NULL,
    `url_img`     varchar(255) NOT NULL,
    PRIMARY KEY (`id_soin`)
);

CREATE TABLE `t_produits`
(
    `id_produit`  int          NOT NULL AUTO_INCREMENT,
    `categorie`   int          NOT NULL,
    `description` varchar(255) NOT NULL,
    `nom`         varchar(255) NOT NULL,
    `prix`        double       NOT NULL,
    `quantite`    int          NOT NULL,
    `url_Image`   varchar(255) NOT NULL,
    PRIMARY KEY (`id_produit`)
);

CREATE TABLE `t_paniers`
(
    `id_panier`        int    NOT NULL AUTO_INCREMENT,
    `est_paye`         bit(1) NOT NULL,
    `client_id_client` int DEFAULT NULL,
    PRIMARY KEY (`id_panier`),
    KEY `fk_panier_client_id` (`client_id_client`),
    CONSTRAINT `fk_panier_client_id` FOREIGN KEY (`client_id_client`) REFERENCES `t_clients` (`id_client`)
);

CREATE TABLE `t_professionnels`
(
    `id_professionnel` int          NOT NULL AUTO_INCREMENT,
    `nom`              varchar(255) NOT NULL,
    `presentation`     varchar(255) NOT NULL,
    `url_img`          varchar(255) NOT NULL,
    PRIMARY KEY (`id_professionnel`)
);

CREATE TABLE `t_clients_paniers`
(
    `id_client`             int NOT NULL,
    `listPaniers_id_panier` int NOT NULL,
    KEY `fk_panier_client_id_panier` (`listPaniers_id_panier`),
    KEY `fk_panier_client_id_client` (`id_client`),
    CONSTRAINT `fk_panier_client_id_client` FOREIGN KEY (`id_client`) REFERENCES `t_clients` (`id_client`),
    CONSTRAINT `fk_panier_client_id_panier` FOREIGN KEY (`listPaniers_id_panier`) REFERENCES `t_paniers` (`id_panier`)
);
CREATE TABLE `t_paniers_soins`
(
    `Panier_id_panier` int NOT NULL,
    `soin_id_soin`     int NOT NULL,
    KEY `fK_panier_soin_id_soin` (`soin_id_soin`),
    KEY `fk_panier_soin_id_panier` (`Panier_id_panier`),
    CONSTRAINT `fk_panier_soin_id_panier` FOREIGN KEY (`Panier_id_panier`) REFERENCES `t_paniers` (`id_panier`),
    CONSTRAINT `fK_panier_soin_id_soin` FOREIGN KEY (`soin_id_soin`) REFERENCES `t_soins` (`id_soin`)
);

CREATE TABLE `t_paniers_produits`
(
    `Panier_id_panier`   int NOT NULL,
    `produit_id_produit` int NOT NULL,
    UNIQUE KEY `fk_panier_produit_id_produit` (`produit_id_produit`),
    KEY `fk_panier_produit_id_panier` (`Panier_id_panier`),
    CONSTRAINT `fk_panier_produit_id_panier` FOREIGN KEY (`Panier_id_panier`) REFERENCES `t_paniers` (`id_panier`),
    CONSTRAINT `fk_panier_produit_id_produit` FOREIGN KEY (`produit_id_produit`) REFERENCES `t_produits` (`id_produit`)
);

INSERT INTO `t_produits`
VALUES (1, 1, 'huile essentielle de citron', 'he citron', 12.95, 0, 'img/1he/he_citron.jpg'),
       (2, 1, 'huile essentielle de cypres', 'he cypres', 14.95, 0, 'img/1he/he_cypres.jpg'),
       (3, 1, 'huile essentielle de geranium', 'he geranium', 18.95, 0, 'img/1he/he_geranium.jpg'),
       (4, 1, 'huile essentielle de lavande', 'he lavande', 18.95, 0, 'img/1he/he_lavande.jpg'),
       (5, 1, 'huile essentielle de marjolaine', 'he marjolaine', 13.95, 0,
        'img/1he/he_marjolaine.jpg'),
       (6, 1, 'huile essentielle de melaleuca', 'he maleleuca', 21.95, 0,
        'img/1he/he_melaleuca.jpg'),
       (7, 1, 'huile essentielle de menthe poivree', 'he menthe_proivree', 9.95, 0,
        'img/1he/he_menthe_poivree.jpg'),
       (8, 1, 'huile essentielle de pamplemousse', 'he pamplemousse', 12.95, 0,
        'img/1he/he_pamplemousse.jpg'),
       (9, 1, 'huile essentielle de pin', 'he pin', 23.95, 0, 'img/1he/he_pin.jpg'),
       (10, 1, 'huile essentielle de pruche', 'he pruche', 23.95, 0, 'img/1he/he_pruche.jpg'),
       (11, 1, 'huile essentielle de the des bois', 'he the des bois', 20.95, 0,
        'img/1he/he_the_des_bois.jpg'),
       (12, 2, 'Soin du visage - creme rénovatrice de bioterra', 'bioterra-creme renovatrice',
        45.95, 0, 'img/2soin_visage/bioterra_creme_renovatrice.jpg'),
       (13, 2, 'Soin du visage - game complete de bioterra', 'bioterra-game complete', 175.95, 0,
        'img/2soin_visage/bioterra_game_complete.jpg'),
       (14, 2, 'Soin du visage - gel facial exfoliant de bioterra', 'bioterra-gel facial exfoliant',
        59.95, 0, 'img/2soin_visage/bioterra_gel_facial_exfoliant.jpg'),
       (15, 2, 'Soin du visage - gel nettoyant de bioterra', 'bioterra-gel nettoyant', 45.95, 0,
        'img/2soin_visage/bioterra_gel_nettoyant.jpg'),
       (16, 2, 'Soin du visage - masque facial de bioterra', 'bioterra-masque acial', 47.95, 0,
        'img/2soin_visage/bioterra_masque_facial.jpg'),
       (17, 2, 'Soin du visage - serogel anti age de bioterra', 'bioterra-serogel anti age', 75.95,
        0, 'img/2soin_visage/bioterra_serogel_anti_age.jpg'),
       (18, 3, 'Taping neuroproprioceptif - protape', 'Protape', 27.95, 0,
        'img/3douleur/protape.jpg'),
       (19, 3, 'Myorub - creme soulagement de la douleur ', 'myorub', 38.95, 0,
        'img/3douleur/myorub.jpg');

INSERT INTO `t_professionnels`
VALUES (1, 'Laurianne Labrecque', 'LONGUE PRÉSENTATION À TROUVER',
        'img/professionnels/laurianne_labrecque.jpg'),
       (2, 'Luc Gauthier', 'LONGUE PRÉSENTATION À TROUVER', 'img/professionnels/luc_gauthier.jpg'),
       (3, 'Marie-Eve Beaulieu', 'LONGUE PRÉSENTATION À TROUVER',
        'img/professionnels/marie-eve_beaulieu.jpg'),
       (4, 'Véronique Brien', 'LONGUE PRÉSENTATION À TROUVER',
        'img/professionnels/veronique_brien.jpg');


INSERT INTO `t_clients`
VALUES (1, '123 Main', 'jpd@gmail.com', 'Jean-Pierre Dupont', 'secret', '514-555-5555'),
       (2, '456 duCoin', 'soraya@gmail.com', 'Soraya Ferdanache', 'secret', '514-444-4444'),
       (3, '789 rue du métro', 'y.lebeau@gmail.com', 'Yann Lebeau', 'secret', '514-666-6666');
INSERT INTO `t_soins`
VALUES (1, 'un massage de détente dans une ambiance relaxante', 60, 'massage de détente', 129, 0,
        'img/soins/massage_detente.jpg'),
       (2, 'un soin de type facial, massage du visage et de la tête dans une ambiance relaxante',
        90, 'massage-facial', 119, 0, 'img/soins/massage_facial.jpg'),
       (3, 'un massage de détente aux pierre chaudesc dans une ambiance relaxante', 90,
        'massage aux pierres chaudes', 149, 0, 'img/soins/massage_pierre_chaude.jpg'),
       (4, 'un massage thérapeutique dans une ambiance relaxante', 60, 'massage therapeutique', 109,
        0, 'img/soins/massage_therapeutique.jpg'),
       (5, 'un taping neuro proprioceptif pour le soulagement des muscles', 25,
        'Taping neuroproprioceptif', 25, 0, 'img/soins/taping.jpg');
commit;
