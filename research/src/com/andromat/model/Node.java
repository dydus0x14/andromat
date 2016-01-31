package com.andromat.model;

/**
 * Created by dydus on 31/01/2016.
 */
public class Node {
    public String name;

    public Node() {
        this.name = null;
    }
    public Node(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        Node node = (Node)obj;
        if (node == null)
            return super.equals(obj);
        return this.hashCode() == node.hashCode();
    }

    @Override
    public int hashCode() {
        int result =17;
        result = 37 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
