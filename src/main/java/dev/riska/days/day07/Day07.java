package dev.riska.days.day07;

import dev.riska.models.Aoc;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Day07 extends Aoc {

    private static final String DAY = "day07";
    private static final String SEARCHED_COLOR = "shiny gold";
    private static final Pattern colorPattern = Pattern.compile("^([^\\s]+\\s+[^\\s]+)");
    private static final Pattern rulePattern = Pattern.compile("(?<amount>\\d\\s)(?<color>\\D*)( bags)");

    public void run() {
        List<String> input = getInput(DAY);




        String answer1 = part1();
        String answer2 = part2();
        writeAnswer(DAY, answer1, answer2);
    }

    private String part1(List<String> input) {
        List<Bag> bags = input.stream().map(Bag::new).collect(Collectors.toList());
        Map<String, Set<String>> bagWithTheirParentBags =

        return "";
    }

    private Map<String, Bag> createColorBagMapping =

    private String part2() {
        return "";
    }
}
