package SearchSort;

public class FirstLastPositionSortedArray {



    public int[] searchRange(int[] nums, int target) {



        int start = 0;
        int end = nums.length-1;
        int sCan = -1;

        while (start <= end){
            int mid = start + (end-start)/2;

            if (nums[mid] == target) {
                sCan = mid;
                end = mid-1; //look left for candidate futhur to left
            } else if (nums[mid] > target) {
                end = mid - 1; //look left
            }else{
                start = mid+1; //look right
            }

        }

        start = 0;
        end = nums.length-1;
        int eCan = -1;

        while (start <= end){
            int mid = start + (end-start)/2;

            if (nums[mid] == target) {
                eCan = mid;
                start = mid+1; //look right for candidate futhuer to right
            } else if (nums[mid] > target) {
                end = mid - 1; //look left
            }else{
                start = mid+1; //look right
            }

        }

        return new int[] {sCan,eCan};


    }



    public int[] searchRangeAlt(int[] nums, int target) {


        int insideBorder = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                insideBorder = mid;
                break;
            } else if (nums[mid] < target) {
                start = mid + 1;//look right
            } else {
                end = mid - 1; //look left
            }

        }


        if (insideBorder == -1) {
            return new int[]{-1, -1};
        }

        int s = insideBorder;
        while (s - 1 >= 0 && nums[s - 1] == target) {
            s--;
        }

        int e = insideBorder;
        while (e + 1 < nums.length && nums[e + 1] == target) {
            e++;
        }

        return new int[]{s, e};


    }
}
