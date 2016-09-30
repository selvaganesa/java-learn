package com.nastra.datastructures;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents the data structure for a graph with undirected edges. It maintains a vertex-indexed array of sets of undirected edges, which represent
 * the adjacency lists.
 * 
 * @author nastra - Eduard Tudenhoefner
 */
public class EdgeWeightedGraph {

    private final int vertices;
    private int edges;
    private Set<Edge>[] adjacent;

    @SuppressWarnings("unchecked")
    public EdgeWeightedGraph(int vertices) {
        this.vertices = vertices;
        this.edges = 0;
        adjacent = (Set<Edge>[]) new Set[vertices];
        for (int v = 0; v < vertices; v++) {
            adjacent[v] = new HashSet<Edge>();
        }
    }

    public int verticesCount() {
        return vertices;
    }

    public int edgeCount() {
        return edges;
    }

    public void addEdge(Edge e) {
        int v = e.oneSide();
        int w = e.otherSide(v);
        adjacent[v].add(e);
        adjacent[w].add(e);
        edges++;
    }

    public Iterable<Edge> adjacent(int vertex) {
        return adjacent[vertex];
    }

    public Iterable<Edge> edges() {
        Set<Edge> set = new HashSet<Edge>();
        for (int v = 0; v < vertices; v++) {
            for (Edge edge : adjacent[v]) {
                if (edge.otherSide(v) > v) {
                    set.add(edge);
                }
            }
        }
        return set;
    }
}
