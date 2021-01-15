import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Scrabble {

    int score = 0;
    private static final Map<Integer, String[]> scoreMap;

    static{
        scoreMap = new HashMap<>();
        String[] one = {"a", "e", "i", "o", "u", "l", "n", "r", "s", "t"};
        String[] two = {"d", "g"};
        String[] three = {"b", "c", "m", "p"};
        String[] four = {"f", "h", "v", "w", "y"};
        String[] five = {"k"};
        String[] eight = {"j", "x"};
        String[] ten = {"q", "z"};
        scoreMap.put(1, one);
        scoreMap.put(2, two);
        scoreMap.put(3, three);
        scoreMap.put(4, four);
        scoreMap.put(5, five);
        scoreMap.put(8, eight);
        scoreMap.put(10, ten);
    }

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

    private int translateScore(String letter) {

        return scoreMap.entrySet().stream().
                filter(e -> (Arrays.asList(e.getValue()).contains(letter))).
                mapToInt(Map.Entry::getKey).max().getAsInt();

    }

    public static boolean contains(final int[] array, final int v) {

        boolean result = false;

        for (int i : array) {
            if (i == v) {
                result = true;
                break;
            }
        }

        return result;
    }

}
