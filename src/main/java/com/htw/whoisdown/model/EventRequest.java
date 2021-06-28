package com.htw.whoisdown.model;

import java.util.Objects;

public class EventRequest {

    private String title;
    private String description;
    private int participantNumb;
    private String location;
    private String coordinates;
    private boolean privateEvent = true;
    private Long timeStamp;
    private String password;
    private EventCategory eventCategory;


    public EventRequest(){}


    public EventRequest(String title, String description, int participantNumb, String location,String coordinates, boolean privateEvent, Long timeStamp, String password, EventCategory eventCategory) {
        this.title = title;
        this.description = description;
        this.participantNumb = participantNumb;
        this.location = location;
        this.coordinates = coordinates;
        this.privateEvent = privateEvent;
        this.timeStamp = timeStamp;
        this.password = password;
        this.eventCategory = eventCategory;
    }



    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getParticipantNumb() {
        return participantNumb;
    }

    public String getLocation() {
        return location;
    }


    public String getCoordinates() { return coordinates; }

    public boolean isPrivateEvent() {
        return privateEvent;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public String getPassword() {
        return password;
    }

    public EventCategory getEventCategory() {
        return eventCategory;
    }



    @Override
    public int hashCode() {
        return Objects.hash(
                this.title,
                this.description,
                this.participantNumb,
                this.location,
                this.privateEvent,
                this.timeStamp

        );
    }

    @Override
    public String toString() {
        return "Event{" +
                ", Title='" + title +
                ", Description='" + description + '\'' +
                ", ParticipantNumb=" + participantNumb + '\'' +
                ", Location='" + location + '\'' +
                ", LongLat='" + coordinates + '\'' +
                ", PrivateEvent='" + privateEvent + '\'' +
                ", Timestamp='" + timeStamp +
                '}';
    }
}
