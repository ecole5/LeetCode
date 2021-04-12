package SearchSort;


//Same as minimum in sorted array 1 but with duplicates
public class MinimumInRotatedSortedArrayII {
    public int findMin(int[] nums) {

        int bCan = -1;

        int start = 0;
        int end = nums.length-1;

        if (nums.length == 1){
            return nums[0];
        }

        while (start <= end){
            int mid = start + (end-start)/2;


            if (nums [mid] == nums[nums.length-1]){
                start--;
                end--;
                bCan = mid;
            }
            else if (nums[mid] < nums[nums.length-1] ){
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
