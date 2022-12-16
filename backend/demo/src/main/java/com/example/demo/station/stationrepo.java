package com.example.demo.station;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Repository
public interface stationrepo extends JpaRepository<station, Integer> {


     @Query("SELECT s FROM station s WHERE s.Name = ?1")
     Optional<station> searchbyname(String name);



}
