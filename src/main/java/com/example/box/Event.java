package com.example.box;

import java.time.Instant;

public class Event {
    int identifier;
    Instant timestamp;
    String payload;
    int checksum;

    public Event(int identifier, Instant timestamp, String payload, int checksum) {
        this.identifier = identifier;
        this.timestamp = timestamp;
        this.payload = payload;
        this.checksum = checksum;
    }
}
