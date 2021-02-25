package strings;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int indexOfUnqiue = 0;

        //Intilize 1 ahead to compare with previous
        for (int i = 1; i < nums.length; i++){
            //Add a new unique index at avaliable index
            if (nums[i] != nums[i-1]){
                nums[++indexOfUnqiue] = nums[i];
            }
        }
        return indexOfUnqiue +1; //convert index to length
    }
}
