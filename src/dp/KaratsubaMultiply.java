package dp;

public class KaratsubaMultiply {
    public double karatsuba (double A, double B){

        //Check for base case
        if (A < 10){
            return A * B;
        }

        //Split up string into four
        int length = Double.toString(A).length();
        double a = Double.parseDouble(Double.toString(A).substring(0,length));
        double b = Double.parseDouble(Double.toString(A).substring(length/2,length));
        double c = Double.parseDouble(Double.toString(B).substring(0,length/2));
        double d = Double.parseDouble(Double.toString(B).substring(length/2,length));


        //Follow steps to solve
        double AC = karatsuba(a,c);
        double BD = karatsuba(b,d);
        double ALL = karatsuba(a+b,c+d);
        double ADBC = ALL -AC -BD;

        return ((AC * Math.pow(10,length)) + BD + (ADBC * Math.pow(10,length/2)));
    }
}
