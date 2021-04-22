package SearchSort;

import java.util.*;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> allNums = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            if (allNums.containsKey(target-nums[i])){
                return new int [] {i, allNums.get(target-nums[i])};
            }
            allNums.put(nums[i],i);
        }

        return new int [] {-1,-1};

    }
}
