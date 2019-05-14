package Interfaces;


import Entities.Promotion;

import javax.ejb.Remote;
import java.util.List;

@Remote

public interface IPromotionService {

    public boolean addPromotion(Promotion promotion);
    public boolean removePromotion(int id);
    public List<Promotion> getAllPromotion();
    public Promotion getPromotionById(int id);

}
