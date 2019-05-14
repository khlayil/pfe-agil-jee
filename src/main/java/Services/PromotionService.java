package Services;

import Entities.Promotion;
import Interfaces.IPromotionService;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


@Stateless
@LocalBean
public class PromotionService implements IPromotionService {

    @PersistenceContext(unitName="agil_per")
    EntityManager em;


    @Override
    public boolean addPromotion(Promotion promotion) {
        System.out.println("methode addPromotion(Promotion promotion)  invoked");

        try {
            em.persist(promotion);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("some problem when adding promotion");
        }
        return false;
    }

    @Override
    public boolean removePromotion(int id) {
        System.out.println("methode removePromotion(int id) invoked");

        Promotion promotion= null;
        try {


            promotion= em.find(Promotion.class, id);
            em.remove(promotion);
            return true;
        } catch (NoResultException e) {
            System.out.println("-------no promotion with id :" + id + "------");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Promotion> getAllPromotion() {
        System.out.println("methode getAllPromotion invoked");

        TypedQuery<Promotion> query = em.createQuery("select p from Promotion p ", Promotion.class);
        List<Promotion> promotions = null;
        try {
            promotions = query.getResultList();

        } catch (NoResultException e) {
            System.out.println("-------no Promotions------");
            e.printStackTrace();
        }
        return promotions;
    }

    @Override
    public Promotion getPromotionById(int id) {
        System.out.println("methode getPromotionById(int id) invoked");

        Promotion promotion= null;
        try {


            promotion = em.find(Promotion.class, id);
        } catch (NoResultException e) {
            System.out.println("-------no promotion with id :" + id + "------");
            e.printStackTrace();
        }
        return promotion;    }


}
