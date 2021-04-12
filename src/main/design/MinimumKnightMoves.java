package design;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;

public class MinimumKnightMoves {

    static class Point {
        Integer x;
        Integer y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x.equals(point.x) && y.equals(point.y);
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    final int[] DELTA_X = {1, 1, 2, 2, -1, -1, -2, -2};
    final int[] DELTA_Y = {2, -2, 1, -1,-2, 2, -1, 1};

    public int minKnightMoves(int x, int y) {

        //Need to check point before adding first does not get done
        if (x == 0 && y == 0) {
            return 0;
        }

        //Mark what we have visited so we dont end up looping, also identifies when we have meet betweent he biderictonal search
        HashMap<Point,Character> seenPoints = new HashMap<>();

        //For BFS
        Deque<Point> nextVistingPointA = new LinkedList<>();
        Deque<Point> nextVistingPointB = new LinkedList<>();

        //Point origin
        Point origin = new Point(0, 0);
        Point destination = new Point(x,y);

        seenPoints.put(origin,'A');
        seenPoints.put(destination,'B');

        //Get the party started
        nextVistingPointA.add(origin);
        nextVistingPointB.add(destination);

        int numberOfMoves = 0;

        while (!nextVistingPointA.isEmpty()) {
            numberOfMoves++;

            if (visitLevel(nextVistingPointA,seenPoints,'A')){
                return numberOfMoves;
            }
            numberOfMoves++;
            if (visitLevel(nextVistingPointB,seenPoints,'B')){
                return numberOfMoves;
            }

        }

        return -1; //although solution gaurunteed compiler does not know this.

    }


    private boolean visitLevel(Deque<Point> nextVistingPoint, HashMap<Point,Character> seenPoints, char identifier) { //true if found
        int sizeOfLevel = nextVistingPoint.size();
        //For every point at level
        for (int l = 0; l < sizeOfLevel; l++) {

            Point lastMove = nextVistingPoint.remove();

            //Add all new points to queue checking first if they are the solution
            for (int i = 0; i < DELTA_X.length; i++) {

                    //generate next point
                    Point nextMove = new Point(lastMove.x + DELTA_X[i], lastMove.y + DELTA_Y[i]);


                    //Have we not seen it before
                    Character temp = seenPoints.get(nextMove);
                    if (temp == null) {
                        nextVistingPoint.add(nextMove); //add to queue
                        seenPoints.put(nextMove,identifier); //mark it as seen, with its identifier
                    }//otherwise if we have seen it,
                    else if (temp != identifier){ //seen by other side of search we have reached intersection
                        return true;
                    }
            }
        }
        return false;
    }
}

