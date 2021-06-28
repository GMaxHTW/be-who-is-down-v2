package com.htw.whoisdown.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepo extends JpaRepository<Event,Long> {

    //Findet man liste ?
    @Query(
            value = "SELECT * FROM Event WHERE location = ?1",
            nativeQuery = true
    )
    List<Event> findEventByLocation(String location);

    @Query(
            value = "SELECT * FROM Event WHERE host_id_id = ?1",
            nativeQuery = true
    )
    List<Event> findByUserId(Long id);

//    @Query("SELECT c From Event c where c.id = ?1 and c.privateEvent = ?2")
//    List<Event> findPrivateEvent(double id, boolean status);


//    @Query("SELECT c From Event c where c.id = ?1 and c.categories = ?2")
//    List<Event> findEventByCategory(double id, String category);




}
