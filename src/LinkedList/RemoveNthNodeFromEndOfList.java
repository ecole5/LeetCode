package LinkedList;

import helper.ListNode;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int distanceFromEnd = n-1;

        ListNode fauxHead = new ListNode(0,head); //save for later to always return new head, and to remove at start edge case

        //Nodes used in traversal
        ListNode preMoval = fauxHead; //one before node to be removed
        ListNode endOfList = preMoval;

        //move end of list distancefromEnd +1 away from preremoval, when at last element of list premoval
        for (int i = 0; i < (distanceFromEnd +1) ; i++){
            endOfList = endOfList.next;
        }

        //Advance two pointer until in correct position
        while(endOfList.next != null){
            endOfList = endOfList.next;
            preMoval = preMoval.next;
        }

        preMoval.next = preMoval.next.next; //delete node

        return fauxHead.next;

    }
}
