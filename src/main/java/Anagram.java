import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagram {
    private String firstString;
    private String secondString;

    public Anagram(String firstString, String secondString) {
        this.firstString = firstString;
        this.secondString = secondString;
    }

    protected String isAnagram() {
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

        if (result.isEmpty()) {
            return "Strings are anagrams";
        }

        return result.toString();
    }
}
