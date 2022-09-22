package com.dong.SE.dataStructure.graph;

/**
 * @author dfx
 */
public class Vertex {
    private String value;
    private boolean visited;

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Vertex(String value) {
        this.value = value;
    }

    public Vertex() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
