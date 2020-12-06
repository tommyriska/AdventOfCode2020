package dev.riska.days;

import dev.riska.model.BoardingPass;
import dev.riska.models.Aoc;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.function.Predicate.not;

public class Day05 extends Aoc {
    private final static String DAY = "day05";

    public void run() {
        String answer1 = part1();
        String answer2 = part2();
        writeAnswer(DAY, answer1, answer2);
    }

    private String part1() {
        int answer = getInput(DAY).stream()
                .map(BoardingPass::new)
                .map(BoardingPass::getSeatId)
                .mapToInt(value -> value)
                .max()
                .getAsInt();

        return String.valueOf(answer);
    }

    private String part2() {
        List<Integer> seatIds = getInput(DAY).stream()
                .map(BoardingPass::new)
                .map(BoardingPass::getSeatId)
                .sorted()
                .collect(Collectors.toList());

        Integer seatId = IntStream
                .range(getMinId(seatIds), getMaxId(seatIds))
                .boxed()
                .filter(not(seatIds::contains))
                .findAny()
                .orElseThrow();

        return String.valueOf(seatId);
    }

    private int getMinId(List<Integer> seatIds) {
        return seatIds.stream().mapToInt(v -> v).min().getAsInt();
    }

    private int getMaxId(List<Integer> seatIds) {
        return seatIds.stream().mapToInt(v -> v).max().getAsInt();
    }
}
