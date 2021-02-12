package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        cbHelper(candidates, target, 0, new LinkedList<Integer>());
        return result;
    }

    private void cbHelper(int[] candidates, int target, int sum, LinkedList<Integer> chosen) {
        //check for base case
        if (sum == target) {
            result.add(new ArrayList<Integer>(chosen)); //deep copy chosen into results
        }

        //Now go through all possible candidates to add
        for (int i : candidates) {
            if ((sum + i) <= target) { //prune if greater than target
                chosen.push(i);
                cbHelper(candidates,target,sum+i,chosen);
                chosen.pop();
            }
        }
    }
}
