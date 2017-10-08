package anagram;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class AnagramTest {
    @Test
    public void testIsAnagramTrue() {
        Anagram anagram = new Anagram();
        AnagramResult result = anagram.isAnagram("abcdef","bcdaef");
        assertEquals(true,result.isAnagram());
        assertEquals(null,result.getCharToChange());
    }

    @Test
    public void testIsAnagramFalse() {
        Anagram anagram = new Anagram();
        AnagramResult result = anagram.isAnagram("abcdef","aacdfg");
        List<Character> expectedResult = new ArrayList<>();
        expectedResult.add('b');
        expectedResult.add('e');
        assertEquals(expectedResult,result.getCharToChange());
        assertEquals(false,result.isAnagram());
    }
}
