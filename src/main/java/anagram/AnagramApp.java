package anagram;

public class AnagramApp {

    public static void main(String[] args) throws Exception {

        if (args.length != 2) {
            throw new Exception("Use: AnagramApp firstString secondString");
        }

        if (args[0].length() != args[1].length()) {
            throw new IllegalArgumentException("Strings must have the same length");
        }

        Anagram anagram = new Anagram();
        if (anagram.isAnagram(args[0],args[1])) {
            System.out.println("Strings are anagrams");
        } else {
            System.out.println(anagram.getCharToChange());
        }

    }
}
