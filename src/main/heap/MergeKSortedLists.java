package heap;

import helper.ListNode;

import java.util.PriorityQueue;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        final int K = lists.length;

        ListNode dummyNode = new ListNode();
        ListNode orgDummy = dummyNode;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(K, (o1,o2) -> o1.val-o2.val);

        ListNode nextToAdd;


        //Get the heap started by adding 1 level
        for (int i = 0; i < K; i++){
            minHeap.add(lists[i]);
        }


        while (!minHeap.isEmpty()) {
            ListNode adding = minHeap.poll();

            //if not last element in linked add add back to heap
            if (adding.next != null){
                minHeap.add(adding.next);
            }

            //Add result to list
            dummyNode.next = adding;
            dummyNode = dummyNode.next;

        }


        return orgDummy.next;


    }

}
