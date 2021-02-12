package TwoPointer;

import java.util.HashMap;

public class SubarraySumTotal {


    //O(n) space and time

    public static int subarraySumTotal(int[] arr, int target) {
        HashMap<Integer, Integer> prefixes = new HashMap<>();


        int currentSum = 0;
        int total = 0;
        for (int i : arr) {

            //Calculate currentsum
            currentSum += i;

            //Add to prefix sum list, value is number of times seen + 1
            prefixes.put(currentSum, prefixes.getOrDefault(currentSum, 0) + 1);

            //Needed prefix sum
            int neededPrefixSum = currentSum - target;

            //if needed prefixsum is 0 will not be in prefix sum map but still be valid
            if (neededPrefixSum == 0) {
                total++;
            }

            //Now check if currentSum-target (the prefix sum) exists in map and add how many times it occurs, if not exist 0
            total += prefixes.getOrDefault(neededPrefixSum, 0);
        }
        return total; //not found
    }

}


