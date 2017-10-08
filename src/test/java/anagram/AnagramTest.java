package anagram;

import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class AnagramTest {
    @Test
    public void testIsAnagramTrue() {
        Anagram anagram = new Anagram();
        boolean result = anagram.isAnagram("abcdef","bcdaef");
        assertEquals(true,result);
    }

    @Test
    public void testIsAnagramFalse() {
        Anagram anagram = new Anagram();
        anagram.isAnagram("abcdef","aacdfg");
        assertEquals("[b, e]",anagram.getCharToChange());
    }
}
