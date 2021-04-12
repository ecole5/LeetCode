package SearchSort;

//1 indexed answers

public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++){
            int can = numbers[i];

            int start = 0;
            int end = numbers.length-1;
            //Binary search entire space
            while(start <= end){
                int mid = start + (start-end)/2;

                if (numbers[mid]+can == target){
                    return mid < target ? new int[] {mid+1,target+1} : new int[] {target+1,mid+1};
                }
                else if (numbers[mid] + can > target){ //need a smaller number
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }
            //Nothing found for that integer

        }

        return new int []{-1,-1}; //should not happen


    }
}
