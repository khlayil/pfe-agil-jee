package Interfaces;

import Entities.Users;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface IAuthenticationService {

    public Users getUserByMailAndPassword(String email, String password);
    public Boolean register(Users users);
    public List<Users> getAllUsers() ;



}
