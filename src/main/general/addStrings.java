package general;

public class addStrings {


    public String addStrings(String num1, String num2) {

        int carryBit = 0;
        StringBuilder result = new StringBuilder();

        String bigNum;
        String smallNum;
        if (num1.length() > num2.length()) {
            bigNum = num1;
            smallNum = num2;
        } else {
            bigNum = num2;
            smallNum = num1;
        }

        int bigNumEnd = bigNum.length() - 1;
        int smallNumEnd = smallNum.length() - 1;

        while (bigNumEnd >= 0) {


            int tmp = carryBit + (bigNum.charAt(bigNumEnd) - '0');

            if (smallNumEnd >= 0) {
                tmp += smallNum.charAt(smallNumEnd) - '0';
                smallNumEnd--;
            }
            bigNumEnd--;

            carryBit = tmp > 9 ? 1 : 0;

            tmp = tmp % 10;

            result.append(tmp);


        }

        if (carryBit == 1) {
            result.append(carryBit);
        }
        return result.reverse().toString();

    }
}
