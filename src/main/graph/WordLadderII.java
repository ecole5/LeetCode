package graph;

import java.util.*;

public class WordLadderII {





    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        List<List<String>> shortestPaths = new ArrayList<>();

        Map<String, List<String>> paths = bfsPaths(beginWord, endWord, wordList);

        if (paths.isEmpty()){
            return  shortestPaths;
        }

        //DFS shortest paths using paths

       List<String> seenSoFar = new ArrayList<>();
        seenSoFar.add(beginWord);
        dfsPath(beginWord,endWord,seenSoFar,paths, shortestPaths);

        return shortestPaths;


    }


    private void dfsPath(String currentWord, String endWord, List<String> wordSoFar,  Map<String, List<String>> paths, List<List<String>> shortestPaths){
        if (currentWord.equals(endWord)){
            List<String> tmp = new ArrayList<>(wordSoFar);
            shortestPaths.add(tmp);
            return;
        }

        for (String child: paths.get(currentWord)){
            wordSoFar.add(child);
            dfsPath(child,endWord,wordSoFar,paths,shortestPaths);
            wordSoFar.remove(wordSoFar.size()-1);
        }

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
        marked.add(beginWord);

        Map<String, List<String>> paths = new HashMap<>();

        queue.add(beginWord);



        while (!queue.isEmpty()) {


            String word = queue.poll();

            if (word.equals(endWord)){
                return paths;
            }

            paths.put(word, new ArrayList<>());

            for (int i = 0; i < L; i++) {
                String genaricWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                List<String> children = genaricForms.getOrDefault(genaricWord, null);

                if (children != null) {
                    for (String child : children) {
                        paths.get(word).add(child); //add child to parent list even if seen

                        if (marked.contains(child)){
                            continue;
                        }

                            paths.get(word).add(child); //add child to parent list even if seen


                            queue.add(child);
                            marked.add(child);



                    }
                }


            }


        }

        return paths;

    }
}
