package com.github.karmazyn.algo.graphs.model;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class GraphTest {

    @Test
    public void shouldRevertGraph() throws Exception {
        Graph.Node n1 = new Graph.Node(1);
        Graph.Node n2 = new Graph.Node(2);
        Graph.Node n3 = new Graph.Node(3);
        Graph.Node n4 = new Graph.Node(4);
        n1.addNeighbour(n3).addNeighbour(n2);
        n4.addNeighbour(n1).addNeighbour(n2);
        Graph g = new Graph();
        g.addNode(n1).addNode(n2).addNode(n3).addNode(n4);
        
        //when
        g.revert();
        
        //then
        Assertions.assertThat(g.toString()).isEqualToIgnoringCase("Graph{nodes={1=Node{1:[4],t:-1,l:0,c:WHITE}, 2=Node{2:[1, 4],t:-1,l:0,c:WHITE}, 3=Node{3:[1],t:-1,l:0,c:WHITE}, 4=Node{4:[],t:-1,l:0,c:WHITE}}}");

    }
}