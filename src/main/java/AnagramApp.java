public class AnagramApp {

    public static void main(String[] args) throws Exception {

        if (args.length != 2) {
            throw new Exception("Use: anagram firstString secondString");
        }

        if (args[0].length() != args[1].length()) {
            throw new IllegalArgumentException("Strings must have the same length");
        }

        Anagram anagram = new Anagram(args[0],args[1]);
        System.out.println(anagram.isAnagram());

    }
}
