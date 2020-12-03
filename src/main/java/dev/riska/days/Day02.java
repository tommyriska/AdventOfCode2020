package dev.riska.days;

import dev.riska.models.Aoc;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day02 extends Aoc {
    private final static String DAY = "day02";
    private final static Pattern pattern = Pattern.compile("(\\d{1,2})-(\\d{1,2}) (\\w): (\\w+)");

    public void run() {
        String answer1 = part1();
        String answer2 = part2();
        writeAnswer(DAY, answer1, answer2);
    }

    private String part1() {
        List<String> lines = getInput(DAY);
        long validPasswords = lines.stream()
                .filter(Day02::checkPasswordPolicyPart1)
                .count();
        return String.valueOf(validPasswords);
    }

    private static boolean checkPasswordPolicyPart1(String input) {
        Matcher m = pattern.matcher(input);
        if (m.find()) {
            int min = Integer.parseInt(m.group(1));
            int max = Integer.parseInt(m.group(2));
            char letter = m.group(3).charAt(0);
            String password = m.group(4);
            long occurrences = password.chars().filter(ch -> ch == letter).count();
            return occurrences >= min && occurrences <= max;
        }
        return false;
    }

    private String part2() {
        List<String> lines = getInput(DAY);
        long validPasswords = lines.stream()
                .filter(Day02::checkPasswordPolicyPart2)
                .count();
        return String.valueOf(validPasswords);
    }

    private static boolean checkPasswordPolicyPart2(String input) {
        Matcher m = pattern.matcher(input);
        if (m.find()) {
            int pos1 = Integer.parseInt(m.group(1));
            int pos2 = Integer.parseInt(m.group(2));
            char letter = m.group(3).charAt(0);
            String password = m.group(4);
            boolean pos1Check = password.charAt(pos1 - 1) == letter;
            boolean pos2Check = password.charAt(pos2 - 1) == letter;
            return (pos1Check && !pos2Check) || (!pos1Check && pos2Check);
        }
        return false;
    }
}
