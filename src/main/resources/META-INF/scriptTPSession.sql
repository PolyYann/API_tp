DROP DATABASE IF EXISTS excellence;
CREATE DATABASE excellence;
USE excellence;

INSERT INTO produits (nom, description, url_image, type, prix) 
VALUES
("he citron", "huile essentielle de citron", "cd../img/he/he_citron.jpg", "huile essentielle", 12.95),
("he cypres", "huile essentielle de cypres", "cd../img/he/he_cypres.jpg", "huile essentielle", 14.95),
("he geranium", "huile essentielle de geranium", "cd../img/he/he_geranium.jpg", "huile essentielle", 18.95),
("he lavande", "huile essentielle de lavande", "cd../img/he/he_lavande.jpg", "huile essentielle", 18.95),
("he marjolaine", "huile essentielle de marjolaine", "cd../img/he/he_marjolaine.jpg", "huile essentielle", 13.95),
("he maleleuca", "huile essentielle de melaleuca", "cd../img/he/he_melaleuca.jpg", "huile essentielle", 21.95),
("he menthe_proivree", "huile essentielle de menthe poivree", "cd../img/he/he_menthe_poivree.jpg", "huile essentielle", 9.95),
("he geranium", "huile essentielle de geranium", "cd../img/he/he_geranium.jpg", "huile essentielle", 18.95),
("he pamplemousse", "huile essentielle de pamplemousse", "cd../img/he/he_pamplemousse.jpg", "huile essentielle", 12.95),
("he pin", "huile essentielle de pin", "cd../img/he/he_pin.jpg", "huile essentielle", 23.95),
("he pruche", "huile essentielle de pruche", "cd../img/he/he_pruche.jpg", "huile essentielle", 23.95),
("he the des bois", "huile essentielle de the des bois", "cd../img/he/he_the_des_bois.jpg", "huile essentielle", 20.95),
("bioterra-creme renovatrice", "Soin du visage - creme rénovatrice de bioterra", "cd../img/soin_visage/bioterra_creme_renovatrice.jpg", "soin du visage", 45.95),
("bioterra-game complete", "Soin du visage - game complete de bioterra", "cd../img/soin_visage/bioterra_game_complete.jpg", "soin du visage", 175.95),
("bioterra-gel facial exfoliant", "Soin du visage - gel facial exfoliant de bioterra", "cd../img/soin_visage/bioterra_gel_facial_exfoliant.jpg", "soin du visage", 59.95),
("bioterra-gel nettoyant", "Soin du visage - gel nettoyant de bioterra", "cd../img/soin_visage/bioterra_gel_nettoyant.jpg", "soin du visage", 45.95),
("bioterra-masque acial", "Soin du visage - masque facial de bioterra", "cd../img/soin_visage/bioterra_masque_facial.jpg", "soin du visage", 47.95),
("bioterra-serogel anti age", "Soin du visage - serogel anti age de bioterra", "cd../img/soin_visage/bioterra_serogel_anti_age.jpg", "soin du visage", 75.95),
("Protape", "Taping neuroproprioceptif - protape", "cd../img/douleur/protape.jpg", "douleur", 27.95),
("myorub", "Myorub - creme soulagement de la douleur ", "cd../img/douleur/myorub.jpg", "douleur", 38.95)
;

INSERT INTO soins (nom, duree, description, url_image, prix) 
VALUES
("massage de détente", "60 minutes", "un massage de détente dans une ambiance relaxante", "cd../img/soins/massage_detente.jpg", 129.00),
("massage-facial", "90 minutes", "un soin de type facial, massage du visage et de la tête dans une ambiance relaxante", "cd../img/soins/massage_facial.jpg", 119.00),
("massage aux pierres chaudes", "90 minutes", "un massage de détente aux pierre chaudesc dans une ambiance relaxante", "cd../img/soins/massage_pierre_chaude.jpg", 149.00),
("massage therapeutique", "60 minutes", "un massage thérapeutique dans une ambiance relaxante", "cd../img/soins/massage_therapeutique.jpg", 109.00),
("Taping neuroproprioceptif", "25 minutes", "un taping neuro proprioceptif pour le soulagement des muscles", "cd../img/soins/taping.jpg", 25.00)
;