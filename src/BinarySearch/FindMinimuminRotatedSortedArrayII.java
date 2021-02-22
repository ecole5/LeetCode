package BinarySearch;

public class FindMinimuminRotatedSortedArrayII {

    public int findMin(int[] nums) {

        int low = 0;
        int high = nums.length-1;
        int smallestFalse = 0;//smallest element that is not greater than predessesor, default is zero in which all elements are greater than 1st element

        while (low <= high) {

            int mid = low +((high-low)/2);


            //Determain the filter
            boolean filterFlag = false;
            if (mid == 0){
                filterFlag = true;
            }
            else if (nums[mid-1] <= nums[mid]){
                filterFlag = true;
            }


            if (filterFlag){ //is increasing
                low = mid +1; //look right
            }
            else{
                smallestFalse = mid;
                high = mid-1; //look left

            }
            return smallestFalse == -1 ? 0: smallestFalse;



        }


    }

}
