package strings;

public class addBinary {
    public String addBinary(String a, String b) {

        StringBuilder res = new StringBuilder();
        int carry = 0;


        int endA = a.length()-1;
        int endB = b.length()-1;
        int offset = 0;

        //Go from end to start
        while (endA-offset >= 0 || endB-offset >= 0){

            int aCont = endA-offset >= 0 ? a.charAt(endA-offset) - '0':0;
            int bCont = endB-offset >= 0 ? b.charAt(endB-offset) - '0':0;


            int total = aCont + bCont-'0' + carry;

            //Set result
            if (total <= 1){
                carry = 0;
            }
            else{ //total is either 2 or three
                carry = 1;
                total -= 2; //

            }

            offset++;

            res.append(total); //adding from start to end though
        }


        //Now return and reverse at end so we dont have to shift each time
        return res.reverse().toString();

    }
}
