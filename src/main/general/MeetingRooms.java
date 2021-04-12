package general;

import java.util.Arrays;

public class MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {

        Arrays.sort(intervals,(int []a, int [] b)-> Integer.compare(a[0],b[0]));


        //See if there is a overlap
        for (int i = 0; i < intervals.length-1; i++){

            //a at end >= b at start
            if (intervals[i][1] > intervals[i+1][0]){
                return false;
            }

        }

        return true;

    }
}
