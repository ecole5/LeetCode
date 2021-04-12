package TwoPointer;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSumTwoPointer(int[] nums) {


        //First we need to sort O(nlogn)
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();


        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > 0) {
                break;
            }

            //fast forward duplicates
            while (i > 0 && i < nums.length && nums[i - 1] == nums[i]) {
                i++;
            }

            int start = nums[i] + 1;
            int end = nums.length - 1;
            int target = nums[i] * -1;

            while (start < end) {
                if (nums[start] + nums[end] == target) {
                    result.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    start++;
                    end--;
                    //Deal with duplicates. Why onl
                    while (start > 0 && start < nums.length && nums[start] == nums[start-1]){
                        start++;
                    }

                } else if (nums[start] + nums[end] < target) {
                    start++; //need a bigger number
                } else {
                    end--; //need a smaller number
                }
            }
        }
        return result;

    }




}


