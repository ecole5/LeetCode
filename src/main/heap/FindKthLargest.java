package heap;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;

public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {

        //Elements contain duplciates. We want to store top k biggest elemeents in heap. Eliminate duplicates with hash set.
        HashSet<Integer> uniqueValues = new HashSet<>(nums.length); //set hash set buckets so we get good itteration perfomance
        for (int num : nums){
            uniqueValues.add(num); //only adds if not already added
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); //keep the biggest k in the heap. Smallest element at top of heap is k biggest in array
        for (int temp : uniqueValues){
            if (minHeap.size() == k) {
                if (temp > minHeap.peek()) { //Bigger element?
                    minHeap.poll();
                    minHeap.add(temp);
                }
            }
            else{ //still filling
                minHeap.add(temp);

            }
        }

        return minHeap.poll(); //return the smallest element of the k biggest elements. The k'th biggest ele,emtn

    }

}
