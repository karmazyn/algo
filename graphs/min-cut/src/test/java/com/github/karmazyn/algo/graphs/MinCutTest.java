package com.github.karmazyn.algo.graphs;

import com.github.karmazyn.algo.graphs.io.GraphLoader;
import com.github.karmazyn.algo.graphs.model.Graph;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class MinCutTest {

    @Test
    public void shouldCountSmallGraph() throws Exception {
        GraphLoader graphLoader = new GraphLoader(this.getClass().getClassLoader().getResourceAsStream("smallgraph.txt"));
        Graph graph = graphLoader.readGraph();
        MinCut minCut = new MinCut();
        int i = minCut.minCut(graph);
        Assertions.assertThat(i).isEqualTo(2);

    }
    
    @Test
    public void shouldCountLargeGraph() throws Exception {
        GraphLoader graphLoader = new GraphLoader(this.getClass().getClassLoader().getResourceAsStream("kargerMinCut.txt"));
        Graph graph = graphLoader.readGraph();
        MinCut minCut = new MinCut();
        int i = minCut.minCut(graph);
        Assertions.assertThat(i).isEqualTo(2);

    }
}