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


    @Test
    void getAll() {
    }

    @Test
    void getById() {
    }

    @Test
    void getByName() {
    }

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