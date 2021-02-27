package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointtoOrigin {

    //Use a max heap to keep track of biggest element (futhurst away from origin)
    //use custom comparator to compare by uclidain distance
    //Once max heap is full if element is < max delete and add
    //at end pop all elements off heap

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(new pointComparator());

        //Add every point onto heap
        for (int[] point : points){

            if (maxHeap.size() == K) { //cannot be put in beause full

                if ((new pointComparator().compare(point, maxHeap.peek())) > 0) {
                    maxHeap.remove();
                    maxHeap.add(point);
                }

            }
            else{
                maxHeap.add(point);
            }
        }

        int [][] result = new int[K][];
        for (int i = 0; i < K; i++){
            result[i] = maxHeap.remove();
        }
        return result;




    }


    public class pointComparator implements Comparator<int[]>{

        @Override
        public int compare( int[]p1, int[] p2) {
            if (distanceFromOrigin(p1) < distanceFromOrigin(p2)){ //smaller value is 1 to max min heap max heap
                return 1;
            }
            else if (distanceFromOrigin(p1) > distanceFromOrigin(p2)){
                return -1;
            }
            return 0;
        }
    }

    private int distanceFromOrigin(int[] point){
        return point[0]*point[0] + point[1]*point[1];
    }


}
