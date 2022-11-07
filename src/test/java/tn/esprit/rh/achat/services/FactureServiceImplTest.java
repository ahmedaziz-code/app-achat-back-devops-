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
import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.FactureRepository;
import tn.esprit.rh.achat.repositories.OperateurRepository;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FactureServiceImplTest {
//test aziz 111
    @Autowired
    IFactureService factureService;
    @Autowired
    IOperateurService iOperateurService;
    @Mock
    FactureRepository factureRepository;
    @Mock
    ReglementServiceImpl reglementService;
    @InjectMocks
    FactureServiceImpl factureServiceImp;

    Facture facture = new Facture((float) 7.4, (float) 99.2,new Date(),new Date(),false);

    List<Facture> listFacture = new ArrayList<Facture>(){
        {
            add(new Facture((float) 6.4, (float) 99.2,new Date(),new Date(),true));
            add(new Facture((float) 7.9, (float) 99.2,new Date(),new Date(),true));
        }
    };

    @Test
    @Order(1)
    void addFacture(){
        Mockito.when(factureRepository.save(facture)).thenReturn(facture);
        Facture facture1 = factureServiceImp.addFacture(facture);
        assertNotNull(facture1);
    }
    //testing triggerss
    @Test
    @Order(2)
    void retrieveAllFactures(){
        Mockito.when(factureRepository.findAll()).thenReturn(listFacture);
        List<Facture> listFacture1 = factureServiceImp.retrieveAllFactures();
        assertTrue(listFacture1.size()>=0);
    }
    @Test
    @Order(3)
    void retrieveFacture() {
        Mockito.when(factureRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(facture));
        Facture facture1 = factureServiceImp.retrieveFacture(2L);
        assertNotNull(facture1);
    }

    @Test
    @Order(4)
    void cancelFacture(){
        Mockito.doNothing().when(factureRepository).updateFacture(Mockito.anyLong());
        factureServiceImp.cancelFacture(1L);
        Mockito.verify(factureRepository, Mockito.times(1)).updateFacture(1L);
    }

//    @Test
//    @Order(6)
//    void assign(){
//        FactureServiceImpl fMock = mock(FactureServiceImpl.class);
//        Mockito.doNothing().when(fMock).assignOperateurToFacture(Mockito.anyLong(), Mockito.anyLong());
//        fMock.assignOperateurToFacture(1L,1L);
//        Mockito.verify(fMock, Mockito.times(1)).assignOperateurToFacture(1L,1L);
//    }
    @Test
    @Order(5)
    void assignOperateurToFacture() {
        Facture f = new Facture((float) 7.4, (float) 99.2,new Date(),new Date(),false);
        Operateur o = new Operateur("elj", "aziz", "123");
        Facture factureAdded = factureService.addFacture(f);
        Operateur operateurAdded = iOperateurService.addOperateur(o);
        factureService.assignOperateurToFacture(operateurAdded.getIdOperateur(),factureAdded.getIdFacture());
        assertNotNull(iOperateurService.retrieveOperateur(operateurAdded.getIdOperateur()).getFactures());
        iOperateurService.deleteOperateur(operateurAdded.getIdOperateur());
        factureRepository.delete(factureAdded);
    }



//    @Test
//    @Order(6)
//    void pourcentageRecouvrement() {
//        Date startDate = new Date();
//        Date endDate = new Date();
//        Mockito.when(factureRepository.getTotalFacturesEntreDeuxDates(startDate, endDate)).thenReturn(totaleFacture);
//        Mockito.when(reglementService.getChiffreAffaireEntreDeuxDate(startDate, endDate)).thenReturn(totaleRecouvrement);
//
//        assertNotNull();
//    }
}