package Services;



import Entities.Actualite;
import Interfaces.IActualiteService;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;



@Stateless
@LocalBean
public class ActualiteService implements IActualiteService {
    @PersistenceContext(unitName = "agil_per")

    EntityManager em;

    public ActualiteService() {
        //em = JpaUtility.getEntityManager();
    }

    @Override
    public List<Actualite> getAllActu() {


        System.out.println("methode getAllActu invoked");

        TypedQuery<Actualite> query = em.createQuery("select a from Actualite a ", Actualite.class);
        List<Actualite> actualites = null;
        try {
            actualites = query.getResultList();

        } catch (NoResultException e) {
            System.out.println("-------no actus------");
            e.printStackTrace();
        }
        return actualites;
    }
}
