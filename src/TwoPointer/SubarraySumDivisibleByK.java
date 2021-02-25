package TwoPointer;

public class SubarraySumDivisibleByK {

    public int subarraysDivByK(int[] A, int K) {

        int [] prefixByModClass = new int[K]; //There can only be 0 to K-1 values with class (mod k)

        int currentSum = 0;
        int totalSublists = 0;

        for (int i : A) {

            //Calculate currentsum
            currentSum += i;

            // Needed prefix sum in class mod k
            // To find mod of negative numbers we cant simply take remainder
            int currentSumMod = mod(currentSum,K);

            //Check case that we dont subtract anything and if true add 1
            int sublistsAtCurrentElement = currentSumMod == 0 ? 1: 0;

            //Now see how many sublists are divisble by looking at how many prefixes have a sum in class mod k congruent to current sum class mod km
            sublistsAtCurrentElement += prefixByModClass[currentSumMod];
            
            
            //Add to total
            totalSublists += sublistsAtCurrentElement;

            //Add this sum as a prefix by mod class
            prefixByModClass[currentSumMod]++;

        }
        return totalSublists; //not found
    }

    public int mod (int a, int b){
        int c = a % b;
        return c >= 0 ? c: c +b;

    }


}

