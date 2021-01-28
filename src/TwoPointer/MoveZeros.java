package TwoPointer;

public class MoveZeros {
    public static void moveZeros(int[] nums) {
        int leftMostZero = 0; //first zero index in list

        for (int i = 0; i < nums.length; i++){
            if (nums[i] != 0 && nums[leftMostZero] == 0){
                nums[leftMostZero] = nums[i];
                nums[i] = 0;
                leftMostZero = i;
            }

            if (nums[leftMostZero] != 0){
                leftMostZero++;
            }
        }

    }
}
