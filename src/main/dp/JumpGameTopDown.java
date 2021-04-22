package dp;

public class JumpGameTopDown {

    private boolean canJumpBol = false;
    public boolean canJump(int[] nums) {
        jumpHelper(nums,0);
        return canJumpBol;

    }

    private void jumpHelper(int[] nums, int currentIndex){
        //positive base case
        if (currentIndex == nums.length-1){
            canJumpBol = true;
        }
        for (int i = 1; i <= nums[currentIndex]; i++){
            if (currentIndex+i <= nums.length-1){
                jumpHelper(nums, currentIndex+i);
            }
        }
    }
}
