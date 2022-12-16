package com.example.demo.trip;

import com.example.demo.station.station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class tripservice {
    @PersistenceContext
    private EntityManager em;
    private final triprepo triprepo;
    @Autowired
    public tripservice(com.example.demo.trip.triprepo triprepo) {
        this.triprepo = triprepo;
    }


    public List<trip> getalltrips()
    {
        return  triprepo.findAll();
    }


    public String addtrip(trip s) {
         s.setFrom_station(triprepo.searchfrostation(s.getFromid()));
         s.setTo_station(triprepo.searchfrostation(s.getToid()));
        //System.out.println("hi from station"+s.getFrom_station().getName());
        triprepo.save(s);
        return "Trip added successfully";
        }



    public Optional<trip> gettripbyId(int id) {
        return triprepo.findById(id);
    }



    public String deletetripByid(int id)
    {
        triprepo.deleteById(id);
        return  "Trip with id : "+ id+ " deleted successfully";
    }
    @Transactional
    public String updatetripByid(int id,trip t2)
    {
        trip t = triprepo.searchbyid(id);
        if(t2.getName()!= null && !Objects.equals(t.getName(),t2.getName()))
        {
         t.setName(t2.getName());
        }
        if( t2.getStart_time() != null && !Objects.equals(t.getStart_time(),t2.getStart_time()))
        {
            t.setStart_time(t2.getStart_time());
        }
        if(t2.getEnd_time() != null && !Objects.equals(t.getEnd_time(),t2.getEnd_time()))
        {
            t.setEnd_time(t2.getEnd_time());
        }
        if(t2.getFromid() != 0 && !Objects.equals(t.getFrom_station(),t2.getFromid()))
        {
             t.setFromid(t2.getFromid());
            t.setFrom_station(triprepo.searchfrostation(t2.getFromid()));

        }
        if( t2.getToid() != 0 && !Objects.equals(t.getTo_station(),t2.getToid()))
        {
             t.setToid(t2.getToid());
             t.setTo_station(triprepo.searchfrostation(t2.getToid()));
        }

        return  "Trip with id : "+ id+ " updated successfully";
    }


}

