package com.example.box;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayDeque;
import java.util.Deque;

public class EventProcessor {
    private final Deque<Event> events = new ArrayDeque<>();
    private final Duration windowDuration = Duration.ofSeconds(60);

    private int calculateChecksum(String payload) {
        return payload.chars().sum() % 10;
    }

    public String processEvent(int identifier, long timestamp, String payload, int checksum) {
        Instant eventTime = Instant.ofEpochSecond(timestamp);

        while (!events.isEmpty() && events.getFirst().timestamp.isBefore(eventTime.minus(windowDuration))) {
            events.pollFirst();
        }

        int calculatedChecksum = calculateChecksum(payload);
        if (calculatedChecksum != checksum) {
            return "Event " + identifier + ": Invalid checksum";
        }

        events.addLast(new Event(identifier, eventTime, payload, checksum));

        double average = events.stream()
                .mapToInt(e -> e.payload.length())
                .average()
                .orElse(0.0);

        return String.format("Event %d: average %.2f, window ends %d", identifier, average, eventTime.getEpochSecond());
    }
}
