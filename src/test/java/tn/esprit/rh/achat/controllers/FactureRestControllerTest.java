package tn.esprit.rh.achat.controllers;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.services.FactureServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FactureRestControllerTest {
    @Mock
    FactureServiceImpl factureService;
    @InjectMocks
    FactureRestController factureRestController;

    Facture facture = new Facture((float) 7.4, (float) 99.2,new Date(),new Date(),false);

    List<Facture> listFacture = new ArrayList<Facture>(){
        {
            add(new Facture((float) 6.4, (float) 99.2,new Date(),new Date(),true));
            add(new Facture((float) 7.9, (float) 99.2,new Date(),new Date(),true));
        }
    };

    @Test
    @Order(1)
    void getFactures() {
        Mockito.when(factureService.retrieveAllFactures()).thenReturn(listFacture);
        List<Facture> list = factureRestController.getFactures();
        assertNotNull(list);
    }

    @Test
    void retrieveFacture() {
        Mockito.when(factureService.retrieveFacture(Mockito.anyLong())).thenReturn(facture);
        Facture restreivedFacture = factureRestController.retrieveFacture(2L);
        assertNotNull(restreivedFacture);
    }


}