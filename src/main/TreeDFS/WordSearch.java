package TreeDFS;

public class WordSearch {


    //let board[m][n] = board[row][col]
    public boolean exist(char[][] board, String word) {

        //Every element in board could be starting point
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (existHelper(board, word, row, col, 0, new boolean[board.length][board[0].length])) {
                    return true;
                }
            }

        }
        return false;

    }

    private boolean existHelper(char[][] board, String word, int row, int col, int currentConsider, boolean[][] visited) {


        //Check base case -> all selected. We do this after checking if a valid solution in case the board is the same size as the word length
        if (currentConsider >= word.length()) {
            return true;
        }

        //Check if already visited or not part of valid soltion
        if (visited[row][col] || board[row][col] != word.charAt(currentConsider)) {
            return false;
        }

        //Mark as visited (should this be here? Yes it should be )
        visited[row][col] = true;



        currentConsider++;


        //Top
        if (row - 1 >= 0 && existHelper(board, word, row - 1, col, currentConsider , visited)) {
            return true;
        }
        //Bottom
        if (row + 1 < board.length && existHelper(board, word, row + 1, col, currentConsider , visited)) {
            return true;
        }
        //left
        if (col - 1 >= 0 && existHelper(board, word, row, col - 1, currentConsider , visited)) {
            return true;
        }
        //right
        if (col + 1 < board[0].length && existHelper(board, word, row, col + 1, currentConsider , visited)) {
            return true;
        }

        visited[row][col] = false; //need to undo-> need to have actually inlcuded it otherwise its a failure
        //None of the paths return ture
        return false; //none of the child paths delivered true


    }
}
