package anagram;

import java.util.List;

public class AnagramResult {
    private boolean isAnagram;
    private List<Character> charToChange;

    public boolean isAnagram() {
        return isAnagram;
    }

    public void setAnagram(boolean anagram) {
        isAnagram = anagram;
    }

    public List<Character> getCharToChange() {
        return charToChange;
    }

    public void setCharToChange(List<Character> charToChange) {
        this.charToChange = charToChange;
    }
}
