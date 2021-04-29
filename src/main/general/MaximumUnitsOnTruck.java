package general;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumUnitsOnTruck {


    public int maximumUnits(int[][] boxTypes, int truckSize) {

        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]); //sort by number of items decending


        int toatalUnits = 0;
        int currentBoxType = 0;
        while (truckSize != 0 && currentBoxType < boxTypes.length) {
            int numberBoxesOfType = Math.min(truckSize, boxTypes[currentBoxType][0]);
            truckSize = truckSize - numberBoxesOfType;

            toatalUnits += numberBoxesOfType * boxTypes[currentBoxType][1];
            currentBoxType++;
        }
        return toatalUnits;

    }
}
