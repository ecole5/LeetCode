package strings;

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {

        //Ignore diffrences in case
        s = s.toLowerCase();

        //Define initial start point of two pointers
        int start = 0;
        int end = s.length()-1;

        //Inocent until proven guilty
        boolean flag = true;

        //works for both even and odd
        while (start < end){

            //Skip over non alpha numric charactes
            if (!Character.isLetterOrDigit(s.charAt(start))){
                start++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(end))){
                end--;
                continue;
            }

            //When both characters alphanumric compare
            if (s.charAt(start) != s.charAt(end)){
                flag = false;
                break;
            }

            //check next two if flag has not be raised
            start++;
            end--;
        }

        return flag;


    }
}
