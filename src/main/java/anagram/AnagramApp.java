package anagram;

public class AnagramApp {

    public static void main(String[] args) throws Exception {

        if (args.length != 2) {
            throw new Exception("Use: AnagramApp firstString secondString");
        }



        Anagram anagram = new Anagram();
        AnagramResult result = anagram.isAnagram(args[0],args[1]);
        if (result.isAnagram()) {
            System.out.println("Strings are anagrams");
        } else {
            System.out.println(result.getCharToChange());
        }

    }
}
