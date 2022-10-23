package tn.esprit.rh.achat.entities;

import java.util.Date;
import java.util.Set;

public class FactureDTO {
    Long idFacture;
    float montantRemise;
    float montantFacture;
    Date dateCreationFacture;
    Date dateDerniereModificationFacture;
    Boolean archivee;
    Set<DetailFacture> detailsFacture;
    Fournisseur fournisseur;
    Set<Reglement> reglements;
}
