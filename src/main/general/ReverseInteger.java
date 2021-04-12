package general;


public class ReverseInteger {

    public int reverse(int x) {


        String tmp = Integer.toString(x);
        if (x > 0) {
            if (tmp.charAt(0) - '0' <=Integer.MAX_VALUE % 10){
                return 0;
            }
        } else {
            if (tmp.charAt(1) - '0' <=Integer.MIN_VALUE % 10){
                return 0;
            }
        }

        return Integer.reverse(x);
    }


}
