package com.github.karmazyn.algo.graphs.io;

import com.github.karmazyn.algo.graphs.model.Graph;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class GraphLoaderTest {

    @Test
    public void shouldLoadSmallGraph() throws Exception {
        GraphLoader loader = new GraphLoader(this.getClass().getClassLoader().getResourceAsStream("smallgraph.txt"));
        Graph graph = loader.readGraph();
        Assertions.assertThat(graph.getNodes()).hasSize(5);
        Assertions.assertThat(graph.getNode("2").getNeighbours()).hasSize(3);
        Assertions.assertThat(graph.getNode("3").getNeighbours()).hasSize(3);

    }
}