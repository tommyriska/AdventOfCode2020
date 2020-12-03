package dev.riska.days;

import dev.riska.models.Aoc;

import java.util.ArrayList;
import java.util.List;

public class Day03 extends Aoc {
    private final static String DAY = "day03";

    public void run() {
        String answer1 = part1();
        String answer2 = part2();
        writeAnswer(DAY, answer1, answer2);
    }

    private String part1() {
        return String.valueOf(traverseSlope(1, 3, getInput(DAY)));
    }

    public long traverseSlope(int downMove, int rightMove, List<String> input) {
        long trees = 0;
        int rightPos = 0;
        for (int row = downMove; row < input.size(); row += downMove) {
            rightPos = (rightPos + rightMove) % input.get(row).length();
            if (input.get(row).charAt(rightPos) == '#') trees++;
        }
        return trees;
    }

    private String part2() {
        List<String> input = getInput(DAY);
        long slope1 = traverseSlope(1, 1, input);
        long slope2 = traverseSlope(1, 3, input);
        long slope3 = traverseSlope(1, 5, input);
        long slope4 = traverseSlope(1, 7, input);
        long slope5 = traverseSlope(2, 1, input);
        return String.valueOf(slope1 * slope2 * slope3 * slope4 * slope5);
    }
}
