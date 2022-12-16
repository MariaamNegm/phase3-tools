package com.example.demo.station;

import com.example.demo.trip.trip;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "station")
public class station  {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @SequenceGenerator(name="identifier", sequenceName="ppl_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="identifier")
    @NotNull
    private int id;
  // @SequenceGenerator(name = "station_sequence",allocationSize = 1,sequenceName = "station_sequence")
    private String Name ;

    @OneToMany(mappedBy = "from_station",fetch = FetchType.LAZY)
    @JsonIgnore
    public List<trip> fromtrips = new ArrayList<trip>();

    @OneToMany(mappedBy = "to_station",fetch = FetchType.LAZY)
    @JsonIgnore
    public List<trip> totrips = new ArrayList<trip>();

    public station() {
    }

    public station(int id, String Name ) {
        this.id = id;
        this.Name=Name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }


}
