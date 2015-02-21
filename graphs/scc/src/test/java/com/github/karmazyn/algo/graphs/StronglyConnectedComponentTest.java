package com.github.karmazyn.algo.graphs;

import com.github.karmazyn.algo.graphs.io.GraphLoader;
import com.github.karmazyn.algo.graphs.model.Graph;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.List;

public class StronglyConnectedComponentTest {

    @Test
    public void shouldFindThreeScc() throws Exception {
        Graph g = new Graph();
        Graph.Node n1 = new Graph.Node(1);
        Graph.Node n2 = new Graph.Node(2);
        Graph.Node n3 = new Graph.Node(3);
        Graph.Node n4 = new Graph.Node(4);
        Graph.Node n5 = new Graph.Node(5);
        Graph.Node n6 = new Graph.Node(6);
        Graph.Node n7 = new Graph.Node(7);
        n1.addNeighbour(n3);
        n2.addNeighbour(n1);
        n3.addNeighbour(n2);
        n4.addNeighbour(n3).addNeighbour(n6);
        n5.addNeighbour(n4);
        n6.addNeighbour(n5).addNeighbour(n7);
        g.addNodes(n1,n2,n3,n4,n5,n6,n7);
        
        StronglyConnectedComponent scc = new StronglyConnectedComponent();
        
        //when
        List<Integer> sccs = scc.sccs(g);

        Assertions.assertThat(sccs).hasSize(3)
        .containsSequence(3,3,1);

    }

    @Test
    public void shouldFindSccInBigGraph() throws Exception {
        GraphLoader graphLoader = new GraphLoader(this.getClass().getClassLoader().getResourceAsStream("SCC.txt"));
        Graph graph = graphLoader.readGraph();
        
        StronglyConnectedComponent stronglyConnectedComponent = new StronglyConnectedComponent();
        List<Integer> sccs = stronglyConnectedComponent.sccs(graph);
        
        Assertions.assertThat(sccs).hasSize(5).containsSequence(434821,968,459,313,211);

    }
}