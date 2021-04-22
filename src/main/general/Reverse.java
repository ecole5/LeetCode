package general;

public class Reverse {
    public int reverse(int x) {
        int start = x > 0 ? 0 :1;

        String tmp = Integer.toString(x);
        tmp = tmp.substring(start);

        StringBuilder reversed = new StringBuilder(tmp);

        try {
            int cool = Integer.parseInt(reversed.reverse().toString());
            return x > 0 ? cool: cool*-1;

        }catch (Exception e){
            return 0;
        }

    }
}
