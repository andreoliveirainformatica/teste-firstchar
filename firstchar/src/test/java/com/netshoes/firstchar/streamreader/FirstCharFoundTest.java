package com.netshoes.firstchar.streamreader;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class FirstCharFoundTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        final Object[][] data = {
                {"abe", 'e'},  //found char 'e'
                {"abeabeabo", 'o'},//found 'e' but e repeat
                {"bboabi", 'i'}, // found 'o' but predecessors are two consonants
                {"aaoabi", 'i'}, // found 'o' but predecessors are two vowels
                {"abeaboabe", 'o'}, // found e first, but e repeat
                {"aAbBABacafe", 'e'}, // input stream for test

        };
        return Arrays.asList(data);
    }

    private final String inputStream;

    private final Character characterFound;

    public FirstCharFoundTest(final String inputStream, final Character characterFound) {
        this.inputStream = inputStream;
        this.characterFound = characterFound;
    }

    @Test
    public void firstCharTest() {
       Assert.assertEquals(StreamReaderRunner.execute(inputStream), characterFound);
    }
}