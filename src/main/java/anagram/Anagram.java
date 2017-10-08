package anagram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagram {



    //runtime evaluation O(n)
    //memory evaluation O(n)
    public AnagramResult isAnagram(String firstString, String secondString) {

        if (firstString.length() != secondString.length()) {
            throw new IllegalArgumentException("Strings must have the same length");
        }

        HashMap<Character, Integer> charBalance = new HashMap<>();
        Character charFromFirstString;
        Character charFromSecondString;
        for (int i = 0; i < firstString.length(); i++) {
            charFromFirstString = firstString.charAt(i);
            charFromSecondString = secondString.charAt(i);

            if (charBalance.containsKey(charFromFirstString)) {
                charBalance.put(charFromFirstString, charBalance.get(charFromFirstString) + 1);
            } else {
                charBalance.put(charFromFirstString, 1);
            }

            if (charBalance.containsKey(charFromSecondString)) {
                charBalance.put(charFromSecondString, charBalance.get(charFromSecondString) - 1);
            } else {
                charBalance.put(charFromSecondString, -1);
            }
        }

        List<Character> result = new ArrayList<>();

        for (Map.Entry<Character, Integer> entry : charBalance.entrySet()) {
            if (entry.getValue() > 0){
                for (int i = 0; i < entry.getValue(); i++) {
                    result.add(entry.getKey());
                }
            }
        }

        AnagramResult anagramResult = new AnagramResult();

        if (result.isEmpty()) {
            anagramResult.setAnagram(true);
            return anagramResult;
        }
        anagramResult.setCharToChange(result);
        return anagramResult;
    }
}
