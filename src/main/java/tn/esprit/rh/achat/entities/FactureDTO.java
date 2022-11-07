package tn.esprit.rh.achat.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
@Getter
@Setter
public class FactureDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @JsonIgnore
    private Long idFacture;
    @JsonIgnore
    private float montantRemise;
    private float montantFacture;
    private Date dateCreationFacture;
    private Date dateDerniereModificationFacture;
    private Boolean archivee;
    @JsonIgnore
    private Set<DetailFacture> detailsFacture;
    @JsonIgnore
    private Set<Reglement> reglements;
}
