package com.LinkedList;

public class Partition {
    public static Node partition(Node node, int x){
        Node head = node;
        Node tail = node;

        //The key to understanding this aprocch is the head and tail must start the same. You keep creating new heads, and keep creating new tails

        while (node != null) {
            Node next = node.next; //save next
            if (node.val < x) {
                node.next = head;
                head = node;
            } else {
                tail.next = node;
                tail = node;
            }
            node = next;
        }
        tail.next = null;
        return head;

    }

    public static DoubleNode partition(DoubleNode head, int k){
        DoubleNode n = head;
        while (n != null){

            if (n.data < k){

                DoubleNode swap = n;
                n = n.next;

                swap.prev.next = swap.next;

                if (swap.next != null){
                    swap.next.prev = swap.prev;
                }



                swap.prev = null;
                swap.next = head;

                head.prev = swap;
                head = swap;

            }
            else{
                n = n.next;
            }

        }
        return head;
    }

}
