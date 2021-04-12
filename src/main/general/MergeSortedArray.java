package general;

import java.util.Deque;
import java.util.LinkedList;

public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {


        Deque<Integer> myQueue = new LinkedList<>();

        //merging into nums 1

        int j = 0;

        for (int i = 0; i < nums1.length; i++){
           if (myQueue.isEmpty()){
               if (i >= nums2.length || nums2[j] > nums1[i]) {
                   myQueue.add(nums1[i]);
                   nums1[i] = nums2[j];
                   j++;
               }

           }
           else{
               if (j < nums2.length && nums2[j] <= myQueue.peek()){
                   nums1[i] = nums1[j];
                   j++;
               }
               else{
                   nums1[i] = myQueue.pop();
               }
           }

        }


    }


}
