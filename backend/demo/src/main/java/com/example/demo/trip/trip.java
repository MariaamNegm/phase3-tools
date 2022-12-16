package com.example.demo.trip;



import com.example.demo.station.station;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Table(name = "trip")
public class trip {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idtrip;
    private String start_time;
    private String end_time;

    private int fromid;

    private int toid;

    public int getToid() {
        return toid;
    }

    public void setToid(int toid) {
        this.toid = toid;
    }

    public int getFromid() {
        return fromid;
    }

    public void setFromid(int fromid) {
        this.fromid = fromid;
    }

    private String tripName ;




    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }


    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }




    @ManyToOne
    @JoinColumn(name = "from_station")
    private station from_station;
    @ManyToOne
    @JoinColumn(name = "to_station")
    private station to_station;

    public station getTo_station() {
        return to_station;
    }

    public void setTo_station(station to_station) {
        this.to_station = to_station;
    }

    public station getFrom_station() {
        return from_station;
    }

    public void setFrom_station(station from_station) {
        this.from_station = from_station;
    }







    public trip() {
    }

    public trip(int id, String Name,String start_time,String end_time ,station from_station,station to_station) {
        this.idtrip = id;
        this.tripName=Name;
        this.start_time=start_time;
        this.end_time=end_time;
        this.from_station=from_station;
        this.to_station=to_station;

    }

    public int getId() {
        return idtrip;
    }

    public void setId(int id) {
        this.idtrip = id;
    }

    public String getName() {
        return tripName;
    }

    public void setName(String name) {
        tripName = name;
    }


}
