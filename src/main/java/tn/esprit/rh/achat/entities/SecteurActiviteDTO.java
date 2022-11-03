package tn.esprit.rh.achat.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.Set;
@Getter
@Setter
public class SecteurActiviteDTO  implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long idSecteurActivite;
    private String codeSecteurActivite;
    private String libelleSecteurActivite;
    private Set<Fournisseur> fournisseurs;


}
