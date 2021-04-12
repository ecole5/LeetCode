package general;

import java.util.ArrayList;
import java.util.Arrays;

public class InsertInterval {

    //NlogN time
    //N extra space
    public int[][] insert(int[][] intervals, int[] newInterval) {

        //Add new interval
        //O(n) time
        int[][] withNewIntervals = Arrays.copyOf(intervals, intervals.length + 1);
        withNewIntervals[withNewIntervals.length - 1] = newInterval;


        ArrayList<int[]> results = new ArrayList<>();



        Arrays.sort(withNewIntervals, (int[] a, int[] b) -> Integer.compare(a[0], b[0]));

        //Now merge overlaps
        //end point of A >= start point of B if merge
        //assume a before b by start position
        for (int i = 0; i < withNewIntervals.length-1; i++) { //check second last

            //arrays are refrence types not primitives
            int [] a = withNewIntervals[i];
            int [] b = withNewIntervals[i+1];

            if (a[1] >= b[0]){ //overlap we must merge
                b[0] = a[0]; //because sorted new min is always a
                b[1] = Math.max(a[1],b[1]); //max of two endpoints is merged max
            }
            else{
                //interval is complete add to results
                results.add(a);

            }
        }
        //add last element
        results.add(withNewIntervals[withNewIntervals.length-1]);
        return results.toArray(new int [results.size()][2]);

    }
}
