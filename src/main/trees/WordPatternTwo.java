package trees;

import javax.print.DocFlavor;
import java.util.*;


//Let s be length of string and n be depth of tree which is unique letters in pattern
//O(exponential s^n) time
//O(n) space but for the purpsoe of space n is not unique but all letter in pattern because we recursse even when there is only one chocie

public class WordPatternTwo {



    public boolean wordPatternMatch(String pattern, String s) {



        HashMap<Character, String> patternMapping = new HashMap<>();


        return wordPatternMatch(pattern,s,0,0,patternMapping);


    }

    private boolean wordPatternMatch(String pattern, String s, int indexFirstUnchosen, int indexInPattern, HashMap<Character,String> patternMap){


        //Chosen all in pattern? check for base case
        if (indexInPattern == pattern.length()){
            if (indexFirstUnchosen != s.length()){
                return false;
            }
            //Check map to same string
            HashMap<String,Character> uniqueMapping = new HashMap<>();


            StringBuilder buildCan = new StringBuilder();
            for (char c : pattern.toCharArray()){
                String mappedPattern = patternMap.get(c);

                if (uniqueMapping.containsKey(mappedPattern)){
                    if (uniqueMapping.get(mappedPattern) != c){  //no two letters in pattern may share same mapping
                        return false;
                    }
                }else{
                    uniqueMapping.put(mappedPattern,c);
                }
                buildCan.append(patternMap.get(c));
            }
            return s.equals(buildCan.toString());

        }


        //If we have already chosen mapping just need to advance index in string until unchosen to potentially choose new mapping
        if (patternMap.containsKey(pattern.charAt(indexInPattern))){
            int newStart = indexFirstUnchosen + patternMap.get(pattern.charAt(indexInPattern)).length();
            if (wordPatternMatch(pattern,s,newStart,indexInPattern+1,patternMap)){
                return true;
            }
        }
        else{
            //Choose all new mappings (some will be impossible)
            for (int i = indexFirstUnchosen; i < s.length(); i++){
                patternMap.put(pattern.charAt(indexInPattern),s.substring(indexFirstUnchosen,i+1));

                if (wordPatternMatch(pattern,s,i+1,indexInPattern +1 ,patternMap)){
                    return true;
                }
                patternMap.remove(pattern.charAt(indexInPattern)); //backtrack

            }

        }
        return false;




    }
}
