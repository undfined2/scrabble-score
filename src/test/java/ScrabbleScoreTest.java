import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ScrabbleScoreTest {

    @Test
    public void testALowerCaseLetter() {
        Scrabble scrabble = new Scrabble("a");
        assertEquals(1, scrabble.getScore());
    }

// @Ignore("Remove to run test")
    @Test
    public void testAUpperCaseLetter() {
        Scrabble scrabble = new Scrabble("A");
        assertEquals(1, scrabble.getScore());
    }

// @Ignore("Remove to run test")
    @Test
    public void testAValuableLetter() {
        Scrabble scrabble = new Scrabble("f");
        assertEquals(4, scrabble.getScore());
    }

// @Ignore("Remove to run test")
    @Test
    public void testAShortWord() {
        Scrabble scrabble = new Scrabble("at");
        assertEquals(2, scrabble.getScore());
    }

// @Ignore("Remove to run test")
    @Test
    public void testAShortValuableWord() {
        Scrabble scrabble = new Scrabble("zoo");
        assertEquals(12, scrabble.getScore());
    }

// @Ignore("Remove to run test")
    @Test
    public void testAMediumWord() {
        Scrabble scrabble = new Scrabble("street");
        assertEquals(6, scrabble.getScore());
    }

// @Ignore("Remove to run test")
    @Test
    public void testAMediumValuableWord() {
        Scrabble scrabble = new Scrabble("quirky");
        assertEquals(22, scrabble.getScore());
    }

// @Ignore("Remove to run test")
    @Test
    public void testALongMixCaseWord() {
        Scrabble scrabble = new Scrabble("OxyphenButazone");
        assertEquals(41, scrabble.getScore());
    }

// @Ignore("Remove to run test")
    @Test
    public void testAEnglishLikeWord() {
        Scrabble scrabble = new Scrabble("pinata");
        assertEquals(8, scrabble.getScore());
    }

// @Ignore("Remove to run test")
    @Test
    public void testAnEmptyInput() {
        Scrabble scrabble = new Scrabble("");
        assertEquals(0, scrabble.getScore());
    }

// @Ignore("Remove to run test")
    @Test
    public void testEntireAlphabetAvailable() {
        Scrabble scrabble = new Scrabble("abcdefghijklmnopqrstuvwxyz");
        assertEquals(87, scrabble.getScore());
    }

// @Ignore("Remove to run test")
    @Test
    public void testSingleDoubleWord() {
        Scrabble scrabble = new Scrabble("double", 1, 0);
        assertEquals(18, scrabble.getScore());
    }

// @Ignore("Remove to run test")
    @Test
    public void testTwoDoubleWords() {
        Scrabble scrabble = new Scrabble("double", 2, 0);
        assertEquals(36, scrabble.getScore());
    }

// @Ignore("Remove to run test")
    @Test
    public void testDoubleAndTripleWords() {
        Scrabble scrabble = new Scrabble("double", 1, 1);
        assertEquals(54, scrabble.getScore());
    }

// @Ignore("Remove to run test")
    @Test
    public void testDoubleAndTwoTripleWords() {
        Scrabble scrabble = new Scrabble("double", 1, 2);
        assertEquals(162, scrabble.getScore());
    }

}
