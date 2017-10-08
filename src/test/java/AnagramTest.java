import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class AnagramTest {
    @Test
    public void testIsAnagramTrue() {
        Anagram anagram = new Anagram("abcdef","bcdaef");
        String result = anagram.isAnagram();
        assertEquals("Strings are anagrams",result);
    }

    @Test
    public void testIsAnagramFalse() {
        Anagram anagram = new Anagram("abcdef","aacdfg");
        String result = anagram.isAnagram();
        assertEquals("[b, e]",result);
    }
}
