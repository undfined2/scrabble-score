import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.security.InvalidParameterException;

import static org.junit.Assert.assertEquals;

public class ScrabbleScoreTest {

    // int array fixtures for double and triple letter squares
    int[] noChar = {};
    int[] firstChar = {0};
    int[] secondChar = {1};
    int[] thirdChar = {2};
    int[] fifthChar = {4};
    int[] firstAndThirdChar = {0,2};
    int[] thirdAndEighthChar = {2,7};


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

// @Ignore("Remove to run test")
    @Test
    public void testOneDoubleLetter() {
        Scrabble scrabble = new Scrabble("a", 0, 0,
                firstChar, noChar);
        assertEquals(2, scrabble.getScore());
    }

// @Ignore("Remove to run test")
    @Test
    public void testTwoDoubleLetters() {
        Scrabble scrabble = new Scrabble("and", 0, 0,
                firstAndThirdChar, noChar);
        assertEquals(7, scrabble.getScore());
    }

// @Ignore("Remove to run test")
    @Test
    public void testOneTripleLetter() {
        Scrabble scrabble = new Scrabble("zo", 0, 0,
                noChar, firstChar);
        assertEquals(31, scrabble.getScore());
    }

// @Ignore("Remove to run test")
    @Test
    public void testDoubleAndTripleLetter() {
        Scrabble scrabble = new Scrabble("big", 0, 0,
                firstChar, thirdChar);
        assertEquals(13, scrabble.getScore());
    }

// @Ignore("Remove to run test")
    @Test
    public void testDoubleLetterWithDoubleWord() {
        Scrabble scrabble = new Scrabble("pucker", 1, 0,
                firstChar, noChar);
        assertEquals(34, scrabble.getScore());
    }

// @Ignore("Remove to run test")
    @Test
    public void testDoubleAndTripleLetterWithDoubleWord() {
        Scrabble scrabble = new Scrabble("fuzziest", 1, 0,
                firstChar, fifthChar);
        assertEquals(70, scrabble.getScore());
    }

// @Ignore("Remove to run test")
    @Test
    public void testDoubleLetterTripleTripleWord() {
        Scrabble scrabble = new Scrabble("fuzziest", 0, 2,
                thirdChar, noChar);
        assertEquals(351, scrabble.getScore());
    }

// @Ignore("Remove to run test")
    @Test
    public void testDoubleLetterTripleLetterDoubleWordTripleWord() {
        Scrabble scrabble = new Scrabble("everything", 1, 1,
                fifthChar, secondChar);
        assertEquals(192, scrabble.getScore());
    }

// @Ignore("Remove to run test")
    @Test (expected = InvalidParameterException.class)
    public void testSameDoubleAsTripleLetterThrowsException(
    ) {
        Scrabble scrabble = new Scrabble("planetary", 0, 0,
                firstAndThirdChar, thirdAndEighthChar);
    }

}
