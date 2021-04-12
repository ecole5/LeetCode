package TreeDFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets {

    List<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        helper(0,new ArrayList<>(),nums);
        return result;

    }

    private void helper(int possible, ArrayList<Integer> chosen, int nums[] ) {
        //Add state to solution by deep copy
        result.add(new ArrayList<>(chosen));

        if (possible == nums.length) { //past last index{
            return;
        }

        for (int i = possible; i < nums.length; i++){
            chosen.add(nums[i]);
            helper(i+1,chosen,nums); //dedup by prunning backwrds branches, branchesa are forced move forward at every level unlike combination sum
            chosen.remove(chosen.size()-1);

        }


    }
}
