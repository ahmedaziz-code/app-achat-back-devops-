package tn.esprit.rh.achat.services;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tn.esprit.rh.achat.entities.*;
import tn.esprit.rh.achat.repositories.DetailFournisseurRepository;
import tn.esprit.rh.achat.repositories.FournisseurRepository;
import tn.esprit.rh.achat.repositories.SecteurActiviteRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class IFournisseurServiceTest {
    @Mock
    FournisseurRepository fournisseurRepository;
    @InjectMocks
    FournisseurServiceImpl fournisseurServiceImp;
//test
    private final FournisseurServiceImpl fourService = mock(FournisseurServiceImpl.class);
    Fournisseur fournisseur = new Fournisseur("code", "libelle", CategorieFournisseur.ORDINAIRE);
    DetailFournisseur df = new DetailFournisseur("aziz@email", new Date(), "bardo", "ADC123");
    List<Fournisseur> fournisseurList = new ArrayList<Fournisseur>(){
        {
            add(new Fournisseur("code1", "libelle1", CategorieFournisseur.ORDINAIRE));
            add(new Fournisseur("code2", "libelle2", CategorieFournisseur.CONVENTIONNE));
        }
    };
    @Test
    @Order(1)
    void addFournisseur() {
        Mockito.when(fournisseurRepository.save(fournisseur)).thenReturn(fournisseur);
        Fournisseur f = fournisseurServiceImp.addFournisseur(fournisseur);
        assertNotNull(f);
    }
    @Test
    @Order(2)
    void retrieveAllFournisseurs() {
        Mockito.when(fournisseurRepository.findAll()).thenReturn(fournisseurList);
        List<Fournisseur> lf = fournisseurServiceImp.retrieveAllFournisseurs();
        assertEquals(2, lf.size());
    }
    @Test
    @Order(3)
    void retrieveFournisseur() {
        Mockito.when(fournisseurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(fournisseur));
        Fournisseur f = fournisseurServiceImp.retrieveFournisseur(2L);
        assertNotNull(f);
    }
    @Test
    @Order(5)
    void deleteFournisseur() {
        Mockito.doNothing().when(fournisseurRepository).deleteById(Mockito.anyLong());
        fournisseurServiceImp.deleteFournisseur(3L);
        Mockito.verify(fournisseurRepository, Mockito.times(1)).deleteById(3L);
    }





    @Test
    @Order(4)
    void assignSecteurActiviteToFournisseur() {
        Mockito.doNothing().when(fourService).assignSecteurActiviteToFournisseur(Mockito.anyLong(), Mockito.anyLong());
        fourService.assignSecteurActiviteToFournisseur(3L, 5L);
        Mockito.verify(fourService, Mockito.times(1)).assignSecteurActiviteToFournisseur(3L, 5L);
    }
}