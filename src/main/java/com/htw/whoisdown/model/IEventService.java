package com.htw.whoisdown.model;

public interface IEventService {

    public EventQuery updateEvent(Long id, EventRequest eventRequest);
}
