package com.mytest.firstchar.streamreader;

import org.junit.Assert;
import org.junit.Test;

public class StreamReaderImplTest {

    @Test
    public void hasNextTest() {
        String input = "123456789";

        final StreamReaderImpl streamReader = new StreamReaderImpl(input);
        int index = 0;
        while (streamReader.hasNext()) {
            streamReader.getNext();
            index++;
        }
        Assert.assertEquals(index, input.length());
    }

    @Test(expected = StringIndexOutOfBoundsException.class)
    public void getWithoutHasNext() {
        final StreamReaderImpl streamReader = new StreamReaderImpl("");
        streamReader.getNext();
    }

    @Test
    public void hasNextWithStringEmptyInputTest() {
        final StreamReaderImpl streamReader = new StreamReaderImpl("");
        Assert.assertTrue(!streamReader.hasNext());
    }

}