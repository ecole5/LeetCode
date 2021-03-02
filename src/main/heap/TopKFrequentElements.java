package heap;

import java.util.*;

public class TopKFrequentElements {






    public int[] topKFrequent(int[] nums, int k) {


        PriorityQueue<Map.Entry<Integer,Integer>> minHeap = new PriorityQueue<>(new CompareByValue()); //record top k, sort by entry.value
        HashMap<Integer,Integer> freqencyTable = new HashMap<>(); //record freqency and map to value

        //Count freqency
        for (int num : nums){
            int temp = freqencyTable.getOrDefault(num,-1);
            freqencyTable.put(num,++temp);
        }

        //Add to heap
        for (Map.Entry<Integer,Integer> entry : freqencyTable.entrySet()){
            if (minHeap.size() == k) { //if it is already full
                if (entry.getValue() > minHeap.peek().getValue()) {//bigger than smallest element
                    minHeap.remove();
                    minHeap.add(entry);
                }
            }
            else{
                minHeap.add(entry);
            }
        }


        int [] result  = new int[k];
        for (int i = 0; i < k; i++){
            result[i] = minHeap.remove().getKey();
        }
        return result;

    }

    private static class CompareByValue implements Comparator<Map.Entry<Integer,Integer>>{

        @Override
        public int compare(Map.Entry<Integer,Integer> o1, Map.Entry<Integer,Integer> o2) {

            if (o1.getValue() < o2.getValue()){
                return -1;
            }
            else if (o1.getValue() > o2.getValue()){
                return 1;
            }
            else{
                return 0;
            }
        }
    }


}
