package com.htw.whoisdown.model;

import com.htw.whoisdown.user.UserApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService implements IEventService {

    @Autowired
    private EventRepo eventRepo;



    public Event saveEvent(EventRequest eventRequest, UserApp user){
        return createdEvent(
                new Event(
                        eventRequest.getTitle(),
                        eventRequest.getDescription(),
                        eventRequest.getParticipantNumb(),
                        eventRequest.getLocation(),
                        eventRequest.getCoordinates(),
                        eventRequest.isPrivateEvent(),
                        eventRequest.getTimeStamp(),
                        eventRequest.getEventCategory(),
                        eventRequest.getPassword(),
                        user
                )
        );
    }

    public  Event createdEvent(Event event){
        eventRepo.save(event);
        return event;
    }

    public List<Event> all(){
        return eventRepo.findAll();
    }

    public Event save(Event event){
        return eventRepo.save(event);
    }

    public Event findEventById(Long id){
        return eventRepo.findById(id)
                .orElseThrow(() -> new EventNotFoundException(id));
    }

    public List<Event> findByUserId(Long id){
        return eventRepo.findByUserId(id);
    }

    public EventQuery updateEvent(Long id, EventRequest eventRequest){
        if(eventRepo.findById(id).isPresent()){
            Event existingEvent = eventRepo.findById(id).get();

            existingEvent.setTitle(eventRequest.getTitle());
            existingEvent.setDescription(eventRequest.getDescription());
            existingEvent.setParticipantNumb(eventRequest.getParticipantNumb());
            existingEvent.setLocation(eventRequest.getLocation());
            existingEvent.setCoordinates(eventRequest.getCoordinates());
            existingEvent.setPrivateEvent(eventRequest.isPrivateEvent());
            //existingEvent.setTimeStamp(eventRequest.getTimeStamp());

            Event updateEvent = eventRepo.save(existingEvent);

            return new EventQuery(
                    updateEvent.getId(),
                    updateEvent.getTitle(),
                    updateEvent.getEventCategory(),
                    updateEvent.getDescription(),
                    updateEvent.getParticipantNumb(),
                    updateEvent.getLocation(),
                    updateEvent.getCoordinates(),
                    updateEvent.isPrivateEvent());
            //updateEvent.getTimeStamp());
        }
        else{
            return null;
        }
    }

    public List<Event> findEventsByLocation(String location){
        return eventRepo.findEventByLocation(location);
    }



}
