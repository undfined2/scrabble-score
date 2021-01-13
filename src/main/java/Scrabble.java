import java.security.InvalidParameterException;
import java.util.Arrays;

class Scrabble {

    int score = 0;

    static final String[] TWO = {"d", "g"};
    static final String[] THREE = {"b", "c", "m", "p"};
    static final String[] FOUR = {"f", "h", "v", "w", "y"};
    static final String[] FIVE = {"k"};
    static final String[] EIGHT = {"j", "x"};
    static final String[] TEN = {"q", "z"};

    Scrabble(String word) {
        tallyScoreFromWord(word);
    }

    Scrabble(String word, int doubleWordTokens, int tripleWordTokens) {
        tallyScoreFromWord(word);
        applyMultipleWordScore(doubleWordTokens, tripleWordTokens);
    }

    Scrabble(String word, int doubleWordTokens, int tripleWordTokens,
             int[] doubleLetterPositions, int[] tripleLetterPositions) throws InvalidParameterException {
        checkLetterSquaresDoNotMatch(doubleLetterPositions,tripleLetterPositions);
        tallyScoreFromWord(word, doubleLetterPositions, tripleLetterPositions);
        applyMultipleWordScore(doubleWordTokens, tripleWordTokens);

    }

    int getScore() {
       return score;

    }

    private void tallyScoreFromWord(String word) {
        score = word.toLowerCase().codePoints().
                mapToObj(c -> String.valueOf((char) c)).
                mapToInt(this::translateScore).sum();
    }

    private void tallyScoreFromWord(String word, int[] doubleLetterPositions, int[] tripleLetterPositions) {

        for (int i = 0; i < word.length(); i++) {

            int multiplier = 1;

            if (contains(doubleLetterPositions, i)) {
                multiplier = 2;
            } else if (contains(tripleLetterPositions, i)) {
                multiplier = 3;
            }
        score = score + (translateScore((String.valueOf(word.charAt(i)))) * multiplier);

        }

    }

    private int translateScore(String letter) {

        if (Arrays.asList(TWO).contains(letter)) return 2;
        if (Arrays.asList(THREE).contains(letter)) return 3;
        if (Arrays.asList(FOUR).contains(letter)) return 4;
        if (Arrays.asList(FIVE).contains(letter)) return 5;
        if (Arrays.asList(EIGHT).contains(letter)) return 8;
        if (Arrays.asList(TEN).contains(letter)) return 10;
        return 1;
    }

    private void applyMultipleWordScore(int doubleWordTokens, int tripleWordTokens) {
        if (doubleWordTokens > 0)
            score = score * ((int) Math.pow(2, doubleWordTokens));
        if (tripleWordTokens > 0)
            score = score * ((int) Math.pow(3, tripleWordTokens));
    }

    private void checkLetterSquaresDoNotMatch(int[] doubleLetterPositions, int[] tripleLetterPositions) {

        for (int position: doubleLetterPositions
        ) {
            if (contains(tripleLetterPositions, position)) {
                throw new InvalidParameterException("Double Letter Square cannot be at same position as " +
                        "Triple Letter Square");
            }
        }
    }

    public static boolean contains(final int[] array, final int v) {

        boolean result = false;

        for(int i : array){
            if(i == v){
                result = true;
                break;
            }
        }

        return result;
    }

}
