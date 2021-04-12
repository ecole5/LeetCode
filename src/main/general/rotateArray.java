package general;

public class rotateArray {



    //Runtime O(3N) = O(N)

    public void rotate(int[] nums, int k) {

        k = k%nums.length;

        reverse(nums, 0, nums.length-1);
        reverse(nums,0, k-1);
        reverse(nums, k, nums.length-1);



    }


    private void  reverse(int nums[], int start, int end){
        for (; start <= end; start++){
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            end--;
        }
    }
}



