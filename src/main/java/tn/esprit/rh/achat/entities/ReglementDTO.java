package tn.esprit.rh.achat.entities;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
@Getter
@Setter
public class ReglementDTO implements Serializable {
    private static final long serialVersionUID = 1L;


    private Long idReglement;
    private float montantPaye;
    private float montantRestant;
    private Boolean payee;
    private Date dateReglement;
    private Facture facture;
}
