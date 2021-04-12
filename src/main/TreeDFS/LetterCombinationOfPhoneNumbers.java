package TreeDFS;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LetterCombinationOfPhoneNumbers {

    Map<Character, String> phone = new HashMap<Character, String>() {{ //this is called an anynomus subclass
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};


    public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<>();
        if (digits.length() != 0){
            letterCombinationsHelper(new StringBuilder(), digits, 0, res);
        }

        return res;
    }

    private void letterCombinationsHelper(StringBuilder chosenSoFar, String digets, int currentDiget, List<String> res){
        //base case when already processed all digets
        if (currentDiget == digets.length()){
            res.add(chosenSoFar.toString());
            return;
        }

        String currentLetters = phone.get(digets.charAt(currentDiget));

        //Select all possible letters at digiet
        for (int i = 0; i < currentLetters.length(); i++){
            chosenSoFar.append(currentLetters.charAt(i));
            letterCombinationsHelper(chosenSoFar,digets,currentDiget +1, res);
            chosenSoFar.setLength(chosenSoFar.length()-1); //remove last element
        }

    }


}
