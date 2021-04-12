package TreeDFS;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {


    //log(2K) space
    //2^log(2,2K) time = 2k tine
    // acedamia big o "At least as fast)

    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        genParHelper(0,0,new StringBuilder(), n);
        return result;

    }



    private void genParHelper(int left, int right, StringBuilder current, int n){
        //Base case reached
        if (left == n){
            //Add remaning right
            StringBuilder remainingRight = new StringBuilder();
            for (int i = 0; i < n-right; i++){
                remainingRight.append(')');
            }
            result.add(current.toString()+remainingRight.toString());
            return;
        }

        //Binary tree
        //Add a left brace
        current.append('(');
        genParHelper(left+1,right, current,n);
        current.setLength(current.length()-1); //backtrack

        //Add a right brace if possiuble
        current.append(')');
        if (right+1 <= left){
            genParHelper(left,right+1, current,n);
        }
        current.setLength(current.length()-1); //backtrack


    }
}
