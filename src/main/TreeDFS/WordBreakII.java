package TreeDFS;

import java.util.*;


/*
Ass spaces to construct a sentence where each word is a valid dictonary word. Return all such possible senteces in any order.
The only really challenging thing here is that we need to be smart about how we use the memo data structure.
We use the memo as postfixes building solutions on the way back up

 */

public class WordBreakII {

    //Memorize all the possible sentences for this subprolbem
    HashMap<String, List<List<String>>> memo = new HashMap<>();


    public List<String> wordBreak(String s, List<String> wordDict) {

        //Fill the base case with empty solution.
        //Note that we return a list of empty list as the result, rather than just an empty list.
        List<List<String>> tmp = new ArrayList<>();
        tmp.add(new ArrayList<String>());
        memo.put("",tmp);

        //Create mathimatical set of valid words
        HashSet<String> wordSet = new HashSet<>(wordDict);

        wordBreakHelper(s, wordSet);

        //convert list of sentences to strings
        List<String> res = new ArrayList<>();
        for (List<String> sentence : memo.get(s)) {
            res.add(String.join(" ", sentence));

        }
        return res;

    }

    private void wordBreakHelper(String subProblem, HashSet<String> wordSet) {

        //if already seen we dont have to do anyhting. (already seen empty case)
        if (memo.containsKey(subProblem)) {
            return;
        }

        //Create empty entry for this subproblem. We know it dosent exist yet.
        memo.put(subProblem, new ArrayList<>());


        for (int i = 0; i < subProblem.length(); i++) {
            String chosen = subProblem.substring(0, i + 1);


            if (wordSet.contains(chosen)) {
                String canSubProblem = subProblem.substring(i + 1);
                wordBreakHelper(canSubProblem, wordSet);


                List<List<String>> subProlbemSolutions = memo.get(subProblem);


                //For every postfix sentence add new prefix as solution to this subproblem
                for (List<String> t : memo.get(canSubProblem)) {
                    List<String> newSolution = new ArrayList<>(t);
                    newSolution.add(0, chosen);
                    subProlbemSolutions.add(newSolution);

                }


            }


        }


    }

}
