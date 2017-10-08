import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagram {

    public static void main(String[] args) throws Exception {

        if (args.length != 2) {
            throw new Exception("Use: anagram firstString secondString");
        }

        if (args[0].length() != args[1].length()) {
            throw new IllegalArgumentException();
        }

        System.out.println(isAnagram(args[0],args[1]));

    }

    private static String isAnagram(String firstString, String secondString) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        Character characterFromFirstString;
        Character characterFromSecondString;
        for (int i = 0; i < firstString.length(); i++) {
            characterFromFirstString = firstString.charAt(i);
            characterFromSecondString = secondString.charAt(i);

            if (map.containsKey(characterFromFirstString)) {
                map.put(characterFromFirstString, map.get(characterFromFirstString) + 1);
            } else {
                map.put(characterFromFirstString, 1);
            }

            if (map.containsKey(characterFromSecondString)) {
                map.put(characterFromSecondString, map.get(characterFromSecondString) - 1);
            } else {
                map.put(characterFromSecondString, -1);
            }
        }

        List<Character> result = new ArrayList<Character>();

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
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
