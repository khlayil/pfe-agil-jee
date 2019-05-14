package Interfaces;

import Entities.Commande;
import Entities.Station;

import javax.ejb.Remote;
import java.util.List;
@Remote

public interface ICommandeService {

    public boolean addCommande(Commande commande);
    public boolean acceptCommande(Commande commande);
    public boolean refuseCommande(Commande commande);
    public List<Commande> getAllCommande();
    public List<Commande> getCommandeByStation(Station station);
    public Commande getCommandeById(int id);
    public boolean removeCommande(int id);
    public boolean editCommande(Commande commande);


}
