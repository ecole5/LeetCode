package graph;

public class FloodFill {

    //Matrix of rows columns
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        int  oldColor = image[sr][sc];
        if (oldColor != newColor) { //without this you can get stuck in loop
            dfsFloodFillHelper(image, sr, sc,oldColor, newColor);
        }

        return image;

    }


    private void dfsFloodFillHelper(int [][] image, int curRow, int curCol, int originalColor, int newColor) {

        //Mark current pixel with new color
        image[curRow][curCol] = newColor;


        //Neighbor must be left,top,bottom,righ and have old color. If marked new color already seen.


        //Top neighbor
        if (curRow -1 >= 0 && image[curRow-1][curCol] == originalColor){
            dfsFloodFillHelper(image,curRow-1, curCol, originalColor,newColor); //recussivly explore
        }

        //Bottom neighor
        if (curRow + 1 < image.length && image[curRow+1][curCol] == originalColor){
            dfsFloodFillHelper(image,curRow+1, curCol, originalColor,newColor);
        }

        //Left Neighor
        if (curCol - 1 >= 0 && image[curRow][curCol-1] == originalColor){
            dfsFloodFillHelper(image,curRow, curCol-1, originalColor,newColor);
        }

        //Right Neighbor

        if (curCol + 1 < image[0].length  && image[curRow][curCol+1] == originalColor){
            dfsFloodFillHelper(image,curRow, curCol+1, originalColor,newColor);
        }
    }







}
