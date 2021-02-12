package trees;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {

    //could improve this throguh memorization (top down dp) of the ispalindrome calls
    //There are overlapping subproblems

    List<List<String>> results = new ArrayList<List<String>> ();

    public List<List<String>> partition(String s) {
        partitionHelper(new ArrayList<String>() , s);
        return results;

    }

    private void partitionHelper(List<String> chosenPrefixes, String unchosen){
        //all the prefxes are chosen and each one is a palindorme
        //String has been decomoposed into a palindrome
        if (unchosen.length() == 0){
            results.add(new ArrayList<String>(chosenPrefixes));
            return;
        }

        //First dont add any partitions and take the entirity of unchosen as candidate prefix. if length is 1 then entirity is only option
        //Seperating this out provides a stime and space benfiit because we need 1 less substring at each recurssive step.
        if (isPalindrome(unchosen)){
            chosenPrefixes.add(unchosen);
            partitionHelper(chosenPrefixes,new String (""));
            chosenPrefixes.remove(chosenPrefixes.size()-1); //Need to remove after adding
        }

        //Length >= 2 then there is length -1 pivot points
        //Simpler code might be to just go through 0-length-1
        for (int i = 0; i < unchosen.length(); i++){
            String candPrefix = unchosen.substring(0,i+1);
            if (isPalindrome(candPrefix)){
                chosenPrefixes.add(candPrefix);
                partitionHelper(chosenPrefixes,unchosen.substring(i+1)); //automticlly goes to end
                chosenPrefixes.remove(chosenPrefixes.size()-1);
            }

        }

    }

    private boolean isPalindrome(String s){
        boolean flag = true;
        int startPointer = 0;
        int endPointer = s.length()-1;

        while (startPointer <= endPointer){
            if (s.charAt(startPointer) != s.charAt(endPointer)) {
                flag = false;
                break;
            }
            startPointer++;
            endPointer--;
        }


        return flag;


    }


}
