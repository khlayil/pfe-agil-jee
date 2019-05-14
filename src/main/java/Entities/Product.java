package Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Product implements Serializable {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(name = "nom")
    private String nom;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "emballage")
    private String emballage;

    @Basic
    @Column(name = "quantite")
    private int quantite;


    @Basic
    @Column(name = "img_Url")
    private String imgUrl;

    //relations
    @JsonIgnore

    @OneToOne(mappedBy = "product")
    private Promotion promotion;

    @JsonIgnore
    @OneToMany(mappedBy = "commande")
    private List<CommandeProduit> commandeProduitList;



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


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public List<CommandeProduit> getCommandeProduitList() {
        return commandeProduitList;
    }

    public void setCommandeProduitList(List<CommandeProduit> commandeProduitList) {
        this.commandeProduitList = commandeProduitList;
    }

    public String getEmballage() {
        return emballage;
    }

    public void setEmballage(String emballage) {
        this.emballage = emballage;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
