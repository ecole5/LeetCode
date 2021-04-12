package TreeDFS;

import java.util.List;

public class WordBreakII {

    public boolean wordBreak(String s, List<String> wordDict) {
        return wbHelper(s,0,wordDict, new Boolean [s.length()]);

    }


    private boolean wbHelper(String original, int startUnchosen, List<String> wordDict, Boolean [] memo){
        if (startUnchosen == original.length()){ //just out of range
            return true;
        }
        if (memo[startUnchosen] != null){ //needs to be wrapper type so intilized to null, primitives cannot be null
            return memo[startUnchosen];
        }

        for (int i = startUnchosen+1; i <= original.length(); i++ ) {
            if (wordDict.contains(original.substring(startUnchosen, i))) {

                if (wbHelper(original, i, wordDict, memo)){
                    return memo[startUnchosen] = true;
                }
            }
        }
        return memo[startUnchosen] = false;
    }
}
