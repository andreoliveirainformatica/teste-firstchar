package com.netshoes.firstchar.streamreader;


import com.netshoes.firstchar.exception.CharacterNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StreamReaderRunner {

    private static final String VOWELS_REGEX = "(?i)[aáàãâÁÀÃÂeéêÉÊiíÍoóõôÓÕÔuúÚ]";
    private static final String CONSONANTS_REGEX = "[bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ]";

    public static Character execute(final String input) {

        if (Objects.isNull(input)) {
            throw new RuntimeException("Invalid String");
        }

        List<Character> vowels = new ArrayList<>();
        List<Character> findChars = new ArrayList<>();
        Character[] predecessor = new Character[2];

        final StreamReader streamReader = new StreamReaderImpl(input);
        while (streamReader.hasNext()) {
            final Character actual = streamReader.getNext();
            if (isVowel(actual)) {
                if (!vowels.contains(actual)) {
                    vowels.add(actual);
                    if (validatePredecessor(predecessor)) {
                        findChars.add(actual);
                    }
                } else {
                    findChars.remove(actual);
                }
            }
            computePredecessors(predecessor, actual);
        }

        return vowels
                .stream()
                .filter(findChars::contains)
                .findFirst()
                .orElseThrow(() -> new CharacterNotFoundException("No character found"));

    }

    private static boolean validatePredecessor(Character[] predecessor) {
        return isVowel(predecessor[0]) && isConsonant(predecessor[1]);
    }

    private static boolean isVowel(Character character) {
        return String.valueOf(character).matches(VOWELS_REGEX);
    }

    private static boolean isConsonant(Character character) {
        return String.valueOf(character).matches(CONSONANTS_REGEX);
    }

    private static void computePredecessors(Character[] predecessor, Character actual) {
        predecessor[0] = predecessor[1];
        predecessor[1] = actual;
    }

}
