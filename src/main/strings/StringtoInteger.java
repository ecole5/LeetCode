package strings;

import java.util.Iterator;

public class StringtoInteger {
    public int myAtoi(String s) {


        int i = 0;
        int size = s.length();
        boolean sign = true; //true if positive
        boolean digetRead = false;
        StringBuilder num = new StringBuilder();

        //Avoids null acsses problems
        if (size == 0){
            return 0;
        }

        //Skip over leading whitespace
        while (i < size && s.charAt(i) == ' '){
            i++;
        }


        //If sign bit exists update sign boolean and pass over it. Default is + if DNE.
        if (i < size && (s.charAt(i) == '-' || s.charAt(i) == '+')){
            sign = s.charAt(i) == '+';
            i++;
        }

        //While not at end and if digit add to string builder
        while (i < size && Character.isDigit(s.charAt(i))){
            digetRead = true;
            num.append(s.charAt(i));
            i++;
        }

        //no digets but other things
        if (!digetRead){
            return 0;
        }


        int tmp;
        try{
            tmp = Integer.parseInt(num.toString());
        }
        catch(Exception e) {
            if (sign){
                return Integer.MAX_VALUE;
            }
            return Integer.MIN_VALUE;


        }

        return sign ? tmp: tmp*-1;



    }

}
