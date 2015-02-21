package com.github.karmazyn.algo.graphs.io;

import com.github.karmazyn.algo.graphs.model.Graph;
import com.google.common.base.Splitter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by m.karmazyn on 26/01/15.
 */
public class GraphLoader {
    private final InputStream stream;
    private final Map<Integer, Graph.Node> nodes = new HashMap<>();

    public GraphLoader(InputStream stream) {
        this.stream = stream;
    }

    public Graph readGraph() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {
            String line;
            Graph graph = new Graph();
            while ((line = reader.readLine()) != null) {
                Graph.Node n = createNode(line);
                graph.addNode(n);
            }
            return graph;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Graph.Node createNode(String line) {
        Iterator<Integer> numbers =
                Splitter.on(Pattern.compile("\\s"))
                        .splitToList(line)
                        .stream()
                        .filter(s-> !s.isEmpty())
                        .mapToInt(Integer::parseInt)
                        .boxed()
                        .iterator();
        int rootLabel = numbers.next();
        Graph.Node root = getNode(rootLabel);

        numbers.forEachRemaining(label -> {
            if (label != rootLabel) root.addNeighbour(getNode(label));
        });
        return root;
    }

    private Graph.Node getNode(int label) {
        if (!nodes.containsKey(label)) {
            Graph.Node node = new Graph.Node(label);
            nodes.put(label, node);
            return node;
        }
        return nodes.get(label);
    }
}
