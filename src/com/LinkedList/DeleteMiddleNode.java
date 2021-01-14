package com.LinkedList;

public class DeleteMiddleNode {
    //2.3 delete middle node (given middle node)
    static void removeMiddle(Node middle){
        Node fast = middle.next;
        while (fast.next !=null){
            middle.val = fast.val;
            middle = middle.next;
            fast = fast.next;
        }
        middle.val = fast.val;
        middle.next = null;
    }

}
