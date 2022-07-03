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
VALUES (1, 1, 'H.E. citron - format 15ml', 'Huile essentielle de citron', 12.95, 'img/1he/he_citron.jpg'),
       (2, 1, 'H.E. cypres - format 15ml', 'Huile essentielle decypres', 14.95, 'img/1he/he_cypres.jpg'),
       (3, 1, 'H.E. geranium - format 15ml', 'Huile essentielle degeranium', 18.95, 'img/1he/he_geranium.jpg'),
       (4, 1, 'H.E. lavande - format 15ml', 'Huile essentielle delavande', 18.95, 'img/1he/he_lavande.jpg'),
       (5, 1, 'H.E. marjolaine - format 15ml', 'Huile essentielle demarjolaine', 13.95,
        'img/1he/he_marjolaine.jpg'),
       (6, 1, 'H.E. melaleuca - format 15ml', 'Huile essentielle demaleleuca', 21.95, 'img/1he/he_melaleuca.jpg'),
       (7, 1, 'H.E. menthe poivree - format 15ml', 'Huile essentielle de menthe_proivree', 9.95,
        'img/1he/he_menthe_poivree.jpg'),
       (8, 1, 'H.E. pamplemousse - format 15ml', 'Huile essentielle depamplemousse', 12.95,
        'img/1he/he_pamplemousse.jpg'),
       (9, 1, 'H.E. pin', 'Huile essentielle de pin - format 15ml', 23.95, 'img/1he/he_pin.jpg'),
       (10, 1, 'H.E. pruche', 'Huile essentielle depruche - format 15ml', 23.95, 'img/1he/he_pruche.jpg'),
       (11, 1, 'H.E. the des bois - format 15ml', 'Huile essentielle dethe des bois', 20.95,
        'img/1he/he_the_des_bois.jpg'),
       (12, 2, 'Creme renovatrice de Bioterra pour le visage', 'Creme renovatrice',
        45.95, 'img/2soin_visage/bioterra_creme_renovatrice.jpg'),
       (13, 2, 'Game complete de Bioterra pour le visage', 'Game complete', 175.95,
        'img/2soin_visage/bioterra_game_complete.jpg'),
       (14, 2, 'Gel facial exfoliant de Bioterra', 'Gel exfoliant',
        59.95, 'img/2soin_visage/bioterra_gel_facial_exfoliant.jpg'),
       (15, 2, 'Gel nettoyant de Bioterra pour le visage', 'Gel nettoyant', 45.95,
        'img/2soin_visage/bioterra_gel_nettoyant.jpg'),
       (16, 2, 'Masque facial de Bioterra', 'Masque facial', 47.95,
        'img/2soin_visage/bioterra_masque_facial.jpg'),
       (17, 2, 'Serogel anti age de Bioterra', 'Serogel anti age', 75.95,
        'img/2soin_visage/bioterra_serogel_anti_age.jpg'),
       (18, 3, 'Taping neuroproprioceptif ', 'Protape', 27.95, 'img/3douleur/protape.jpg'),
       (19, 3, 'Creme soulagement de la douleur ', 'Myorub', 38.95,
        'img/3douleur/myorub.jpg');

INSERT INTO `t_professionnels`
VALUES (1, 'Laurianne Labrecque', 'Laurianne est massothérapeute diplômée de Guijek et membre de la Fédération Québécoise des Massothérapeutes agréés (FQM) depuis 2007.',
        'img/professionnels/laurianne_labrecque.jpg'),
       (2, 'Luc Gauthier', 'Luc est thérapeute du sport diplômé de l''Université Concordia et massothérapeute diplômé de Kiné-Concept à Montréal, membre du Réseau des massothérapeutes professionnels du Québec depuis 2011.',
        'img/professionnels/luc_gauthier.jpg'),
       (3, 'Marie-Eve Beaulieu', 'Marie-Eve est massothérapeute, premier répondant sportive, diplômée de l''Institut Kiné-Concept à Montréal et membre de la Fédération Québécoise des Massothérapeutes (FQM) depuis 2002.',
        'img/professionnels/marie-eve_beaulieu.jpg'),
       (4, 'Véronique Brien', 'Véronique est technologue en physiothérapie diplômée du Cégep Marie-Victorin à Montréal et membre de l''Ordre professionnel de la physiothérapie du Québec.',
        'img/professionnels/veronique_brien.jpg');


INSERT INTO `t_soins`
VALUES (1, 'Un massage de détente dans une ambiance relaxante', 60, 'Massage de détente', 129,
        'img/soins/massage_detente.jpg'),
       (2, 'Un soin de type facial, massage du visage et de la tête dans une ambiance relaxante',
        90, 'Massage-facial', 119, 'img/soins/massage_facial.jpg'),
       (3, 'Un massage de détente aux pierre chaudesc dans une ambiance relaxante', 90,
        'Massage aux pierres chaudes', 149, 'img/soins/massage_pierre_chaude.jpg'),
       (4, 'Un massage thérapeutique dans une ambiance relaxante', 60, 'Massage therapeutique', 109,
        'img/soins/massage_therapeutique.jpg'),
       (5, 'Un taping neuro proprioceptif pour le soulagement des muscles', 25,
        'Taping', 25, 'img/soins/taping.jpg');
commit;