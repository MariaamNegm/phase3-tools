package com.example.demo.trip;

import com.example.demo.station.station;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface triprepo extends JpaRepository<trip,Integer> {




    @Query("SELECT s FROM trip s WHERE s.idtrip = ?1")
    trip  searchbyid(int name);

    @Query("SELECT s FROM station s WHERE s.id = ?1")
    station  searchfrostation(int name);





}
