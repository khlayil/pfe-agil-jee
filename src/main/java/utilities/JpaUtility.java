package utilities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtility {
    private static final EntityManagerFactory emFactory;
    static {
        emFactory = Persistence.createEntityManagerFactory("Okm_per");
    }
    public static EntityManager getEntityManager(){
        return emFactory.createEntityManager();
    }
    public static void close(){
        emFactory.close();
    }
}