package com.example.demo.station;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class stationservice {
    private final stationrepo stationrepo;
    @Autowired
    public stationservice(com.example.demo.station.stationrepo stationrepo) {
        this.stationrepo = stationrepo;
    }

    public List<station> getallstations()
    {
        return  stationrepo.findAll();
    }


    public String addstation(station s) {
        stationrepo.save(s);
        return "station added successfully";
    }

    public Optional<station> getstationbyId(int id) {
      return stationrepo.findById(id);
    }

    public Optional<station> getstationbyname(String name) {
        return  stationrepo.searchbyname(name);
    }

    public String deletestationByid(int id)
    {
        stationrepo.deleteById(id);
        return  "Station with id : "+ id+ " deleted successfully";
    }
}
