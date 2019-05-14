package Services;

import Entities.Station;
import Interfaces.IStationService;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@LocalBean
public class StationService implements IStationService {

    @PersistenceContext(unitName="agil_per")
    EntityManager em;


    @Override
    public boolean addStation(Station station) {
        System.out.println("methode addStation(Station station)  invoked");

        try {
            em.persist(station);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("some problem when adding station");
        }
        return false;
    }

    @Override
    public boolean editStation(Station station) {
        System.out.println("methode editStation(Station station)  invoked");

        try {
            em.persist(station);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("some problem when editing station");
        }
        return false;

    }

    @Override
    public List<Station> getAllStation() {

        System.out.println("methode getAllStation invoked");

        TypedQuery<Station> query = em.createQuery("select s from Station s ", Station.class);
        List<Station> stations = null;
        try {
            stations = query.getResultList();

        } catch (NoResultException e) {
            System.out.println("-------no stations------");
            e.printStackTrace();
        }
        return stations;


    }

    @Override
    public Station getStationById(int id) {
        System.out.println("methode getStationById(int id) invoked");

        Station station= null;
        try {


            station = em.find(Station.class, id);
        } catch (NoResultException e) {
            System.out.println("-------no Station with id :" + id + "------");
            e.printStackTrace();
        }
        return station;
    }

    @Override
    public boolean removeStation(int id) {
        System.out.println("methode removeStation(int id) invoked");

        Station station= null;
        try {


            station= em.find(Station.class, id);
            em.remove(station);
            return true;
        } catch (NoResultException e) {
            System.out.println("-------no station with id :" + id + "------");
            e.printStackTrace();
        }
        return false;    }
}
