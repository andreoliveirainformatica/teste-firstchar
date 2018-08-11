package com.mytest.firstchar.streamreader;

import com.mytest.firstchar.exception.CharacterNotFoundException;
import org.junit.Test;

import java.security.InvalidParameterException;

public class StreamReaderRunnerTest {

    @Test(expected = CharacterNotFoundException.class)
    public void characterNotFoundTest() {
        StreamReaderRunner.execute("abeabe");
    }

    @Test(expected = InvalidParameterException.class)
    public void invalidInputTest() {
        StreamReaderRunner.execute(null);
    }

    @Test(expected = CharacterNotFoundException.class)
    public void characterNotFoundWithEmptyStringTest() {
        StreamReaderRunner.execute("");
    }
}