package com.github.karmazyn.algo.graphs.model;

import java.util.*;

/**
 * Created by m.karmazyn on 11/02/15.
 */
public class Graph {

    Map<Integer, Node> nodes = new HashMap<>();

    public Collection<Node> getNodes() {
        return nodes.values();
    }

    public Graph addNode(Node n) {
        nodes.put(n.getLabel(), n);
        return this;
    }

    public void revert() {
        Map<Integer, List<Integer>> newNeighbours = new HashMap<>();
        nodes.values().forEach(node -> {
            newNeighbours.putIfAbsent(node.label, new ArrayList<>());
            node.neighbours.forEach(neighbour -> {
                newNeighbours.putIfAbsent(neighbour, new ArrayList<>());
                newNeighbours.get(neighbour).add(node.label);
            });
        });
        nodes.values().forEach(node -> {
            List<Integer> nodes1 = newNeighbours.get(node.label);
            node.neighbours = nodes1;
            newNeighbours.remove(nodes1);
            nodes1 = null;
        });
        newNeighbours.clear();
    }

    @Override
    public String toString() {
        return "Graph{" +
                "nodes=" + nodes +
                '}';
    }

    public void paintWhite() {
        nodes.values().parallelStream().forEach(node -> node.color = Color.WHITE);
    }

    public void addNodes(Node... nodes) {
        for (Node node : nodes) {
            this.nodes.put(node.getLabel(),node);
        }
    }

    public Node getNode(Integer next) {
        return nodes.get(next);
    }

    public static enum Color {WHITE, GRAY, BLACK}


    public static class Node {
        int label;
        int leader;
        int time = -1;

        Color color = Color.WHITE;

        List<Integer> neighbours = new ArrayList<>();

        public Node(int label) {
            this.label = label;
        }

        public Node addNeighbour(Node n) {
            neighbours.add(n.getLabel());
            return Node.this;
        }

        public Color getColor() {
            return color;
        }

        @Override
        public String toString() {
            return "Node{" + label + ":" + neighbours +
                    ",t:" + time + ",l:" + leader + ",c:" + color +
                    '}';
        }

        public int getTime() {
            return time;
        }

        public int getLeader() {
            return leader;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        public List<Integer> getNeighbours() {
            return neighbours;
        }


        public void setTime(int time) {
            this.time = time;
        }

        public void setLeader(int leader) {
            this.leader = leader;
        }

        public int getLabel() {
            return label;
        }
    }
}
