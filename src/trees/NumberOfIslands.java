package trees;

import java.util.ArrayList;

public class NumberOfIslands {



    public static void main(String args[]){
        char [][] test =  {{'1','1','1'},{'0','1','0'},{'1','1','1'}};
       NumberOfIslands run = new NumberOfIslands();
        System.out.println(run.numIslands(test));
    }
    public class cordinate{
        int m; // y [m]
        int n; // x [][n]
        public cordinate (int m, int n){
            this.m = m;
            this.n = n;
        }


    }
    public int numIslands(char[][] grid) {
        int total = 0;

        for (int m = 0; m < grid.length; m++){
            for (int n = 0; n < grid[m].length; n++){

                if (grid[m][n] == '1'){ //is land which means not seen or water

                    total++;
                    markPartsOfIsland(new cordinate(m, n), grid);
                }
            }
        }

        return total;
    }

    private void markPartsOfIsland(cordinate c, char [][] grid){
        grid[c.m][c.n] = 's'; //mark as seen
        ArrayList <cordinate> landBeside = adjLand(grid, c);
        if (!landBeside.isEmpty()) {
            for (cordinate t : landBeside) {

                if (grid[t.m][t.n] == '1'){ //this check needs to happen here because later recurssive calls might make adjacent land seen
                    markPartsOfIsland(t,grid);
                }

            }
        }

    }

    //return all adjacnted land
    public ArrayList <cordinate> adjLand(char [][] grid, cordinate vertex){
        ArrayList<cordinate> tmp = new ArrayList<>();

        //check top
        if (vertex.m-1 >= 0){
            tmp.add(new cordinate(vertex.m-1,vertex.n));
        }
        //check left
        if (vertex.n-1 >= 0){
            tmp.add(new cordinate(vertex.m,vertex.n-1));
        }
        //cheeck bootom
        if (vertex.m+1 < grid.length){
            tmp.add(new cordinate(vertex.m+1,vertex.n));
        }
        //check right
        if (vertex.n+1 < grid[0].length ){
            tmp.add(new cordinate(vertex.m,vertex.n+1));
        }


        return tmp;



    }
}
