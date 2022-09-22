package com.dong.SE.dataStructure.tree;

import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;

/**
 * @author dfx
 */
public class ArrayBinnaryTree {
    int[] data;

    public ArrayBinnaryTree(int[] data) {
        this.data = data;
    }

    public void frontShow(){
        frontShow(0);
        System.out.println();
    }

    private void frontShow(int i) {
        if (data == null || data.length == 0){
            return;
        }
        //先遍历当前节点的内容
        System.out.print(data[i]+" ");
        //遍历左节点
        if (2*i+1 < data.length){
            frontShow(2*i+1);
        }
        //遍历右节点
        if (2*i+2 < data.length){
            frontShow(2*i+2);
        }
    }

    public void midShow() {
        midShow(0);
        System.out.println();
    }

    private void midShow(int i) {
        if (data == null || data.length == 0){
            return;
        }
        if (2*i+1 < data.length){
            midShow(2*i+1);
        }
        System.out.print(data[i] + " ");
        if (2*i+2 < data.length){
            midShow(2*i+2);
        }
    }


    public void afterShow() {
        afterShow(0);
        System.out.println();
    }

    private void afterShow(int i) {
        if (data == null || data.length == 0){
            return;
        }
        if (2*i+1 < data.length){
            afterShow(2*i+1);
        }
        if (2*i+2 < data.length){
            afterShow(2*i+2);
        }
        System.out.print(data[i] + " ");
    }
}
