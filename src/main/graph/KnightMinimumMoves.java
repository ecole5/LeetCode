package graph;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

public class KnightMinimumMoves {

    class Point{
        int x;
        int y;

        public Point (int x,int y){
            this.x = x;
            this.y = y;
        }

    }


    public int minKnightMoves(int x, int y) {


        //Mark what we have visited so we dont end up looping
        HashSet<Point> seenPoints = new HashSet<>();

        //For BFS
        Deque<Point> nextVistingPoint = new LinkedList<>();

        //Get the party started
        //Need to check point before adding first does not get done
        if (x == 0 && y == 0){
            return 0;
        }
        nextVistingPoint.add(new Point(0,0));
        int numberOfMoves = 0;

        //For right side moves, multiply by -1 to get left side
        final int [] DELTA_X = {1, 1, 2, 2};
        final int [] DELTA_Y = {2, -2, 1, -1};


        while (!nextVistingPoint.isEmpty()){
            numberOfMoves++;
            int sizeOfLevel = nextVistingPoint.size();

            //For every point at level
            for (int l = 0; l < sizeOfLevel; l++) {

                Point lastMove = nextVistingPoint.remove();




                //Add all new points to queue checking first if they are the solution
                for (int sign = -1; sign <= 1; sign = sign+2) { //should run twice at -1 and 1
                    for (int e = 0; e < DELTA_X.length; e++) { //should run four times

                        //generate next point
                        Point nextMove = new Point(lastMove.x+(DELTA_X[e]*sign), lastMove.y+(DELTA_Y[e]*sign));

                        //Is this the solution?
                        if (nextMove.x == x && nextMove.y == y){
                            return numberOfMoves;
                        }
                        //Have we not seen it before
                        if (!seenPoints.contains(nextMove)){
                            seenPoints.add(nextMove); //mark it as seen
                            nextVistingPoint.add(nextMove); //add to queue
                        } //otherwise we do nothing

                    }
                }
            }

        }

        return -1; //although solution gaurunteed compiler does not know this.

    }
}
