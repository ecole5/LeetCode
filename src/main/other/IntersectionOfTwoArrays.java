package other;

import java.util.ArrayList;
import java.util.HashMap;

public class IntersectionOfTwoArrays {
    public int[] intersect(int[] nums1, int[] nums2) {

        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer,Integer> counts = new HashMap<>();


        //chose shorter one to minimize space
        int [] shorter = nums1.length < nums2.length ? nums1 : nums2;
        int [] longer = nums1.length >= nums2.length ? nums1: nums2;

        //Create freqency of shorter
        for (int e : shorter){
            counts.put(e, counts.getOrDefault(e,0)+1);
        }

        //Now go through longer and see if we have a match in shorter
        for (int e : longer){
            Integer tmp = counts.get(e);
            if (tmp != null && tmp != 0){
                result.add(e);
                counts.put(e, tmp-1); //could be multiple mathces in shorter.
            }
        }
        int [] res = new int [result.size()];
        for (int i = 0; i < result.size(); i++){
            res[i] = result.get(i);
        }

        return res;
    }

}
