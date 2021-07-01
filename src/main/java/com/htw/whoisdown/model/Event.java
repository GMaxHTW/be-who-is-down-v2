package com.htw.whoisdown.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.htw.whoisdown.user.UserApp;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", length = 50)
    private String title;

    @Column(name = "description", length = 600)
    private String description;

    @Column(name = "participantNumb")
    private int participantNumb;

    @Column(name = "location", length = 255)
    private String location;

    @Column(name = "coordinates", length = 100)
    private String coordinates;

    @Column(name = "private")
    private boolean privateEvent = false;

    @Column(name = "timeStamp")
    private long timeStamp;

    @Column(name = "eventCategory")
    private EventCategory eventCategory;

    @Column(name = "password")
    private String password;


    @JsonIgnore
    @ManyToOne
    private UserApp hostId;


    @ManyToMany
    @JoinTable(
            name = "participant_list",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "user_app_id")
    )
    private Set <UserApp> guestList = new HashSet<>();



    public Event(String title, String description, int maxNumGuests, String location, String coordinates, boolean privateEvent, Long timeStamp, EventCategory eventCategory, String password, UserApp hostId) {
        this.title = title;
        this.description = description;
        this.participantNumb = maxNumGuests;
        this.location = location;
        this.coordinates = coordinates;
        this.privateEvent = privateEvent;
        this.timeStamp = timeStamp;
        this.eventCategory = eventCategory;
        this.password = password;
        this.hostId = hostId;
    }







    public Event() {
    }

    public void enrollUser(UserApp userApp){
        guestList.add(userApp);
    }

    public Long getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public EventCategory getEventCategory() {
        return eventCategory;
    }

    public void setEventCategory(EventCategory eventCategory) {
        this.eventCategory = eventCategory;
    }

    public void setId(Long eventId) {
        this.id = eventId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getParticipantNumb() {
        return participantNumb;
    }

    public void setParticipantNumb(int maxNumGuests) {
        this.participantNumb = maxNumGuests;
    }

    public boolean isPrivateEvent() {
        return privateEvent;
    }

    public void setPrivateEvent(boolean privateEvent) {
        this.privateEvent = privateEvent;
    }

    public UserApp getHostId() {
        return hostId;
    }

    public void setHostId(UserApp hostId) {
        this.hostId = hostId;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Set<UserApp> getGuestList() {
        return guestList;
    }

    public void setGuestList(Set<UserApp> guestList) {
        this.guestList = guestList;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.id,
                this.title,
                this.description,
                this.participantNumb,
                this.location,
                this.privateEvent,
                this.timeStamp,
                this.hostId
        );
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventId=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", maxNumGuests=" + participantNumb +
                ", Location='" + location + '\'' +
                ", PrivateEvent='" + privateEvent + '\'' +
                ", Timestamp='" + timeStamp + '\'' +
                ", Organiser='" + hostId +
                '}';
    }
}
