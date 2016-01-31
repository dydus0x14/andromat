package com.andromat.model;

/**
 * Created by dydus on 31/01/2016.
 */
public class Edge {
    public Node from;
    public Node to;

    public Edge() {
        this.from = null;
        this.to = null;
    }

    public Edge(Node from, Node to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        Edge edge = (Edge)obj;
        if (edge == null)
            return super.equals(obj);
        return this.hashCode() == edge.hashCode();
    }

    @Override
    public int hashCode() {
        int result =17;
        result = 37 * result + (from != null ? from.hashCode() : 0) >>> 16;
        result = 37 * result + ((to != null ? to.hashCode() : 0) >>> 32);

        return result;
    }
}
