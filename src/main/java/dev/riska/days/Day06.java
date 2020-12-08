package dev.riska.days;

import dev.riska.models.Aoc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Day06 extends Aoc {

    private final static String DAY = "day06";

    public void run() {
        String answer1 = part1();
        String answer2 = part2();
        writeAnswer(DAY, answer1, answer2);
    }

    private String part1() {
        List<String> groupedInput = combineGroupAnswers(getInput(DAY));
        int totalYesAnswersPerGroup = 0;
        for (String s : groupedInput) {
            Set<String> distAnsw = s.chars().mapToObj(Character::toString).collect(Collectors.toSet());
            int totalAnswers = distAnsw.size();
            totalYesAnswersPerGroup += totalAnswers;
        }
        return String.valueOf(totalYesAnswersPerGroup);
    }

    private List<String> combineGroupAnswers(List<String> input) {
        StringBuilder sb = new StringBuilder();
        for (String s : input) {
            if (!s.isBlank()) {
                sb.append(s);
            } else {
                sb.append(",");
            }
        }
        return Arrays.asList(sb.toString().split(","));
    }

    private String part2() {
        List<String> groupAnswers = getInputBySplit(DAY, "\n\n");
        int total = 0;
        for (String group : groupAnswers) {
            final String[] persons = group.split("[^a-z]");
            group = String.join("", persons);
            final HashMap<Character, Integer> map = new HashMap<>();
            for (char c : group.toCharArray()) {
                map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
            }

            for (int count : map.values()) {
                total += count == persons.length ? 1 : 0;
            }
        }
        return String.valueOf(total);
    }
}
