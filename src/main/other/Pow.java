package other;

public class Pow {

    public double myPow(double x, int n) {
        if (n == 0){
            return 1;
        }

        if (n == 1){
            return x;
        }


        double result = myPowHelper(x,Math.abs(n));
        if (n < 0){
            return 1/result;
        }
        else{
            return result;
        }

    }


    double myPowHelper(double x, int n){
        //base case
        if (n == 1){
            return x;
        }

        double half = myPowHelper(x,n/2);
        if (n % 2 == 0){
            return half * half;
        }
        else{ //odd
            return half *half * x;
        }

    }
}


