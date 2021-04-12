package TreeDFS;

import java.util.*;

public class PermutationsII {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        //sort to find duplicates
        Arrays.sort(nums);

        ArrayList<Integer> notSelected = new ArrayList<>();
        for (int n : nums){
            notSelected.add(n);
        }
        helper(notSelected, new ArrayList<>());
        return result;



    }

    private void helper(ArrayList<Integer> notSelected, ArrayList<Integer> selected){
        //Base case -> nothing left to select for this path
        if (notSelected.size() == 0){
            result.add(new ArrayList<>(selected)); //save a copy of permuatation for reslt
            return;
        }


        for (int i = 0; i < notSelected.size() ; i++){
            //fast forward over recursivly calling duplicates duplicates
            if (i > 0 && notSelected.get(i).equals(notSelected.get(i - 1))){
                continue;
            }

            //change state
            int tmp = notSelected.get(i);
            notSelected.remove(i);
            selected.add(tmp);


            //make recursive call
            helper(notSelected,selected);

            //backtrack
            selected.remove(selected.size()-1);
            notSelected.add(i,tmp);

        }


    }



}
