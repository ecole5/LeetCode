package com.LinkedList;

import com.ListNode;

//Reverse a sublist of a linked list and return head. Do it in one pass.
//Recussive solution is really 2n (up and down)
public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int m, int n) {


        //Need dummyhead in case we need to change entire sublsit
        ListNode dummyHead = new ListNode(1,head);
        ListNode nodeBeforeSublist = dummyHead;


        //Move nodeBeforeSublist into correct position
        int i = 0; //index of nodeBeforeSublist
        while (i < m-1){ //index should be at m-1
            nodeBeforeSublist = nodeBeforeSublist.next;
            i++;
        }

        ListNode nodeBeforeMove = nodeBeforeSublist.next; //first item in sublist (becomes tail of sublist)
        ListNode nodeToMove = nodeBeforeMove.next;
        m++;

        while (m <= n){

            nodeBeforeMove.next = nodeToMove.next;
            nodeToMove.next = nodeBeforeSublist.next;
            nodeBeforeSublist.next = nodeToMove;
            nodeToMove = nodeBeforeMove.next; //update item to actualy move
            m++;
        }

        return dummyHead.next;
    }
}
