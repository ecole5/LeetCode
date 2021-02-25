package other;

import java.util.ArrayList;

public class MergeIntervals {

    public static void main(String args[]){
        MergeIntervals run = new MergeIntervals();
        int[][] tmp = {{1,3},{2,6},{8,10},{15,18}};
        run.merge(tmp);
    }
    public int[][] merge(int[][] intervals) {
        ArrayList <int[]> result = new ArrayList<>();

        for (int i = 0; i < intervals.length-1; i++){
            int startA = intervals[i][0];
            int endA = intervals[i][1];
            int startB = intervals[i+1][0];
            int endB = intervals[i+1][1];
          if (startA <= startB && endA >= startB){
              merge(i+1, intervals, startA, Math.max(endA,endB));
          }
          else if (startA > startB && endB >= startA){
              merge(i+1, intervals, startB, Math.max(endA,endB));
          }
          else{
              result.add(intervals[i]);
          }
        }
        result.add(intervals[intervals.length-1]);
        int[][] tmp = new int[result.size()][2];
        int i = 0;
        for (int[] t : result){
            tmp[i++] = t;
        }
        return tmp;
    }

    private void merge (int indexOfB, int[][] intervals, int start, int end){
        //Copy merge to B position
        intervals[indexOfB][0] = start;
        intervals[indexOfB][1] = end;
    }


}
