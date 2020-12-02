package dev.riska.models;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AocDay {

    public List<String> getInput(String dayNr) {
        try {
            return Files.lines(Paths.get("src/main/resources/inputs/" + dayNr + ".txt")).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public void writeAnswer(String day, String answer1, String answer2) {
        System.out.printf("############### %s ###############%n", day);
        if (answer1 == null) {
            System.out.printf("[Part 1] - Answer was null%n");
        } else {
            System.out.printf("[Part 1] - Answer was %s%n", answer1);
        }

        if (answer2 == null) {
            System.out.printf("[Part 2] - Answer was null%n");
        } else {
            System.out.printf("[Part 2] - Answer was %s%n", answer2);
        }
    }
}
