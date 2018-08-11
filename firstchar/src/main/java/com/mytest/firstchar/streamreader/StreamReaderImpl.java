package com.mytest.firstchar.streamreader;

public class StreamReaderImpl implements StreamReader {

	private String input;
	private int lastGetCharacterIndex = 0;

	public StreamReaderImpl(final String input) {
		this.input = input;
	}

	public char getNext() {
		return input.charAt(lastGetCharacterIndex++);
	}

	public boolean hasNext() {
		return  input.length() > lastGetCharacterIndex;
	}

}
