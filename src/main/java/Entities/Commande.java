package Entities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Commande implements Serializable {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Basic
    @Column(name = "idStation")
    private int idStation;
    @Basic
    @Column(name = "idState")
    private int idState;

    //relations



    @OneToMany(mappedBy = "product")
    private List<CommandeProduit> commandeProduitList;

    @ManyToOne
    private Users gerant;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public int getIdStation() {
        return idStation;
    }

    public void setIdStation(int idStation) {
        this.idStation = idStation;
    }


    public Users getGerant() {
        return gerant;
    }

    public void setGerant(Users gerant) {
        this.gerant = gerant;
    }

    public int getIdState() {
        return idState;
    }

    public void setIdState(int idState) {
        this.idState = idState;
    }


}
