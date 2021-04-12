package general;

import java.util.HashSet;

public class containsDuplicate {
    public boolean containsDuplicate(int[] nums) {

        HashSet<Integer> containsInt = new HashSet<>();
        for (int i : nums){
            if (containsInt.contains(i)){
                return true;
            }
            containsInt.add(i);

        }
        return false;
    }

    }
