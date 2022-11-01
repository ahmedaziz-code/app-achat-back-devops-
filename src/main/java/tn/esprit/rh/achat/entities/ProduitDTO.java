package tn.esprit.rh.achat.entities;

import java.util.Date;
import java.util.Set;


import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ProduitDTO {
	private static final long serialVersionUID = 1L;

	private Long idProduit;
	private String codeProduit;
	private String libelleProduit;
	private float prix;

	private Date dateCreation;
	
	private Date dateDerniereModification;
	
	@JsonIgnore
	private Stock stock;

	@JsonIgnore
	private Set<DetailFacture> detailFacture;

	@JsonIgnore
	private CategorieProduit categorieProduit;

}
