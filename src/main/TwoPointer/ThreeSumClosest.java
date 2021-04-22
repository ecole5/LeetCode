package TwoPointer;

import java.util.Arrays;

//exactly one solution but assume dplicates values in input
//dupoicates dont matter because only one solutions

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        Integer canTripleSum = null;

        for (int i = 0; i < nums.length-2; i++){

            int firstNumSelected = nums[i];

            int targetOfTuple = target-firstNumSelected;



            //Dial into target of tuple
            Integer canTupleSum = null; //closest target of tuple
            int start = nums[i+1];
            int end = nums[nums.length-1];

            while (start < end){
                if (canTupleSum == null || Math.abs(canTupleSum-targetOfTuple) < canTupleSum  ){
                    canTupleSum = nums[start]+nums[end];
                }
                else{
                    break; //we are getting futhur away
                }

                //which direction to move
                if (nums[start]+nums[end] > target){
                    end--;
                }
                else{
                    start++;
                }

            }

            if (canTripleSum == null  || Math.abs(canTupleSum+firstNumSelected) <  canTripleSum ){
                canTripleSum = canTupleSum+firstNumSelected;
            }

        }

        return canTripleSum;


    }
}
