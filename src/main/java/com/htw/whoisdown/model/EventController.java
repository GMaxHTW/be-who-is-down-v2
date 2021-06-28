package com.htw.whoisdown.model;


import com.htw.whoisdown.security.jwt.JwtUtils;
import com.htw.whoisdown.user.UserApp;
import com.htw.whoisdown.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@Controller
@RestController
@RequestMapping("/api/v1")
public class EventController {

    @Autowired
    private EventService eventService;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserService userService;



    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }


    //Get all items
    @GetMapping("/event")
    List<Event> all() { return eventService.all(); }

    //Get one item
    @GetMapping("/event/{id}")
    Event one(@PathVariable Long id){ return eventService.findEventById(id);  }

    @GetMapping("/hosted/events/{token}")
    List<Event> hosted(@PathVariable String token){
        String userName = jwtUtils.getUserNameFromJwtToken(token);
        UserApp user = userService.findByUsername(userName);
        return eventService.findByUserId(user.getId());
    }

    /*
    @GetMapping("/event/{location}")
    List<Event> location(@PathVariable String location){
        return eventService.findEventsByLocation(location);
    }
     */

//    @GetMapping("/user")y
//    List<UserApp> allUsers(){return userRepository.findAll();}


//
//    @GetMapping("/event/loc/cat")
//    List<Event> findByCategory(double id, String category){
//        return eventService.byCategory(id, category);
//    }
//
//
//    //?? passt nicht wegen Variablen kommen die von path oder id vom user und dem sein Status
//    @GetMapping("/event/private/or/public")
//    List<Event> privateEvents(int id, Boolean status){
//        if(event.isPrivateEvent()){
//            all();
//        }
//        return eventService.isPrivate(id, status);
//    }

    //Event speichern
    @PostMapping("/create/event/")
    Event newEvent(@RequestBody EventRequest eventRequest, @RequestHeader HttpHeaders myHeader) {
        String[] token = (myHeader.getFirst(HttpHeaders.AUTHORIZATION)).split(" ");

        String userName = jwtUtils.getUserNameFromJwtToken(token[1]);
        UserApp user = userService.findByUsername(userName);
        Event event = eventService.saveEvent(eventRequest, user);
        Event x = eventService.findEventById(event.getId());
        x.enrollUser(user);
        eventService.save(x);
        return x;
    }


    //Update event ?
    @PostMapping("/update/event/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<EventQuery> updateEvent(@PathVariable Long id, @RequestBody EventRequest eventRequest ){
        return new ResponseEntity<>(eventService.updateEvent(id, eventRequest), HttpStatus.OK);
    }



    @PutMapping("/create/participant/{token}/{eventide}")
    String enrolleUserToEvent(@PathVariable String token, @PathVariable Long eventide){
        String userName = jwtUtils.getUserNameFromJwtToken(token);
        UserApp user = userService.findByUsername(userName);
        Event event = eventService.findEventById(eventide);
        event.enrollUser(user);
        eventService.save(event);
        return "Erfolgreich..";
    }



//    //Organiser erstellen und speichern
//    @PostMapping("/api/v1/create/organiser/{id}")
//    String newOrganiser(@PathVariable Long id) {
//        return userService.saveOrganiser(id);
//    }
}
