package com.example.box;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventProcessTest {
    @Test
    public void testEventProcessing() {
        EventProcessor processor = new EventProcessor();

        // Example Input
        String input = "Identifier,Event ts (seconds),Payload,Checksum\n4,456,Box,7\n5,466,AAA,1\n6,506,xyz,3";
        String[] lines = input.split("\n");

        List<String> expectedOutput = Arrays.asList(
                "Event 4: average 3.00, window ends 456",
                "Event 5: Invalid checksum",
                "Event 6: average 3.00, window ends 506"
        );

        List<String> actualOutput = new ArrayList<>();
        for (int i = 1; i < lines.length; i++) {
            String[] parts = lines[i].split(",");
            int identifier = Integer.parseInt(parts[0]);
            long timestamp = Long.parseLong(parts[1]);
            String payload = parts[2];
            int checksum = Integer.parseInt(parts[3]);

            String result = processor.processEvent(identifier, timestamp, payload, checksum);
            actualOutput.add(result);
        }

        assertEquals(expectedOutput, actualOutput);
    }
}
