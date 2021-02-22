package strings;

public class MoveZeros {

    //O(1) time
    //O(n) at  most O(2N)
    public void moveZeroes(int[] nums) {
        int positionOfNonZero = 0;

        for (int i = 0; i < nums.length; i++){
           if (nums[i] != 0){
               nums[positionOfNonZero] = nums[i];
               if (i > positionOfNonZero){
                   nums[i] = 0;
               }
               positionOfNonZero++;

           }

        }
    }
}
