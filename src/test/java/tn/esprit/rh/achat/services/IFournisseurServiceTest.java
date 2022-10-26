package tn.esprit.rh.achat.services;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.CategorieFournisseur;
import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.entities.FournisseurDTO;
import tn.esprit.rh.achat.entities.SecteurActivite;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class IFournisseurServiceTest {
    @Autowired
    IFournisseurService fournisseurService;
    @Autowired
    ISecteurActiviteService iSecteurActiviteService;

    @Test
    @Order(2)
    void retrieveAllFournisseurs() {
        List<Fournisseur> fournisseurs = fournisseurService.retrieveAllFournisseurs();
        assertTrue(fournisseurs.size()>=0);
    }

    @Test
    @Order(1)
    void addFournisseur() {
        Fournisseur f = new Fournisseur("az12", "libeller", CategorieFournisseur.CONVENTIONNE);
        Fournisseur fournisseurAdded = fournisseurService.addFournisseur(f);
        assertEquals(f.getCode(), fournisseurAdded.getCode());
    }

    @Test
    @Order(5)
    void deleteFournisseur() {
        Fournisseur f = fournisseurService.addFournisseur(new Fournisseur());
        fournisseurService.deleteFournisseur(f.getIdFournisseur());
        assertNull(fournisseurService.retrieveFournisseur(f.getIdFournisseur()));
    }

    @Test
    @Order(6)
    void updateFournisseur() {

    }

    @Test
    @Order(3)
    void retrieveFournisseur() {
        Fournisseur f = fournisseurService.addFournisseur(new Fournisseur());
        Fournisseur fournisseurRetrieved = fournisseurService.retrieveFournisseur(f.getIdFournisseur());
        assertNotNull(fournisseurRetrieved);
        fournisseurService.deleteFournisseur(f.getIdFournisseur());
    }

//    @Test
//    @Order(4)
//    void assignSecteurActiviteToFournisseur() {
//        SecteurActivite sa = new SecteurActivite("aa","bb");
//        SecteurActivite saAdded = iSecteurActiviteService.addSecteurActivite(sa);
//        fournisseurService.assignSecteurActiviteToFournisseur(saAdded.getIdSecteurActivite(),1L);
//        assertNotNull(fournisseurService.retrieveFournisseur(1L).getSecteurActivites());
//        iSecteurActiviteService.deleteSecteurActivite(saAdded.getIdSecteurActivite());
//    }
}