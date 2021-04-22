package LinkedList;

//Leetcode 138

import helper.Node;


import java.util.HashMap;


public class CopyListWithRandomPointer {

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }


       HashMap<Node,Node> oldNewMap = new HashMap<>();
        Node newList = newList(head,oldNewMap);

        while (head != null){
            Node newRandom = oldNewMap.get(head.random);
            Node newnode = oldNewMap.get(head);
            newnode.random = newRandom;
            head = head.next;

        }

        return newList;

    }

    public Node newList (Node head, HashMap<Node, Node> oldnewMapping){
        if (head == null){
            return null;
            }
        oldnewMapping.put(head,new Node(head.val,newList(head.next,oldnewMapping)));
        return oldnewMapping.get(head);
    }


}
