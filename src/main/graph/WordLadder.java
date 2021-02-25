package graph;

import java.util.*;

public class WordLadder {


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        //Preprocess to get hash table of generic forms of each dictonary word
        //Let N be number of words in dictonary and M length of word
        //M*N entries each with list of size ?

        HashMap<String, LinkedList<String>> adjTable = new HashMap<>();


        final int M = wordList.get(0).length();


        //Need to avoid hashing with mutable keys because java default haash function is just using a memory adress


        //Key is generic form with one letter reaplced with *
        //remember diffrent words must share generic forms
        for (String word : wordList) {
            char[] wordByChar = word.toCharArray();
            for (int i = 0; i < M; i++) {
                char tmp = wordByChar[i];
                wordByChar[i] = '*';
                adjTable.putIfAbsent(Arrays.toString(wordByChar),new LinkedList<>());
                adjTable.get(Arrays.toString(wordByChar)).add(word);
                wordByChar[i] = tmp;
            }
        }


        //Keep track of used words. Using a word more than once is a loop
        Set<String> seen = new HashSet<>();


        Deque<String> visitQueue = new LinkedList<>();

        //Get BFS start by adding head
        visitQueue.add(beginWord);

        int chosenWords = 0;

        while (!visitQueue.isEmpty()) {

            int levelSize = visitQueue.size();
            chosenWords++;

            //visit all nodes at this level
            for (int i = 0; i < levelSize; i++) {
                String visiting = visitQueue.remove();
                seen.add(visiting);

                //Check for base case
                if (visiting.equals(endWord)) {
                    return chosenWords;
                }

                char[] wordByChar = visiting.toCharArray();

                //Now check all the generic forms
                for (int e = 0; e < M; e++) {

                    char tmp = wordByChar[e];
                    wordByChar[e] = '*';

                    LinkedList<String> adjWord = adjTable.get(Arrays.toString(wordByChar));

                    //If prefix forms of the first word are not in adjTable, remember first word not in wordlsit
                    if (adjWord != null){
                        //Check all words at this generic form
                        for (String word : adjWord) {
                            if (!seen.contains(word)) {
                                visitQueue.add(word);
                            }
                        }

                    }



                    wordByChar[e] = tmp;
                }
            }

        }


        return 0;

    }

}


