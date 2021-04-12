package other;

import java.util.*;

public class MergeIntervals {


    public int[][] merge(int[][] intervals) {

        ArrayList<int[]> resultList = new ArrayList<>();
        Arrays.sort(intervals, (int[] a, int[] b) -> a[0] - b[0]);


        for (int i = 0; i < intervals.length-1; i++){
            int [] x = intervals[i];
            int [] y = intervals[i+1];

            if (y[0] <= x[1]){ //y1 <= x2 they overlap
                intervals[i+1] = new int[]{Math.min(x[0],y[0]),Math.max(x[1],y[1])};
            }
            else{
                resultList.add(x);
            }
        }

        //Postprocessing: merge the last interval
        resultList.add(intervals[intervals.length-1]);


        return resultList.toArray(new int[resultList.size()][]);

    }



}
