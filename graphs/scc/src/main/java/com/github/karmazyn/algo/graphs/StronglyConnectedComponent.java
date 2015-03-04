package com.github.karmazyn.algo.graphs;

import com.github.karmazyn.algo.graphs.model.Graph;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * Created by m.karmazyn on 18/02/15.
 */
public class StronglyConnectedComponent {

    public List<Integer> sccs(Graph g) {
        g.revert();

        AtomicInteger counter = new AtomicInteger(0);
        g.getNodes().forEach(node -> {
            if (node.getColor().equals(Graph.Color.WHITE)) {
                stackDfs(g, node, counter);
            }
        });

        g.paintWhite();

        g.revert();

        List<Graph.Node> nodes = sortByTime(g);

        System.gc();
        nodes.forEach(node -> {
            if (node.getColor().equals(Graph.Color.WHITE)) stackDfs(g, node, counter);
        });

        Map<Integer, List<Graph.Node>> leaders = getLeaders(g);
        List<Integer> sortedLeaders = leaders.values().stream().mapToInt(list -> list.size()).sorted().boxed().collect(Collectors.toList());
        return sortedLeaders.stream().sorted((i1, i2) -> Integer.compare(i2, i1)).limit(5).collect(Collectors.toList());
    }

    private Map<Integer, List<Graph.Node>> getLeaders(Graph g) {
        Map<Integer, List<Graph.Node>> leaders = new HashMap<>();
        g.getNodes().forEach(node -> {
            leaders.putIfAbsent(node.getLeader(), new ArrayList<>());
            leaders.get(node.getLeader()).add(node);
        });
        return leaders;
    }

    private List<Graph.Node> sortByTime(Graph g) {
        return g.getNodes().stream().sorted((n1, n2) -> Integer.compare(n2.getTime(), n1.getTime())).collect(Collectors.toList());
    }

//    private void dfs(Graph.Node node, AtomicInteger counter, int leader) {
//        node.setColor(Graph.Color.GRAY);
//        node.setLeader(leader);
//        node.getNeighbours().stream().filter(n -> n.getColor().equals(Graph.Color.WHITE)).forEach(n -> dfs(n, counter, leader));
//        node.setTime(counter.getAndIncrement());
//        node.setColor(Graph.Color.BLACK);
//    }

    private void stackDfs(Graph g, Graph.Node node, AtomicInteger counter) {
        int leader = node.getLabel();
        LinkedList<Graph.Node> stack = new LinkedList<>();
        stack.push(node);
        Map<Integer, Iterator<Integer>> adj = new HashMap<>();
        while (!stack.isEmpty()) {
            Graph.Node n = stack.peek();
            n.setLeader(leader);
            if (n.getColor().equals(Graph.Color.WHITE)) n.setColor(Graph.Color.GRAY);
            adj.putIfAbsent(n.getLabel(), n.getNeighbours().iterator());
            Iterator<Integer> nodeIterator = adj.get(n.getLabel());
            boolean inside = false;
            while (nodeIterator.hasNext()) {
                Graph.Node neighbour = g.getNode(nodeIterator.next());
                if (neighbour.getColor().equals(Graph.Color.WHITE)) {
                    stack.push(neighbour);
                    inside = true;
                    break;
                }
            }
            if (!inside) {
                stack.pop();
                n.setColor(Graph.Color.BLACK);
                n.setTime(counter.getAndIncrement());
                adj.remove(n);
            }
        }
        adj.clear();
    }

}
