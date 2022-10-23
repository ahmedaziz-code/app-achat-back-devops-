package tn.esprit.rh.achat.entities;

import java.util.Set;

public class FournisseurDTO {
    Long idFournisseur;
    String code;
    String libelle;
    CategorieFournisseur  categorieFournisseur;
    Set<Facture> factures;
    Set<SecteurActivite> secteurActivites;
    DetailFournisseur detailFournisseur;
}
