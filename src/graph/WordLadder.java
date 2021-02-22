package graph;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class WordLadder {


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        //Keep track of used words. Using a word more than once is a loop
        boolean[] seen = new boolean[wordList.size()];

        Deque<String> visitQueue = new LinkedList<>();

        //Get BFS start by adding head
        visitQueue.addFirst(beginWord);

        int level = 0;
        while (!visitQueue.isEmpty()) {

            int levelSize = visitQueue.size();


            //visit all nodes at this level
            for (int i = 0; i < levelSize; i++) {
                String visiting = visitQueue.removeLast();

                //Check for base case
                if (visiting.equals(endWord)) {
                    return level;
                }

                //Only a candidate child if not seen and edit distance of <1
                for (String can : wordList) {
                    for (int e = 0; e < wordList.size(); e++) {
                        if (!seen[e] && validEditDistance(visiting,wordList.get(e))) {
                            visitQueue.addFirst(wordList.get(e));
                            seen[e] = true;
                        }
                    }
                }
            }
            level++;
        }
        return level;
    }


    private boolean validEditDistance(String original, String next){
        //Assume they are of equal length
        //true if only one letter diffrence


        int count = 0;

        for (int i = 0; i < original.length(); i++){
            count = original.charAt(i) == next.charAt(i) ? count: count+1;
            if (count > 1){
                return false;
            }
        }

        return count == 1; //if they are equal it is false

    }
}
