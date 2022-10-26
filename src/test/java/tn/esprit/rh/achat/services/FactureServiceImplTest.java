package tn.esprit.rh.achat.services;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.entities.Operateur;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FactureServiceImplTest {

    @Autowired
    IFactureService factureService;
    @Autowired
    IOperateurService iOperateurService;

    @Test
    @Order(2)
    void retrieveAllFactures() {
        List<Facture> factures = factureService.retrieveAllFactures();
        assertTrue(factures.size()>=0);
    }

    @Test
    @Order(1)
    void addFacture() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateCreation = dateFormat.parse("2022-10-25",new ParsePosition(0));
        Date dateDernierModification = dateFormat.parse("2022-10-26",new ParsePosition(0));
        Facture f = new Facture((float) 7.4, (float) 99.2,dateCreation,dateDernierModification,true);
        Facture factureAdded = factureService.addFacture(f);
        assertEquals(f.getArchivee(),factureAdded.getArchivee());
    }

    @Test
    @Order(7)
    void cancelFacture() {
        factureService.cancelFacture(1L);
        assertEquals(true, factureService.retrieveFacture(1L).getArchivee());
    }

    @Test
    @Order(3)
    void retrieveFacture() {
        Facture f = factureService.retrieveFacture(1L);
        assertNotNull(f);
    }

//    @Test
//    @Order(5)
//    void getFacturesByFournisseur() {
//        List<Facture> factures = factureService.getFacturesByFournisseur(1L);
//        assertTrue(factures.size()>=0);
//    }

    @Test
    @Order(4)
    void assignOperateurToFacture() {
        Operateur o = new Operateur("elj", "aziz", "123");
        Operateur operateurAdded = iOperateurService.addOperateur(o);
        factureService.assignOperateurToFacture(operateurAdded.getIdOperateur(),1L);
        assertNotNull(iOperateurService.retrieveOperateur(1L).getFactures());
        iOperateurService.deleteOperateur(operateurAdded.getIdOperateur());
    }

//    @Test
//    @Order(6)
//    void pourcentageRecouvrement() {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date date1 = dateFormat.parse("2022-10-25",new ParsePosition(0));
//        Date date2 = dateFormat.parse("2022-10-26",new ParsePosition(0));
//        float p = factureService.pourcentageRecouvrement(date1,date2);
//        assertTrue(p>=0);
//    }
}