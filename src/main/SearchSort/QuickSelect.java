package SearchSort;

public class QuickSelect {

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, k-1, 0, nums.length-1);
    }


    private int partition (int [] nums, int start, int end){

        int pivotValue = end;

        int leftSideOfPivot = start;
        int rightSideOfPivot = end;



        while(leftSideOfPivot < rightSideOfPivot){
            while (leftSideOfPivot   <= end && leftSideOfPivot < rightSideOfPivot && nums [leftSideOfPivot] <= pivotValue){
                leftSideOfPivot++;
            }

            if (leftSideOfPivot <= end){
                swap(nums, leftSideOfPivot, rightSideOfPivot);
                rightSideOfPivot--;
            }


            while (rightSideOfPivot >= 0 && rightSideOfPivot > leftSideOfPivot && nums[rightSideOfPivot] > pivotValue){
                rightSideOfPivot--;
            }
            if (rightSideOfPivot >= 0 && right){
                swap(nums,leftSideOfPivot,rightSideOfPivot)
                leftSideOfPivot++;
            }


        }

        return leftSideOfPivot;


        
    }

    //Swap a and b
    private void swap (int nums[], int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    private int quickSelect(int [] nums, int k, int start, int end){

        int selectedIndex = partition(nums,start,end);

        if (selectedIndex == k){
            return nums[k];
        }
        else if (selectedIndex > k){ //look left
            return quickSelect(nums, k, start, selectedIndex-1);
        }
        else{ //look right
            return quickSelect(nums,k, selectedIndex+1,end);
        }

    }
}
