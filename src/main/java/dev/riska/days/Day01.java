package dev.riska.days;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Day01 {

    public void run() {
        part1();
        part2();
    }

    private void part1() {
        try {
            List<String> lines = Files.lines(Paths.get("src/main/resources/inputs/day01.txt")).collect(Collectors.toList());
            Integer answer = null;
            for (String i : lines) {
                for (String j : lines) {
                    int sum = Integer.sum(Integer.parseInt(i), Integer.parseInt(j));
                    if (sum == 2020) {
                        answer = Integer.parseInt(i) * Integer.parseInt(j);
                    }
                }
            }
            if (answer == null) {
                System.out.println("Did not find any numbers");
            } else {
                System.out.println("[Part 1] - Answer is: " + answer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void part2() {
        try {
            List<String> lines = Files.lines(Paths.get("src/main/resources/inputs/day01.txt")).collect(Collectors.toList());
            Integer answer = null;
            for (String i : lines) {
                for (String j : lines) {
                    for (String k : lines) {
                        int sum = Integer.parseInt(i) + Integer.parseInt(j) + Integer.parseInt(k);
                        if (sum == 2020) {
                            answer = Integer.parseInt(i) * Integer.parseInt(j) * Integer.parseInt(k);
                        }
                    }
                }
            }

            if (answer == null) {
                System.out.println("Did not find any numbers");
            } else {
                System.out.println("[Part 2] - Answer is: " + answer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
