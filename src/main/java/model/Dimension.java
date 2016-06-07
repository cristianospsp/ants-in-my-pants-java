package model;

/**
 * Created by Cristiano on 07/06/16.
 */
public class Dimension {

	private final int lines;
	private final int columns;

	public Dimension(final int linhas, final int colunas) {
		this.lines = linhas;
		this.columns = colunas;
	}

	public int getLines() {
		return lines;
	}

	public int getColumns() {
		return columns;
	}
}
