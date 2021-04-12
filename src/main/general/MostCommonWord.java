package general;

import java.util.HashMap;
import java.util.Map;


//1207
public class MostCommonWord {

    public String mostCommonWord(String paragraph, String[] banned) {
        //First clean up string so that there are no lower case, or punctiation, and seperate into words
        String[] justWords = paragraph.toLowerCase().split("[^a-zA-Z]+"); //For some reason * does not work and splits up everything

        //Create freqency map
        HashMap<String, Integer> counts = new HashMap<>();

        for (String word : justWords) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }

        Map.Entry<String, Integer> maxEntry = null;

        //Do ban check when counting frqency -> that way it is really unique words * banned runtime
        for (Map.Entry<String, Integer> count : counts.entrySet()) {


            boolean notBanned = true;
            for (String badWord : banned) {
                if (count.getKey().equals(badWord)) {
                    notBanned = false;
                    break;
                }
            }
            if (maxEntry == null || (notBanned && count.getValue() > maxEntry.getValue())) {
                maxEntry = count;
            }

        }

        return maxEntry.getKey();


}


}
