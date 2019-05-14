package Entities;


import javax.persistence.*;
import java.io.Serializable;

@Entity

public class Station implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Basic
    @Column(name = "nom")
    private String nom;

    @Basic
    @Column(name = "adresse")
    private String adresse;
    @OneToOne
    private Users gerant;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Users getGerant() {
        return gerant;
    }

    public void setGerant(Users gerant) {
        this.gerant = gerant;
    }
}
