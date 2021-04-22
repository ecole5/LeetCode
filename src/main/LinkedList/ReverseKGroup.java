package LinkedList;

import helper.ListNode;

public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {


        //Determain length
        int length = 0;

        ListNode tmp = head;
        while (tmp != null){
            length++;
            tmp = tmp.next;
        }
        ListNode returnHead = new ListNode(-1,head);
        ListNode nodeBeforeReversing = returnHead;
        ListNode nodeAfterReversing = head;


        //Run this operation three times
        for (int i = 0; i < length/k; i++){

            //Move pointers to before and after group
            if (nodeAfterReversing.val != -1){ //no need to move on first itteration
                nodeAfterReversing = fastForward(nodeAfterReversing,k);
            }
            nodeBeforeReversing = fastForward(nodeBeforeReversing,k);



            //save tail of reversed group
            ListNode lastNodeReversedGroup = nodeBeforeReversing.next;

            //Connect Head of reverse group
            nodeBeforeReversing.next = reverseForDepth(nodeBeforeReversing.next, k);

            //connect tail of reversed group
            lastNodeReversedGroup.next = nodeAfterReversing;




        }
        return returnHead.next;

    }


    private ListNode fastForward(ListNode l, int places){
        for (int i = 0; i < places; i++){
            l = l.next;
        }
        return l;
    }

    private ListNode reverseForDepth(ListNode head, int depth){
        if (depth == 1){ //last element is 1
            return head;
        }
        ListNode newHead = reverseForDepth(head.next,depth-1);
        head.next.next = head;

        return newHead;

    }
}
