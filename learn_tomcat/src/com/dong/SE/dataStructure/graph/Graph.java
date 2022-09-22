package com.dong.SE.dataStructure.graph;

import com.dong.SE.dataStructure.MyQueue;
import com.dong.SE.dataStructure.MyStack;

/**
 * @author dfx
 */
public class Graph {
    private Vertex[] vertexs;
    private int currentSize;
    public int[][] adjMat;
    public MyStack stack = new MyStack();
    public MyQueue queue = new MyQueue();
    //当前遍历到的下标
    private int currentIndex;

    //深度优先搜索
    public void dfs(){
        //先遍历第0个，进栈，
        //标记第0个已经被遍历
        vertexs[0].setVisited(true);
        stack.push(0);
        //输出
        System.out.println(vertexs[0].getValue());
        while (!stack.isEmpty()){
            //二维邻接矩阵逐层遍历
            for (int i = currentIndex+1; i < currentSize; i++){
                if (adjMat[currentIndex][i] == 1 && !vertexs[i].isVisited()){
                    //把元素压入栈中
                    vertexs[i].setVisited(true);
                    stack.push(i);
                    System.out.println(vertexs[i].getValue());
                    //深度优先，所以跳到第i层 二维矩阵
                    currentIndex = i;
                }
            }
            //弹出栈顶元素
            stack.pop();
            //修改当前位置为栈顶元素的位置
            if (!stack.isEmpty()){
                currentIndex = stack.peek();
            }
        }
    }

    //广度优先搜索
    public void bfs(){
        //同样先遍历第0个
        vertexs[0].setVisited(true);
        //入队
        queue.add(0);
        System.out.println(vertexs[0].getValue());
        //遍历
        while (!queue.isEmpty()){
            int index = currentIndex;
            for (int i = currentIndex; i < currentSize; i++){
                if (adjMat[currentIndex][i] == 1 && !vertexs[i].isVisited()){
                    vertexs[i].setVisited(true);
                    queue.add(i);
                    System.out.println(vertexs[i].getValue());
                }
            }
            queue.poll();
            if (!queue.isEmpty()){
                currentIndex = queue.peek();
            }
        }
    }

    public Graph(int size) {
        vertexs = new Vertex[size];
        //创建邻接矩阵
        adjMat = new int[size][size];
    }


    public Graph() {
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public void addVetex(Vertex vertex){
        adjMat[currentSize][currentSize] = 1;
        vertexs[currentSize++] = vertex;
    }

    public void addEdge(String v1, String v2){
        //先获取到两个顶点
        int index1 = 0;
        int index2 = 0;

        for (int i = 0; i < currentSize; i++){
            if (vertexs[i].getValue().equals(v1)){
                index1 = i;
            }
        }
        for (int i = 0; i < currentSize; i++){
            if (vertexs[i].getValue().equals(v2)){
                index2 = i;
            }
        }

        //设置邻接矩阵
        adjMat[index1][index2] = 1;
        adjMat[index2][index1] = 1;
    }







}
