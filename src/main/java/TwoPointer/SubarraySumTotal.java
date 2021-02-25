package TwoPointer;

import java.util.HashMap;

public class SubarraySumTotal {


    public int subarraySum(int[] nums, int k) {

        //Store seen prefix sums
        HashMap<Integer,Integer> prefixSums = new HashMap<>();
        prefixSums.put(0,1); //We have implicitly seen zero sum array before examining first element
        //total subarrays


        int totalSubarrays = 0;

        //Find all possible subarrays for each array length
        int currentSum = 0;
        for (int i = 0; i < nums.length; i++){

            //Set currentSum
            currentSum += nums[i];

            //Check if nessasry prefixSum is in table and add subbarrays that can be made with prefix sum to total
            int targetPrefixSum = currentSum-k;
            if (prefixSums.containsKey(targetPrefixSum)){
                totalSubarrays += prefixSums.get(targetPrefixSum);
            }

            //Now add currentSum as prefixSum
            if (!prefixSums.containsKey(currentSum)){
                prefixSums.put(currentSum,1);
            }
            else{
                //Increment if already seen
                prefixSums.put(currentSum,prefixSums.get(currentSum)+1);
            }
        }
        return  totalSubarrays;

    }

}


