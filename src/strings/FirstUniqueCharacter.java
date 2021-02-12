package strings;

public class FirstUniqueCharacter {
    public int firstUniqChar(String s) {
        int [] memo = new int[26];

        for (int i = 0; i < s.length(); i++){
            memo[s.charAt(i)-'a']++;
        }

        for (int i = 0; i < s.length(); i++){
            if (memo[s.charAt(i)-'a'] == 1){
                return i;
            }
        }
        return -1;
    }
}
