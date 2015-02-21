package com.github.karmazyn.algo.graphs;

import com.github.karmazyn.algo.graphs.model.Graph;

import java.util.Iterator;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

/**
 * Created by m.karmazyn on 12/02/15.
 */
public class MinCut {
    private Random rand = new Random(System.currentTimeMillis());

    public int minCut(Graph g) {
        while (g.getNodes().size() > 2) {
            Graph.Node n = getRandomNode(g);
            Graph.Node dinner = getNeighbour(n);
            if (dinner != null) {
                eat(g, n, dinner);
            }
        }
        return crossings(g);
    }

    private int crossings(Graph g) {
        return g.getRoot().getNeighbours().size();
    }

    private void eat(Graph g, Graph.Node n, Graph.Node dinner) {
        Iterator<Graph.Node> iterator = n.getNeighbours().iterator();
        while (iterator.hasNext()) {
            Graph.Node next = iterator.next();
            if(next == dinner) {
                iterator.remove();
            }
        }
        n.getNeighbours().remove(dinner);
        dinner.getNeighbours().forEach(new Consumer<Graph.Node>() {
            @Override
            public void accept(Graph.Node node) {
                if (!node.getLabel().equals(n.getLabel())) {
                    n.addNeighbour(node);
                }
            }
        });
        dinner.getNeighbours().forEach(new Consumer<Graph.Node>() {
            @Override
            public void accept(Graph.Node node) {
                node.getNeighbours().replaceAll(new UnaryOperator<Graph.Node>() {
                    @Override
                    public Graph.Node apply(Graph.Node node) {
                        if (node == dinner) {
                            return n;
                        }
                        return node;
                    }

                });
            }
        });
        g.getNodes().remove(dinner);
    }

    private Graph.Node getNeighbour(Graph.Node n) {
        return n.getNeighbours().isEmpty() ? null : n.getNeighbours().get(0);
    }

    private Graph.Node getRandomNode(Graph g) {
        return g.getNodes().get(rand.nextInt(g.getNodes().size()));
    }
}
