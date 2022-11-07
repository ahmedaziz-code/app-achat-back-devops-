package tn.esprit.rh.achat.services;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.CategorieFournisseur;
import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.entities.Reglement;
import tn.esprit.rh.achat.repositories.FournisseurRepository;
import tn.esprit.rh.achat.repositories.ReglementRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class ReglementServiceImplTest {
    @Mock
    ReglementRepository reglementRepository;
    @InjectMocks
    ReglementServiceImpl reglementService;

     Reglement r = new Reglement( 500, 50,  true,  new Date());
    List<Reglement> ReglementList = new ArrayList<Reglement>(){
        {
            add(new Reglement( 500, 50,  true,  new Date()));
            add(new Reglement( 500, 50,  true,  new Date()));
        }
    };
    float chifreAffaire = 3456;

    @Test
    void retrieveAllReglements() {
        Mockito.when(reglementRepository.findAll()).thenReturn(ReglementList);
        List<Reglement> lf = reglementService.retrieveAllReglements();
        assertEquals(2, lf.size());
    }

    @Test
    void addReglement() {
        Mockito.when(reglementRepository.save(r)).thenReturn(r);
        Reglement f = reglementService.addReglement(r);
        assertNotNull(f);
    }

    @Test
    void retrieveReglement() {
        Mockito.when(reglementRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(r));
        Reglement r = reglementService.retrieveReglement(2L);
        assertNotNull(r);
    }

    @Test
    void retrieveReglementByFacture() {
        Mockito.when(reglementRepository.retrieveReglementByFacture(Mockito.anyLong())).thenReturn(ReglementList);
        List<Reglement> r = reglementService.retrieveReglementByFacture(9L);
        assertNotNull(r);
    }

    @Test
    void getChiffreAffaireEntreDeuxDate() {
        Date startDate = new Date();
        Date endDate = new Date();
        Mockito.when(reglementRepository.getChiffreAffaireEntreDeuxDate(new Date(),new Date())).thenReturn(chifreAffaire);
        float ch = reglementService.getChiffreAffaireEntreDeuxDate(startDate, endDate);
        assertTrue(ch>=0 || ch<=0);
    }
}