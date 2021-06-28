package com.htw.whoisdown.model;

public class EventNotFoundException extends RuntimeException {

    EventNotFoundException(Long id) {
        super("Could not find event " + id);
    }
}
