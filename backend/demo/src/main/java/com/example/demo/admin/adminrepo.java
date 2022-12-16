package com.example.demo.admin;

import com.example.demo.station.station;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface adminrepo extends JpaRepository<admin,Integer> {
    @Query("SELECT s FROM admin s WHERE s.id = ?1")
    admin searchforadmin(int name);
    @Query("SELECT s.id FROM admin s WHERE s.id = ?1")
    int searchforid(int name);
    @Query("SELECT s.email FROM admin s WHERE s.id = ?1")
    String searchforemail(int name);
    @Query("SELECT s.password FROM admin s WHERE s.id = ?1")
    String searchforpass(int i);
}
