package Entities;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;

@Embeddable
public class CommandProduitPk  implements Serializable {

    private int idCommande;
    private int idProduit;

    private Date date;
    private int quantite;

}
