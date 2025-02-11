package com.example.box;

import java.util.Arrays;
import java.util.List;

public class EventMainRunner {
    public static void main(String[] args) {
        List<String> exampleInputs = Arrays.asList(
                "Identifier,Event ts (seconds),Payload,Checksum\n4,456,Box,7\n5,466,AAA,1\n6,506,xyz,3",
                "Identifier,Event ts (seconds),Payload,Checksum\n10,456,abcd,4\n11,466,abcde,5\n12,506,abcdef,7\n13,520,a,7\n14,570,abcde,5",
                "Identifier,Event ts (seconds),Payload,Checksum\n21,450,abcd,4\n22,460,abcde,5\n23,530,abcdef,7\n24,460,a,7\n25,570,abcd,4",
                "Identifier,Event ts (seconds),Payload,Checksum\n31,10,abcd,4\n32,50,abcde,5\n33,30,ab,5\n34,20,abcdef,7\n35,90,ab,5\n36,120,a,7"
        );

        for (String example : exampleInputs) {
            System.out.println("Processing new example:\n");
            EventProcessor processor = new EventProcessor();
            String[] lines = example.split("\\n");
            for (int i = 1; i < lines.length; i++) {
                String line = lines[i].trim();
                if (!line.isEmpty()) {
                    String[] parts = line.split(",");
                    int identifier = Integer.parseInt(parts[0]);
                    long timestamp = Long.parseLong(parts[1]);
                    String payload = parts[2];
                    int checksum = Integer.parseInt(parts[3]);
                    String result = processor.processEvent(identifier, timestamp, payload, checksum);
                    System.out.println(result);
                }
            }
            System.out.println();
        }
    }
}
