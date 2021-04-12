package SearchSort;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {





        int start = 0;
        int end = nums.length-1;


        while (start <= end){

            int mid = start + (end-start)/2;
            if (nums[mid] == target){
                return mid;
            }



            //choice in left and target in right
            if (nums[mid] > nums[nums.length-1] && target <= nums[nums.length-1]){
                start = mid+1; //look right

            }
            else if (nums[mid] <= nums[nums.length-1] && target > nums[nums.length-1]){ //choice in right and target in left
                end = mid-1;//look left
            }
            else{ //both in left or both in right normal case
                if (nums[mid] > target){
                    end = mid-1;//look left
                }
                else{ //look right
                    start = mid+1;

                }

            }



        }


        return -1;


    }
}
