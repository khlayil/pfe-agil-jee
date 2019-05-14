package Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Users implements Serializable {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    @Basic
    @Column(name = "user_full_name")
    private String userFullName;
    @Basic
    @Column(name = "user_password")
    private String userPassword;
    @Basic
    @Column(name = "user_email")
    private String userEmail;
    @Basic
    @Column(name = "role")
    private String role;

    //relation

    @OneToOne(mappedBy = "gerant")
    private Station station;



    @JsonIgnore
    @OneToMany(mappedBy = "gerant")
    private List<Commande> commandes;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }


    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }


    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }


    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return userId == users.userId &&
                Objects.equals(userFullName, users.userFullName) &&
                Objects.equals(userPassword, users.userPassword) &&
                Objects.equals(userEmail, users.userEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userFullName, userPassword, userEmail);
    }
}
