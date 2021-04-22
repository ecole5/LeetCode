package LinkedList;

import helper.ListNode;

import java.util.HashSet;

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> seen = new HashSet<>();

        while (head != null){
            if (seen.contains(head)){
                return true;
            }
            seen.add(head);
            head = head.next;
        }

        return false;

    }



    public boolean hasCycleFloyd(ListNode head) {
        if (head == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null){
            if (fast == slow){
                return true;
            }
            slow = slow.next;
            if (fast.next == null){
                return false;
            }
            fast = fast.next.next;
        }

        return false;

    }
}
