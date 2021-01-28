package strings;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String [] args){
        longestSubstringWithoutRepeatingCharacters("abcdbea");
    }

    public static int longestSubstringWithoutRepeatingCharacters(String s) {
        int maxLength = 0;
        int start = 0;

        char [] arr = s.toCharArray();

        //Object to record index of each character
        HashMap<Character, Integer> record = new HashMap<>();

        //end will always be the same thing as current
        //expand window end each time and slide front to make sure it has unqiue characters
        for (int end = 0; end < arr.length; end++){

            //If already seen need to slide start to make uniuqe again
            if (record.containsKey(arr[end])){
                int canStart = record.get(arr[end])+1; //one ahed of place where character last seen
                start = canStart > start ? canStart : end; //you cant slide back because it might violate the uniquness with another character
            }
            //record most recent index of character value
            record.put(arr[end],end);

            maxLength = Math.max(maxLength, end-start+1);
        }

        return maxLength;
    }


}
