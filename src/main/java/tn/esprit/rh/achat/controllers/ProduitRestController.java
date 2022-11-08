package tn.esprit.rh.achat.controllers;

import io.swagger.annotations.Api;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.entities.ProduitDTO;
import tn.esprit.rh.achat.services.IProduitService;

import java.util.List;


@RestController
@Api(tags = "Gestion des produits")
@RequestMapping("/produit")
@CrossOrigin("*")
public class ProduitRestController {

	@Autowired
	IProduitService produitService;

	
	@GetMapping("/retrieve-all-produits")
	@ResponseBody
	public List<Produit> getProduits() {
		return produitService.retrieveAllProduits();
		
	}

	
	@GetMapping("/retrieve-produit/{produit-id}")
	@ResponseBody
	public Produit retrieveRayon(@PathVariable("produit-id") Long produitId) {
		return produitService.retrieveProduit(produitId);
	}


	@PostMapping("/add-produit")
	@ResponseBody
	public Produit addProduit(@RequestBody ProduitDTO p) {
		Produit produit = new Produit();
		BeanUtils.copyProperties(p, produit);
		return  produitService.addProduit(produit);
		
	}

	
	@DeleteMapping("/remove-produit/{produit-id}")
	@ResponseBody
	public void removeProduit(@PathVariable("produit-id") Long produitId) {
		produitService.deleteProduit(produitId);
	}

	
	@PutMapping("/modify-produit")
	@ResponseBody
	public Produit modifyProduit(@RequestBody ProduitDTO p) {
		Produit produit =new Produit ();
		BeanUtils.copyProperties(p, produit);
		return produitService.updateProduit(produit);
	}


	@PutMapping(value = "/assignProduitToStock/{idProduit}/{idStock}")
	public void assignProduitToStock(@PathVariable("idProduit") Long idProduit, @PathVariable("idStock") Long idStock) {
		produitService.assignProduitToStock(idProduit, idStock);
	}



}
