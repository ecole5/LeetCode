package dp;

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {



        //Create array to hold solutions to subproblems
        int [] minCoins = new int[amount+1];
        Arrays.fill(minCoins, amount+1);
        minCoins[0] = 0; //solve the first subproblem. The reacurrance needs to be based on old suproblems


        //For every subproblem after zero
        for (int i = 1; i < minCoins.length; i++){

                //make a choice
                for (int chosenCoin : coins) {
                    if (chosenCoin <= i) {
                        minCoins[i] = Math.min(minCoins[i - chosenCoin] + 1, minCoins[i]); //make a choice up the tree -> use already solved suproblem to find total result
                    }
                }
            }


        return minCoins[minCoins.length-1] == amount+1 ? -1 : minCoins[minCoins.length-1]; //determain if final problem has default value or not. Dont sue max int because of overflow issues

    }

}
