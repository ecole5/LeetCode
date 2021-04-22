package LinkedList;

import helper.ListNode;

public class MergeTwoSortedLists {

    /*
We could use the same strategy as if we have k lists to merge. We could use a heap and then have nlogk time.
But if we dont use a heap and just do comparisons we at most have to do n coparisons. So n time is better.
O(N) time and no extra space
*/


        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

            ListNode dummyHead = new ListNode();
            ListNode traversalHead = dummyHead;


            while(l1 != null && l2 != null){
                if (l1.val < l2 .val){


                    traversalHead.next = l1;
                    l1 = l1.next;
                }
                else{
                    traversalHead.next = l2;
                    l2 = l2.next;
                }
                traversalHead = traversalHead.next;

            }
            //connect the end
            traversalHead.next = l1 == null ? l2 : l1;

            return dummyHead.next;

        }

}
