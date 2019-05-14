package Interfaces;


import Entities.Actualite;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface IActualiteService {


    List<Actualite> getAllActu();
}
