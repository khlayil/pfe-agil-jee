package Services;

import Entities.Users;
import Interfaces.IAuthenticationService;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@LocalBean
public class AuthenticationService implements IAuthenticationService {
    @PersistenceContext(unitName="agil_per")
    EntityManager em;
    public AuthenticationService() {
         //em = JpaUtility.getEntityManager();
    }

    @Override
    public Users getUserByMailAndPassword(String email, String password) {
        System.out.println(email +" ------------------"+password);
        TypedQuery<Users> query=em.createQuery("select u from Users u where u.userEmail = :email and u.userPassword = :password", Users.class);
        query.setParameter("email",email);
        query.setParameter("password",password);
        Users users=null;
        try {
             users=query.getSingleResult();

        }catch (NoResultException e)
        {
            System.out.println("user with mail :"+email+" not found");
            e.printStackTrace();
        }
        return users;

    }

    @Override
    public Boolean register(Users users) {
        em.persist(users);
        return true;

    }

    @Override
    public List<Users> getAllUsers() {
        System.out.println("methode getAllUsers invoked");

        TypedQuery<Users> query = em.createQuery("select u from Users u ", Users.class);
        List<Users> users = null;
        try {
            users = query.getResultList();

        } catch (NoResultException e) {
            System.out.println("-------no users------");
            e.printStackTrace();
        }
        return users;
    }

}
