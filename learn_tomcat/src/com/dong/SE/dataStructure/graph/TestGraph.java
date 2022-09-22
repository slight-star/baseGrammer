package com.dong.SE.dataStructure.graph;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author dfx
 */
public class TestGraph {
    public static void main(String[] args) {
        Vertex v1 = new Vertex("A");
        Vertex v2 = new Vertex("B");
        Vertex v3 = new Vertex("C");
        Vertex v4 = new Vertex("D");
        Vertex v5 = new Vertex("E");

        Graph graph = new Graph(5);

        graph.addVetex(v1);
        graph.addVetex(v2);
        graph.addVetex(v3);
        graph.addVetex(v4);
        graph.addVetex(v5);

        //设置边
        graph.addEdge("A","B");
        graph.addEdge("A","C");
        graph.addEdge("B","C");
        graph.addEdge("B","D");
        graph.addEdge("B","E");


        System.out.println(graph);

        //遍历邻接矩阵
        for (int[] arr : graph.adjMat){
            System.out.println(Arrays.toString(arr));
        }

        System.out.println(graph.getCurrentSize());
        graph.dfs();
    }

    @Test
    public void testBfs(){
        Vertex v1 = new Vertex("A");
        Vertex v2 = new Vertex("B");
        Vertex v3 = new Vertex("C");
        Vertex v4 = new Vertex("D");
        Vertex v5 = new Vertex("E");

        Graph graph = new Graph(5);

        graph.addVetex(v1);
        graph.addVetex(v2);
        graph.addVetex(v3);
        graph.addVetex(v4);
        graph.addVetex(v5);

        //设置边
        graph.addEdge("A","B");
        graph.addEdge("A","D");
        graph.addEdge("B","C");
        graph.addEdge("B","E");

        //遍历邻接矩阵
        for (int[] arr : graph.adjMat){
            System.out.println(Arrays.toString(arr));
        }
        //广度
        graph.bfs();
    }
}
