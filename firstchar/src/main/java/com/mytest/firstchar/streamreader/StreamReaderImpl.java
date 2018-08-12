package com.mytest.firstchar.streamreader;

public class StreamReaderImpl implements StreamReader {

	private String input;
	private int nextGetCharacterIndex = 0;

	public StreamReaderImpl(final String input) {
		this.input = input;
	}

	public char getNext() {
		return input.charAt(nextGetCharacterIndex++);
	}

	public boolean hasNext() {
		return  input.length() > nextGetCharacterIndex;
	}

}
