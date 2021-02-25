package trees;


import java.util.ArrayList;
import java.util.List;

public class Permutations {

    List<List<Integer>> results = new ArrayList<>(); //can not be specific to arrayList does not work must be List
    public List<List<Integer>> permute(int [] nums) {
        ArrayList<Integer> tmp = new ArrayList<>();
        for (int t : nums){
            tmp.add(t);
        }

        premuteHelper(new ArrayList<>(), tmp);
        return results;

    }

    public void premuteHelper(ArrayList <Integer> elementsChosen, ArrayList<Integer> elementsToChooseFrom){
        if (elementsToChooseFrom.size() == 0){
            //Make shallow copy of array list and add to results
            //Can only use this constructor method if making an arralist of same generic type
            results.add(new ArrayList<>(elementsChosen));
            return;
        }

        //Choose from all avlaible one time
        for (int i = 0; i < elementsToChooseFrom.size(); i++){
            elementsChosen.add(elementsToChooseFrom.remove(i)); //make choice and add to chosen and remove from elements to choose
            premuteHelper(elementsChosen,elementsToChooseFrom); //recursivly search for all permuations
            //undo choice so we can make another choice at this level
            //Remove from end of elments chosen and restore to oriignal position of i
            elementsToChooseFrom.add(i,elementsChosen.remove(elementsChosen.size()-1));
        }

    }


}
