import java.util.*;

class Solution {
    public int numberOfSpecialChars(String word) {

        HashMap<Character, Integer> lowerLast = new HashMap<>();
        HashMap<Character, Integer> upperFirst = new HashMap<>();

        // store positions
        for(int i = 0; i < word.length(); i++) {

            char ch = word.charAt(i);

            // lowercase
            if(Character.isLowerCase(ch)) {
                lowerLast.put(ch, i);
            }

            // uppercase
            else {
                char lower = Character.toLowerCase(ch);

                // store first uppercase occurrence only
                upperFirst.putIfAbsent(lower, i);
            }
        }

        int count = 0;

        // check a-z
        for(char ch = 'a'; ch <= 'z'; ch++) {

            if(lowerLast.containsKey(ch) &&
               upperFirst.containsKey(ch) &&
               lowerLast.get(ch) < upperFirst.get(ch)) {

                count++;
            }
        }

        return count;
    }
}