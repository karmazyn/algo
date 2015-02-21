package com.github.karmazyn.algo.graphs.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by m.karmazyn on 11/02/15.
 */
public class Graph {

    List<Node> nodes = new ArrayList<>();

    public List<Node> getNodes() {
        return nodes;
    }
    
    public Node getNode(String label) {
        for (Node node : nodes) {
            if(node.label.equals(label)) return node;
        }
        return null;
    }

    public Graph addNode(Node n) {
        nodes.add(n);
        return this;
    }

    public Node getRoot() {
        if (nodes.isEmpty()) return null;
        return nodes.get(0);
    }

    public static class Node {
        String label;
        boolean visited = false;
        List<Node> neighbours = new ArrayList<>();

        public Node(String label) {
            this.label = label;
        }

        public Node addNeighbour(Node n) {
            neighbours.add(n);
            return Node.this;
        }

        public List<Node> getNeighbours() {
            return neighbours;
        }

        public String getLabel() {
            return label;
        }
    }
}
