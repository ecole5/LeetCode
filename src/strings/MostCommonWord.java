package strings;

import java.util.Locale;
import java.util.Map;
import java.util.PriorityQueue;

public class MostCommonWord {

    private class Entry implements Comparable<Entry> {

        private String key;
        private int value;





    public String mostCommonWord(String paragraph, String[] banned) {
        PriorityQueue<Entry> maxHeap = new PriorityQueue<>(); //this is a min heap so reverse compare method to make max heap

        String [] words = paragraph.replaceAll("[^a-zA-Z ]", "").toLowerCase().split(" ");

        for (String w : words){
            if (maxHeap.contains())
        }


    }


}
