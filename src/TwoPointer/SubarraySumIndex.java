package TwoPointer;

import java.util.HashMap;

public class SubarraySumIndex {


    //O(n) space and time

    public static int[] subarraySum(int[] arr, int target) {
        HashMap<Integer,Integer> prefixes = new HashMap<>();


        int currentSum = 0;
        for (int currentIndex = 0; currentIndex < arr.length; currentIndex++){

            //Calculate currentsum
            currentSum += arr[currentIndex];

            //Add to prfix sum list
            prefixes.putIfAbsent(currentSum,currentIndex); //value is location of end index

            //Needed prefix sum
            int neededPrefixSum = currentSum-target;

            //if needed prefixsum is 0 will not be in prefix sum map but still be valid
            if (neededPrefixSum == 0){
                return new int [] {0,currentIndex+1}; //end index is exlusive per spec of algo mosnter
            }

            //Now check if currentSum-target (the prefix sum) exists in map
            if (prefixes.containsKey(neededPrefixSum)){
                //the map key is end index of PrefixSum. We want to exclude prefix sum CurrentSum-PrefixSum = target. Add 1
                // end index is exlusive ')' because of algo monster spec
                return new int [] {prefixes.get(neededPrefixSum)+1,currentIndex+1};
            }
        }
        return null; //not found
    }

}
