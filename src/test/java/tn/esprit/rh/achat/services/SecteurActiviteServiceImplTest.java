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
import tn.esprit.rh.achat.entities.Reglement;
import tn.esprit.rh.achat.entities.SecteurActivite;
import tn.esprit.rh.achat.repositories.ReglementRepository;
import tn.esprit.rh.achat.repositories.SecteurActiviteRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class SecteurActiviteServiceImplTest {

    @Mock
    SecteurActiviteRepository secteurActiviteRepository;
    @InjectMocks
    SecteurActiviteServiceImpl secteurActiviteService;

    SecteurActivite SR = new SecteurActivite( "bhbh" , "cddx");
    List<SecteurActivite> SecteurActiviteList = new ArrayList<SecteurActivite>(){
        {
            add(new SecteurActivite( "bhbh" , "cddx"));
            add(new SecteurActivite( "bhbh" , "cddx"));
        }
    };


    @Test
    void retrieveAllSecteurActivite() {
        Mockito.when(secteurActiviteRepository.findAll()).thenReturn(SecteurActiviteList);
        List<SecteurActivite> lf = secteurActiviteService.retrieveAllSecteurActivite();
        assertEquals(2, lf.size());
    }

    @Test
    void addSecteurActivite() {
        Mockito.when(secteurActiviteRepository.save(SR)).thenReturn(SR);
        SecteurActivite f = secteurActiviteService.addSecteurActivite(SR);
        assertNotNull(f);
    }

    @Test
    void deleteSecteurActivite() {
        Mockito.doNothing().when(secteurActiviteRepository).deleteById(Mockito.anyLong());
        secteurActiviteService.deleteSecteurActivite(3L);
        Mockito.verify(secteurActiviteRepository, Mockito.times(1)).deleteById(3L);
    }

    @Test
    void updateSecteurActivite() {
        Mockito.when(secteurActiviteRepository.save(SR)).thenReturn(SR);
        SecteurActivite f = secteurActiviteService.addSecteurActivite(SR);
        assertNotNull(f);
    }

    @Test
    void retrieveSecteurActivite() {
        Mockito.when(secteurActiviteRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(SR));
        SecteurActivite r = secteurActiviteService.retrieveSecteurActivite(2L);
        assertNotNull(r);
    }
}