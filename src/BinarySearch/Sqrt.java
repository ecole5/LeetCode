package BinarySearch;

public class Sqrt {
    public int mySqrt(int x) {
        int start = 0;
        int end = x;

        int bCan = -1;

        while (start <= end){
            int mid = start + ((end-start)/2);

            if ((long)mid*mid <= x){

                bCan = mid;
                start = mid+1;
            }

            else{
                end = mid-1;
            }
        }
        return bCan;

    }
}
