package Entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
public class CommandeProduit implements Serializable {

    @EmbeddedId
    private CommandProduitPk commandProduitPk;


    @ManyToOne
    @JoinColumn(name = "idCommande",referencedColumnName = "id",insertable = false,updatable = false)
    private Commande commande;


    @ManyToOne
    @JoinColumn(name = "idProduit",referencedColumnName = "id",insertable = false,updatable = false)
    private Product product;

}
