package dev.riska.days.day07;

import java.util.HashMap;
import java.util.Map;

public class Graph<String, Integer> {

    private Map<String, Map<String, Integer>> edges;

    public Graph() {
        this.edges = new HashMap<>();
    }
}
