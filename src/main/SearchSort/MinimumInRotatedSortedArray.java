package SearchSort;

public class MinimumInRotatedSortedArray {
    public int findMin(int[] nums) {

        int bCan = -1;

        int start = 0;
        int end = nums.length-1;

        while (start <= end){
            int mid = start + (end-start)/2;

            if (nums[mid] <= nums[nums.length-1] ){
                //In right quadrant minimum could be left
                bCan = mid;
                end = mid-1;

            }
            else{
                start = mid+1; // in left quadrant mid is always to right
                //Will never be here if non rotated array
            }
        }
        return nums[bCan];
    }
}