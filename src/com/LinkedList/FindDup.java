package com.LinkedList;

import com.Node;

import java.util.HashSet;

public class FindDup {

    //2.1 Optimzing for time remove dupkicates in single linked list
    public static void findDup(Node head){
        Node prev = head;
        head = head.next;

        HashSet<Integer> record = new HashSet<>(); //Generic cannot be primitive type
        record.add(prev.val);
        while (head != null){
            if (record.contains(head.val)){
                prev.next = head.next;
            }
            else{
                record.add (head.val);
                prev= prev.next;
            }
            head = head.next;
        }
    }

    //2.1b Optimzing for space remove dupkicates in single linked list
    public static void findDupSpace(Node head){
        Node slow = head;
        Node fast = head.next;
        Node prev = head;


        while (slow.next != null){
            while (fast!=null){
                if (slow.val == fast.val){
                    prev.next = fast.next;
                }
                else{
                    prev = prev.next;
                }
                fast = fast.next;
            }
            slow = slow.next;
            prev = slow;
            fast = slow.next;
        }

    }

}
