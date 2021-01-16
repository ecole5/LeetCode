package com.LinkedList;

//Leetcode 138

import com.Node;

import java.util.HashMap;

public class CopyListWithRandomPointer {

    public Node copyRandomList(Node head) {

        if (head == null){
            return null;
        }

        Node originalHead = head;
        HashMap<Node, Node> map = new HashMap<>();
        Node preHead = new Node(0);
        Node oneBeforeNewHead = preHead;

        while (head != null){
            preHead .next = new Node(head.val);
            map.put(head,preHead.next);
            head = head.next;
            preHead = preHead.next;
        }

        head = originalHead;
        preHead = oneBeforeNewHead.next;
        while (head != null){
            preHead.random = map.get(head.random);
            head = head.next;
            preHead = preHead.next;
        }

        return oneBeforeNewHead.next;

    }


}
