package com.excellencemassotherapie.DAO;

import com.excellencemassotherapie.Mock.Mock;
import com.excellencemassotherapie.modele.Professionnel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProfessionnelDAOTest {
    private static List<Professionnel> professionnels =new ArrayList<>();
    private ProfessionnelDAO professionnelDAO = new ProfessionnelDAO();
    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        professionnels= Mock.getProfessionnels();
    }

    @Test
    void getAll() {
        professionnelDAO.connect();
        List<Professionnel> CompProf = professionnelDAO.getAll();
        for(int i =0; i<professionnels.size();i++){
            assertEquals(professionnels.get(i).getNom(),CompProf.get(i).getNom());
            assertEquals(professionnels.get(i).getPresentation(),CompProf.get(i).getPresentation());
            assertEquals(professionnels.get(i).getUrlImage(),CompProf.get(i).getUrlImage());
        }
    }

//    @Test
//    void insert() {
//        professionnelDAO.connect();
//        for(Professionnel professionnel: professionnels){
//            professionnelDAO.insert(professionnel);
//        }
//        professionnelDAO.disconnect();
//    }
}