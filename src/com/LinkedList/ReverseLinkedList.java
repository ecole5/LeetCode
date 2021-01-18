package com.LinkedList;

import com.ListNode;

import java.util.List;

public class ReverseLinkedList {





    //Itterative solutions
    public ListNode reverseList (ListNode head){
        if (head == null){
            return null;
        }

        ListNode nodeBeforeLinkToSwap = head;
        ListNode nodeOfLinkToSwap = nodeBeforeLinkToSwap.next;
        head.next = null;

        while (nodeOfLinkToSwap != null){
            ListNode NodeAfterLinkToSwap = nodeOfLinkToSwap.next; //does not need to live longer than single loop

            nodeOfLinkToSwap.next = nodeBeforeLinkToSwap;

            nodeBeforeLinkToSwap = nodeOfLinkToSwap;
            nodeOfLinkToSwap = NodeAfterLinkToSwap;
        }
        return nodeBeforeLinkToSwap;
    }



    //Reccursive Solution to reverse linked list
    public ListNode reverseListRecursively(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode newHead = recurssiveHelper(head);
        head.next = null;
        return newHead;

    }

    public ListNode recurssiveHelper(ListNode current){
        if (current.next == null){
            return current;
        }
        ListNode tmp = recurssiveHelper(current.next);
        current.next.next = current;
        return tmp;
    }

}
