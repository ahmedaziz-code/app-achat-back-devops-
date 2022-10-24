package tn.esprit.rh.achat.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;
@Getter
@Setter
public class FournisseurDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @JsonIgnore
    private Long idFournisseur;
    private String code;
    private String libelle;
    private CategorieFournisseur  categorieFournisseur;
    @JsonIgnore
    private Set<Facture> factures;
    @JsonIgnore
    private Set<SecteurActivite> secteurActivites;
    @JsonIgnore
    private DetailFournisseur detailFournisseur;
}
