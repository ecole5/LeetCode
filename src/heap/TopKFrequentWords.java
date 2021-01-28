package heap;


import java.util.*;



public class TopKFrequentWords {

    public class sortByFreqency implements Comparator<Map.Entry<String,Integer>>{

        //We need a custom comparator
        @Override
        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
            //01 < o2
            if (o1.getValue() < o2.getValue()){
                return -1;
            }
            else if (o1.getValue() > o2.getValue()){
                return 1;
            }
            else{ //equal freqency return alphbeticla roder
                return o1.getKey().compareTo(o2.getKey())*-1; //compare to returns -1 if object is lexographiclaly before argument, but in this case before means bigger not smaller

            }





























        }
    }

    public List<String> topKFrequent(String[] words, int k) {

        //First build a hashmap of the words to find out how big they are (how freqent)
        HashMap<String,Integer> map = new HashMap<>();
        for (String s : words){
            if (map.containsKey(s)){
                map.put(s, map.get(s)+1);
            }
            else{
                map.put(s,1);
            }
        }



        //heaps in java use the priority queue
//Priority queues are min heaps and allows custom comparator
//Priority queue can be used to keep track of k smallest objects
        PriorityQueue<Map.Entry<String,Integer>> heap = new PriorityQueue<>(k,new sortByFreqency());

        for (var m : map.entrySet()){
            heap.add(m);
            if (heap.size() > k){
                heap.poll();
            }
        }

        LinkedList<String> results = new LinkedList<>();

        //No remove items from heap
        while(heap.size() != 0) {
            results.add(heap.poll().getKey());
        }

        //We want values in max to min. becuase it is min heap we need to reverse
        Collections.reverse(results);
        return results;

    }
}
