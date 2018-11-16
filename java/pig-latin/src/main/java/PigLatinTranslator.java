import java.util.Arrays;

public class PigLatinTranslator {

    public static final String AY = "ay";
    private final String VOWELS = "aeiou";

    public String translate(String word) {
        String[] wordSplit =  word.split("");
        String firstLetter = wordSplit[0];
        String firstVowel = Arrays.stream(wordSplit).filter(w -> VOWELS.contains(w)).findFirst().get();
        int indexOfFirstVowel = Arrays.asList(wordSplit).indexOf(firstVowel);
        if (VOWELS.contains(firstLetter)) {
             word = word + AY;
        } else {
            String nonVowels = String.join("", Arrays.copyOfRange(wordSplit, 0, indexOfFirstVowel));
            word = String.join("", Arrays.copyOfRange(wordSplit, indexOfFirstVowel, wordSplit.length)) + nonVowels + AY;
        }
        return word;
    }
}
