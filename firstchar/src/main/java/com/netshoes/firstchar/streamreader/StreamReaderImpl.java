package com.netshoes.firstchar.streamreader;

public class StreamReaderImpl implements StreamReader {

	private String input;
	private int lastGetCharacterIndex = -1;

	public StreamReaderImpl(final String input) {
		this.input = input;
	}

	public char getNext() {
		return input.charAt(++lastGetCharacterIndex);
	}

	public boolean hasNext() {
		return  input.length() > lastGetCharacterIndex + 1;
	}

}
