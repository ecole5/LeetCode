package dp;

public class MaxSubArray {

    //Greedy choice
    //At every index we choose the max of (sum= Max(nums[current], nums[current]+sum)
    //When sum is positive we are going to choose later, and negative former
    //adding two negatives always makes a smaller.
    //Only possibility of getting new global maximum is resseting sum to current. Possible we will never find new maximum.
    //Graphing might help understand

    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int globalMax = nums[0];

        for (int i = 1; i < nums.length; i++){
            if (sum < 0) {
                sum = nums[i];
            }else{ //sum >= 0
                sum += nums[i];
            }
            globalMax = Math.max(sum,globalMax);
        }

        return globalMax;
    }
}
