package com;

import com.dima.Graph.Graph;
import com.dima.WeightedGraph;

public class Main_Graphs {
    public static void main(String[] args) {
//        var graph = new Graph();
//        graph.addNode("A");
//        graph.addNode("B");
//        graph.addNode("C");
//        graph.addNode("D");
//        graph.addEdge("A","B");
//        graph.addEdge("B","D");
//        graph.addEdge("D","C");
//        graph.addEdge("A","C");
//
////        graph.traverseByIteration("R");
//        graph.traverseBreadthFirst("S");

        var graph = new WeightedGraph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addEdge("A","B", 3);
        graph.addEdge("A","C", 2);
        graph.print();
    }
}
