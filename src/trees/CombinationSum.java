package trees;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    List<List<Integer>> result = new ArrayList<>();


    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        cbHelper(candidates,target, new ArrayList<Integer>(), 0);
        return result;


    }

    private void cbHelper(int[] candidates, int remaining, List<Integer> chosen, int startPoint) {
        //check for base case
        if (remaining == 0) {
            result.add(new ArrayList<Integer>(chosen)); //deep copy chosen into results
            return;
        }

        //Prune branch
        if (remaining < 0) {
            return;
        }

        //Now go through all possible candidates to add
        for (int i = startPoint; i < candidates.length; i++) {
            chosen.add(candidates[i]);
            cbHelper(candidates, remaining-candidates[i], chosen, i); //prune backwards branches
            chosen.remove(chosen.size()-1);


        }
    }
}
