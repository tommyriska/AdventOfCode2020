package dev.riska.days;

import dev.riska.models.AocDay;

import java.util.List;

import static dev.riska.models.Part.PART_1;
import static dev.riska.models.Part.PART_2;

public class Day01 extends AocDay {
    private final static String DAY = "day01";

    public void run() {
        String answer1 = part1();
        String answer2 = part2();
        writeAnswer(DAY, answer1, answer2);
    }

    private String part1() {
        List<String> lines = getInput(DAY);
        Integer answer = null;
        for (String i : lines) {
            for (String j : lines) {
                int sum = Integer.sum(Integer.parseInt(i), Integer.parseInt(j));
                if (sum == 2020) {
                    answer = Integer.parseInt(i) * Integer.parseInt(j);
                }
            }
        }
        return String.valueOf(answer);
    }

    private String part2() {
        List<String> lines = getInput(DAY);
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
        return String.valueOf(answer);
    }
}
