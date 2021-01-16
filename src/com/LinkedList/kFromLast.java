package com.LinkedList;

import com.Node;

public class kFromLast {
    //2.2 find k from last
    static Node findKLast(int k, Node head){
        Node fast = head;
        for (int i = 0; i<k; i++){
            fast = fast.next;
        }
        while (fast.next != null){
            fast = fast.next;
            head = head.next;
        }
        return head;
    }

}
