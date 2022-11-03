package tn.esprit.rh.achat.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer;
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
import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.repositories.StockRepository;


@ExtendWith(MockitoExtension.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProduitServiceImplTest {

	
	
	   @Autowired
	    IProduitService produitService;
	   @Autowired
	    IStockService stockService;
	   @Mock
	    StockRepository stockRepository ;
	    @Mock
	    ProduitRepository produitRepository;
	    @InjectMocks
	    ProduitServiceImpl produitServiceImp;
	    @InjectMocks
	    StockServiceImpl stockServiceImp;
	    Produit produit = new Produit( " 12345", "ahmed",(float)7.4,new Date(),new Date());
	    List<Produit> listProduit = new ArrayList<Produit>(){
	        {
	            add(new Produit("123456", "ahmed1",(float)7.4,new Date(),new Date()));
	            add(new Produit("1234567", "ahmed2",(float)8.4,new Date(),new Date()));
	        }
	    };
	@Test
	void testRetrieveAllProduits() {
		Mockito.when(produitRepository.findAll()).thenReturn(listProduit);
        List<Produit> listProduit1 = produitServiceImp.retrieveAllProduits();
        assertTrue(listProduit1.size()>=0);
	}

	@Test
	void testAddProduit() {
		 Mockito.when(produitRepository.save(produit)).thenReturn(produit);
	        Produit produit1 = produitServiceImp.addProduit(produit);
	        assertNotNull(produit1);
	}

	@Test
	void testDeleteProduit() {
		 Mockito.doNothing().when(produitRepository).deleteById(Mockito.anyLong());
		 produitServiceImp.deleteProduit(3L);
	        Mockito.verify(produitRepository, Mockito.times(1)).deleteById(3L);
	}

	@Test
	void testUpdateProduit() {

	}

	@Test
	void testRetrieveProduit() {
		 Mockito.when(produitRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(produit));
	        Produit produit1 = produitServiceImp.retrieveProduit(2L);
	        assertNotNull(produit1);
	}

	@Test
	void testAssignProduitToStock() {
		  Stock s = new Stock("jjjjjj", (Integer) 9 ,(Integer) 2 );
	        Produit p = new Produit(" 12345", "lotfi",(float)7.4,new Date(),new Date());
	        Stock stockAdded = stockService.addStock(s);
	        Produit produitAdded = produitService.addProduit(p);
	       produitService.assignProduitToStock(produitAdded.getIdProduit(),stockAdded.getIdStock());
	        assertNotNull(produitService.retrieveProduit(produitAdded.getIdProduit()).getStock());
	        produitService.deleteProduit(produitAdded.getIdProduit());
	        stockRepository.delete(stockAdded);
	}

}
