package general;


public class rotateImage {

    public void rotate(int[][] matrix) {

        final int N = matrix.length;
        final int END = N-1;

        for (int layer = 0; layer < (N / 2) + 1; layer++) {
            for (int offset = 0; offset < N - 1; offset++) { //will run N -1 times

                int top = matrix[layer][layer + offset]; //top row is constant
                matrix[layer][layer + offset] = matrix[END - offset - layer][layer];//left column is constant
                matrix[END - offset - layer][layer] = matrix[END - layer][END - layer - offset];  //bottom row is constant
                matrix[END - layer][END - layer - offset] = matrix[offset + layer][END - layer]; //right column is consntat
                matrix[offset + layer][END - layer] = top;

            }
        }


    }
}



