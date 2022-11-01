package tn.esprit.rh.achat.entities;


import java.util.Set;



import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CategoryProduitDTO {
	private static final long serialVersionUID = 1L;
    @JsonIgnore
	private Long idCategorieProduit;
	private String codeCategorie;
	private String libelleCategorie;
	
	@JsonIgnore
	private Set<Produit> produits;

}
