package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

/**
 * Created by Cristiano on 07/06/16.
 */
public class Board {

	private String[][] fields;
	private Dimension dimension;
	private List<Ant> players = new ArrayList();
	private int amountGrains;

	public Board(Dimension dimensao) {
		this.dimension = dimensao;
		this.fields = new String[dimensao.getLines()][dimensao.getColumns()];
	}

	public Board(Dimension dimension, List<Ant> players) {
		this.dimension = dimension;
		this.fields = new String[dimension.getLines()][dimension.getColumns()];
		players.forEach(f -> addAntOnBoard(f));
		addGrainsPerPlayers();
	}

	private void addGrainsPerPlayers() {
		int qtd = (this.players.size() == 0 ? 1 : this.players.size()) * 3;
		addGrains(qtd);
	}

	public String[][] getFields() {
		return fields;
	}

	public void addAntOnBoard(Ant formiga) {
		int x = new Random().nextInt(dimension.getLines());
		int y = new Random().nextInt(dimension.getColumns());

		String content = fields[x][y];

		if (content == null) {
			formiga.setPosition(new Position(x, y));
			fields[x][y] = formiga.myFace();
			this.players.add(formiga);
		} else {
			addAntOnBoard(formiga);
		}
	}

	public void show() {
		try {
			int amountPlayers = players.size();
			Optional<String> status = players.stream().map(f -> f.myFace()).reduce((a, b) -> a.concat(" " + b));

			System.out.println("   ");
			System.out.println("Players = [" + amountPlayers + "] | Status = [" + status.orElse("") + "]");
			for (int x = 0; x < fields.length; x++) {
				for (int y = 0; y < fields.length; y++) {
					String conteudo = fields[x][y] == null ? "[ ] " : "[" + fields[x][y] + "] ";
					System.out.print(conteudo);
				}
				System.out.println("");
			}
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("Error unexpected...");
			System.exit(0);
		}
	}


	public void addGrains(int qtd) {
		this.amountGrains = qtd;
		for (int i = 0; i < amountGrains; i++) {
			String s;
			do {
				int line = new Random().nextInt(dimension.getLines());
				int column = new Random().nextInt(dimension.getColumns());

				s = fields[line][column];

				if (s == null) {
					s = "*";
					fields[line][column] = s;
					break;
				}

			}
			while (true);
		}
	}

	public Dimension getDimension() {
		return this.dimension;
	}

	public int getAmountGrains() {
		return this.amountGrains;
	}

	public String getPosition(int line, int colum) {
		return this.fields[line][colum];
	}

	public void refreshItem(Position position, String s) {
		this.fields[position.getLine()][position.getColum()] = s;
	}

	public int getQtdPlayers() {
		return Optional.ofNullable(this.players.size()).orElse(0);
	}

	public void move() {
		this.players.forEach(f -> f.walk(this));
	}

}
