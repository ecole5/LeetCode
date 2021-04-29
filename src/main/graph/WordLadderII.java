package graph;

import java.util.*;

public class WordLadderII {





    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        List<List<String>> shortestPaths = new ArrayList<>();

        Map<String, List<String>> paths = bfsPaths(beginWord, endWord, wordList);

        if (paths == null){
            return  shortestPaths;
        }

        //DFS shortest paths using paths


    }


    private Map<String, List<String>>  bfsPaths(String beginWord, String endWord, List<String> wordList) {

        if (beginWord.equals(endWord)) {
            return null;
        }

        //Get all genaric forms of words (O (N*L) time and size) where N is number of words and L is length of word
        Map<String, List<String>> genaricForms = new HashMap<>(); //genaric form is key and words that it belongs to are values

        final int L = beginWord.length();

        for (String word : wordList) {
            for (int i = 0; i < L; i++) {
                String genaricWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                List<String> wordsWithThisGenaricForm = genaricForms.getOrDefault(genaricWord, new ArrayList<>());
                wordsWithThisGenaricForm.add(word);
                genaricForms.put(genaricWord, wordsWithThisGenaricForm);
            }
        }


        //NOW BFS to find shortest path. Remember that graph could have loops.

        Deque<String> queue = new ArrayDeque<>();

        Set<String> marked = new HashSet<>();
        Map<String, List<String>> paths = new HashMap<>();

        queue.add(beginWord);



        while (!queue.isEmpty()) {


            String word = queue.poll();
            paths.put(word, new ArrayList<>());

            for (int i = 0; i < L; i++) {
                String genaricWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                List<String> children = genaricForms.getOrDefault(genaricWord, null);

                if (children != null) {
                    for (String child : children) {
                        if (!marked.contains(child)) {
                            if (child.equals(endWord)) {
                                return paths;
                            }

                            queue.add(child);
                            marked.add(child);

                        }

                    }
                }


            }


        }

        return null;

    }
}
