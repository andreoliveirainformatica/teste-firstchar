package com.netshoes.firstchar.streamreader;

import com.netshoes.firstchar.exception.CharacterNotFoundException;
import org.junit.Test;

public class StreamReaderRunnerTest {

    @Test(expected = CharacterNotFoundException.class)
    public void characterNotFoundTest() {
        StreamReaderRunner.execute("abeabe");
    }

    @Test(expected = RuntimeException.class)
    public void invalidInputTest() {
        StreamReaderRunner.execute(null);
    }

    @Test(expected = CharacterNotFoundException.class)
    public void characterNotFoundWithEmptyStringTest() {
        StreamReaderRunner.execute("");
    }
}