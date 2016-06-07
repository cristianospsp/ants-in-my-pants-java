package model;

/**
 * Created by Cristiano on 07/06/16.
 */
public class Position {

	private final int line;
	private final int colum;

	public Position(final int line, final int colum) {
		this.line = line;
		this.colum = colum;
	}

	public int getLine() {
		return line;
	}

	public int getColum() {
		return colum;
	}

}
