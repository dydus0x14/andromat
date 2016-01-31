package com.andromat.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dydus on 31/01/2016.
 */
public class Graph {
    private String name;
    private Set<Node> nodes = new HashSet<>();
    private Set<Edge> edges = new HashSet<>();

    public Graph() {

    }

    public Graph(String name) {
    this.name = name;
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    public Set<Edge> getEdges() {
        return edges;
    }

    public Set<Node> getNodes() {
        return nodes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
