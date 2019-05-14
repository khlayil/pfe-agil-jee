package Interfaces;

import Entities.Station;

import javax.ejb.Remote;
import java.util.List;
@Remote

public interface IStationService {

    public boolean addStation(Station station);
    public boolean editStation(Station station);
    public List<Station> getAllStation();
    public Station getStationById(int id);
    public boolean removeStation(int id);
}
