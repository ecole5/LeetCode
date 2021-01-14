package com.LinkedList;

public class DoubleNode {
    int data;
    DoubleNode next;
    DoubleNode prev;

    DoubleNode(DoubleNode next, DoubleNode prev, int data){
        this.next = next;
        this.data = data;
        this.prev = prev;

    }
    DoubleNode(int data){
        this.data = data;
        next = null;
        prev = null;
    }

    DoubleNode(int data, DoubleNode prev){
        this.data = data;

        this.prev = prev;
        this.next = null;
    }
}