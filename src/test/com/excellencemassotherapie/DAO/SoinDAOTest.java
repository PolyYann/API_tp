package com.excellencemassotherapie.DAO;

import com.excellencemassotherapie.DAO.SoinDAO;
import com.excellencemassotherapie.Mock.Mock;
import com.excellencemassotherapie.modele.Soin;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SoinDAOTest {
    private static List<Soin> soins =new ArrayList<>();
    private SoinDAO soinDAO = new SoinDAO();
    @BeforeAll
    static void setUpBeforeClass() throws Exception {


        soins = Mock.getSoins();
    }

//    @Test
//    void getAll() {
//        soinDAO.connect();
//        List<Soin> CompSoins = soinDAO.getAll();
//        for(int i =0; i<soins.size();i++){
//            assertEquals(soins.get(i).getNom(),CompSoins.get(i).getNom());
//            assertEquals(soins.get(i).getDuree(),CompSoins.get(i).getDuree());
//            assertEquals(soins.get(i).getDescription(),CompSoins.get(i).getDescription());
//            assertEquals(soins.get(i).getUrlImage(),CompSoins.get(i).getUrlImage());
//            assertEquals(soins.get(i).getPrix(),CompSoins.get(i).getPrix());
//        }
//
//
//    }
//
//    @Test
//    void getById() {
//        soinDAO.connect();
//        Soin CompSoin = soinDAO.getById(3);
//        assertEquals(soins.get(2).getNom(),CompSoin.getNom());
//        assertEquals(soins.get(2).getDuree(),CompSoin.getDuree());
//        assertEquals(soins.get(2).getDescription(),CompSoin.getDescription());
//        assertEquals(soins.get(2).getUrlImage(),CompSoin.getUrlImage());
//        assertEquals(soins.get(2).getPrix(),CompSoin.getPrix());
//
//
//    }

//    @Test
//    void insert() {
//        soinDAO.connect();
//        for(Soin soin: soins){
//            soinDAO.insert(soin);
//        }
//        System.out.println(soinDAO.getById(1));
//        soinDAO.disconnect();
//    }
}