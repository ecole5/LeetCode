package general;


import java.util.Collections;
import java.util.LinkedList;

public class MeetingRoomsII {

    private class Time implements Comparable<Time>{
        public int time;
        public boolean isStart;

        public Time (int time, boolean isStart){
            this.time = time;
            this.isStart = isStart;
        }


        @Override
        public int compareTo(Time o) {
            if (this.time > o.time){
                return 1;
            }
            else if (this.time < o.time){
                return -1;
            }
            //Do ties work ie (meeting starting at 1 and ends at 4) meeting start at 4 and ends at 5.
            //Need end to come before start -> fix the comprator
            else{
                if (this.isStart == o.isStart){
                    return 0;
                }
                else if (this.isStart){ //tied start and end times need to have start time come after (bigger)
                    return 1;
                }
                else{
                    return -1;
                }
            }
        }
    }

    //Add start and end times to a list
    //Sort
    //For every start add a room and compare with global max
    //For every end remove a room
    public  int minMeetingRooms(int[][] intervals){


        //Add all times to time object, marking if start time and sort them
        LinkedList<Time> times = new LinkedList<>();
        for (int [] t : intervals){
            times.add(new Time(t[0],true));
            times.add(new Time(t[1],false));
        }
        Collections.sort(times);

        //Every time we have another start time we need another room

        int globalMax = 0;
        int localMax = 0;
        for (Time t : times){
            if (t.isStart){
                localMax++;
                globalMax = Math.max(globalMax,localMax);
            }
            else{
                localMax--;
            }
        }

        return globalMax;


    }


}
