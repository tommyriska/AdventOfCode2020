package dev.riska.days.day07;

import lombok.Data;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Data
public class Bag {
    private final String color;
    private final Map<String, Integer> contains = new HashMap<>();

    public Bag(final String code) {
        String[] split = code.split("contain");
        this.color = split[0].substring(0, split[0].indexOf("bags") - 1);
        String[] containedBags = split[1].split(",");
        parseContainedBags(containedBags);
    }

    private void parseContainedBags(final String[] containedBags) {
        Arrays.stream(containedBags)
                .forEach(bag -> {
                    bag = bag.trim();

                    if (!bag.contains("no other bags.")) {
                        int count = Integer.parseInt(bag.substring(0, 1));
                        String color = bag.substring(2, bag.indexOf("bag") - 1);
                        contains.put(color, count);
                    }
                });
    }
}
