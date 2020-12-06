package dev.riska.days;

import dev.riska.models.Aoc;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day04 extends Aoc {
    private final static String DAY = "day04";
    // Prop constants
    private final static String PROP_BYR = "byr";
    private final static String PROP_IYR = "iyr";
    private final static String PROP_EYR = "eyr";
    private final static String PROP_HGT = "hgt";
    private final static String PROP_HCL = "hcl";
    private final static String PROP_ECL = "ecl";
    private final static String PROP_PID = "pid";
    // Regex patterns
    private final static Pattern hgtPattern = Pattern.compile("^(\\d{2,3})(in|cm)$");
    private final static Pattern hclPattern = Pattern.compile("^#([a-fA-F0-9]{6})$");
    private final static Pattern eclPattern = Pattern.compile("^(amb|blu|brn|gry|grn|hzl|oth)$");
    private final static Pattern pidPattern = Pattern.compile("^(\\d{9})$");

    public void run() {
        String answer1 = part1();
        String answer2 = part2();
        writeAnswer(DAY, answer1, answer2);
    }

    private String part1() {
        return String.valueOf(Arrays.stream(prepareInput(getInput(DAY)))
                .filter(this::validateProperties)
                .count());
    }

    // Cleans input so that each line equals one passport
    private String[] prepareInput(List<String> input) {
        StringBuilder sb = new StringBuilder();
        for (String s : input) {
            if (StringUtils.isBlank(s)) {
                sb.append(",");
            } else {
                sb.append(String.format(" %s", s));
            }
        }
        return sb.toString().split(",");
    }

    private boolean validateProperties(String passport) {
        return StringUtils.contains(passport, PROP_BYR) &&
                StringUtils.contains(passport, PROP_IYR) &&
                StringUtils.contains(passport, PROP_EYR) &&
                StringUtils.contains(passport, PROP_HGT) &&
                StringUtils.contains(passport, PROP_HCL) &&
                StringUtils.contains(passport, PROP_ECL) &&
                StringUtils.contains(passport, PROP_PID);
    }

    private String part2() {
        return String.valueOf(Arrays.stream(prepareInput(getInput(DAY)))
                .filter(this::validateProperties)
                .filter(this::validateData)
                .count());
    }

    private boolean validateData(String passport) {
        String trimmed = passport.trim();
        String[] props = trimmed.split(" ");
        Map<String, String> propmap = new HashMap<>();
        for (String prop : props) {
            String key = prop.split(":")[0];
            String value = prop.split(":")[1];
            propmap.put(key, value);
        }
        boolean byr = verifyByr(propmap);
        boolean iyr = verifyIyr(propmap);
        boolean eyr = verifyEyr(propmap);
        boolean hgt = verifyHgt(propmap);
        boolean hcl = verifyHcl(propmap);
        boolean ecl = verifyEcl(propmap);
        boolean pid = verifyPid(propmap);
        return byr && iyr && eyr && hgt && hcl && ecl && pid;
    }

    private boolean verifyByr(Map<String, String> props) {
        String byr = props.get(PROP_BYR);
        int length = byr.length();
        int year = Integer.parseInt(byr);
        return length == 4 && checkYear(year, 1920, 2002);
    }

    private boolean checkYear(int year, int min, int max) {
        return year >= min && year <= max;
    }

    private boolean verifyIyr(Map<String, String> props) {
        String iyr = props.get(PROP_IYR);
        int length = iyr.length();
        int year = Integer.parseInt(iyr);
        return length == 4 && checkYear(year, 2010, 2020);
    }

    private boolean verifyEyr(Map<String, String> props) {
        String eyr = props.get(PROP_EYR);
        int length = eyr.length();
        int year = Integer.parseInt(eyr);
        return length == 4 && checkYear(year, 2020, 2030);
    }

    private boolean verifyHgt(Map<String, String> props) {
        String hgt = props.get(PROP_HGT);
        Matcher m = hgtPattern.matcher(hgt);
        if (m.find()) {
            int height = Integer.parseInt(m.group(1));
            String type = m.group(2);
            if (StringUtils.equals(type, "cm")) {
                return height >= 150 && height <= 193;
            } else if (StringUtils.equals(type, "in")) {
                return height >= 59 && height <= 76;
            }
        }
        return false;
    }

    private boolean verifyHcl(Map<String, String> props) {
        String hcl = props.get(PROP_HCL);
        Matcher m = hclPattern.matcher(hcl);
        return m.find();
    }

    private boolean verifyEcl(Map<String, String> props) {
        String ecl = props.get(PROP_ECL);
        Matcher m = eclPattern.matcher(ecl);
        return m.find();
    }

    private boolean verifyPid(Map<String, String> props) {
        String pid = props.get(PROP_PID);
        Matcher m = pidPattern.matcher(pid);
        return m.find();
    }


}
