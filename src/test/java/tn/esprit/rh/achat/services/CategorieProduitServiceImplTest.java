package tn.esprit.rh.achat.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
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
import tn.esprit.rh.achat.entities.CategorieProduit;
import tn.esprit.rh.achat.repositories.CategorieProduitRepository;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CategorieProduitServiceImplTest {
	
	
	 @Autowired
	    ICategorieProduitService categoryProduitService;
	    @Autowired
	    IOperateurService iOperateurService;
	    @Mock
	    CategorieProduitRepository categoryProduitRepository;
	    @InjectMocks
	    CategorieProduitServiceImpl catgoryProduitServiceImp;

	    CategorieProduit categorieproduit = new CategorieProduit( " 12345", "ahmed");
	    List<CategorieProduit> listCategorieProduit = new ArrayList<CategorieProduit>(){
	        {
	            add(new CategorieProduit("123456", "ahmed1"));
	            add(new CategorieProduit("1234567", "ahmed2"));
	        }
	    };
	    
	@Test
	@Order(2)
	void testRetrieveAllCategorieProduits() {
		Mockito.when(categoryProduitRepository.findAll()).thenReturn(listCategorieProduit);
        List<CategorieProduit> listCategorieProduit1 = catgoryProduitServiceImp.retrieveAllCategorieProduits();
        assertTrue(listCategorieProduit1.size()>=0);
	}

	 @Test
	 @Order(1)
	void testAddCategorieProduit() {
		 Mockito.when(categoryProduitRepository.save(categorieproduit)).thenReturn(categorieproduit);
	        CategorieProduit cateegoryproduit1 = catgoryProduitServiceImp.addCategorieProduit(categorieproduit);
	        assertNotNull(cateegoryproduit1);
	}

	@Test
	 @Order(4)
	void testDeleteCategorieProduit() {
		 Mockito.doNothing().when(categoryProduitRepository).deleteById(Mockito.anyLong());
		 catgoryProduitServiceImp.deleteCategorieProduit(3L);
	        Mockito.verify(categoryProduitRepository, Mockito.times(1)).deleteById(3L);
	}


	@Test
	@Order(3)
	void testRetrieveCategorieProduit() {
		 Mockito.when(categoryProduitRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(categorieproduit));
	        CategorieProduit categorieProduit1 = catgoryProduitServiceImp.retrieveCategorieProduit(2L);
	        assertNotNull(categorieProduit1);
	}

}
