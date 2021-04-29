package general;


public class ReverseInteger {



        public int reverse(int x) {

            //First thing we need to do is to check if there is going to be an overflow problem
            //Do this by comparing each diget to its max value. This is diffrent for positive in negative which vary by one

            int compareInteger = x >= 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;


            int position = 0;
            int newNumber = 0;

            while (x > 0){
                int remainder = x%10;
                if (remainder <= compareInteger%10){
                    newNumber += remainder * Math.pow(10,position);
                }
                else{
                    return 0;
                }

                //Move to next position
                x /= 10;
                if (remainder != 0){
                    position++;
                }


            }
            return newNumber;


        }


}
