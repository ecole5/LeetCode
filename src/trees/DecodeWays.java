package trees;

public class DecodeWays {

    public int numDecodings(String s) {
        return decodeHelper(s, 0, new Integer[s.length() + 1]);

    }

    private int decodeHelper(String s, int splitPoint, Integer[] memo) { //split point is index of first unchosen element
        //has everything been chosen?
        if (splitPoint == s.length()) {
            return 1;
        }

        //Memorization check happens here based on unchosen
        if (memo[splitPoint] != null) {
            return memo[splitPoint];
        }


        int total = 0;

        //Now check group of one
        if (isValid(s.substring(splitPoint, splitPoint + 1))) {
            memo[splitPoint + 1] = decodeHelper(s, splitPoint + 1, memo);
            total += memo[splitPoint + 1];
        }

        //Check group fo two if possible
        if (splitPoint + 2 <= s.length() && isValid(s.substring(splitPoint, splitPoint + 2))) {
            memo[splitPoint + 2] = decodeHelper(s, splitPoint + 2, memo);
            total += memo[splitPoint + 2];
        }

        return total;

    }

    private boolean isValid(String s) {
        if (s.charAt(0) == '0') {
            return false;
        }
        return Integer.parseInt(s) <= 26;
    }


}
