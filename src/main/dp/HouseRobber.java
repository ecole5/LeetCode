package dp;

public class HouseRobber {
    public int rob(int[] nums) {

        //edge case
        if (nums.length == 1){
            return nums[0];
        }

        //set i = 1 to prevent issues in loop
        nums[1] = Math.max(nums[0], nums[1]);


        for (int i = 2; i < nums.length; i++){
            nums[i] = Math.max (nums[i] + nums[i-2], nums[i-1]); //reccurence realtionship
        }

        //return last element
        return nums[nums.length-1];

    }
}
