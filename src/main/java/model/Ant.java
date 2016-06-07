package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Cristiano on 07/06/16.
 */
public abstract class Ant {

	private boolean charge = false;
	private Position position;
	private Board board;
	private List<Moviment> moviments = new ArrayList<>();
	private Moviment lastMoviment;

	public boolean isCharge() {
		return charge;
	}

	public List<Moviment> getMoviments() {
		return moviments;
	}

	public Position getPosition() {
		return position;
	}

	public String myFace() {
		return isCharge() ? myFaceWithGrain() : myFaceWithoutGrain();
	}

	public void setPosition(Position position) {
		this.position = new Position(position.getLine(), position.getColum());
	}

	public void walk(Board board) {
		if (basicsMovimentsOK(board)) {
			Moviment m = ruleToMoviment(board);
			if (m != null) {
				takeGrain(m, board);
				m.go(board, this);
				takeOffGrainOnBoard(board);
				board.show();
				keepOnLastMoviment(m);
			}
		}
	}

	private void keepOnLastMoviment(Moviment moviment) {
		this.lastMoviment = moviment;
	}

	public void refreshMoviment(List<Moviment> newsMoviments) {
		this.moviments = new ArrayList<>(newsMoviments);
	}

	protected void takeGrain(Moviment moviment, Board board) {
		Position nextFiled = moviment.getNextFiled(board, this);
		String position = board.getPosition(nextFiled.getLine(), nextFiled.getColum());
		if (position != null && (position.equalsIgnoreCase("*") && !isCharge())) {
			this.charge = true;
		}
	}

	private void takeOffGrainOnBoard(Board board) {
		String[][] f = board.getFields();
		String filedUP = position.getLine() >= 1 ? f[(position.getLine() - 1)][position.getColum()] : "";
		String fieldDown = position.getLine() < (board.getDimension().getLines() - 1) ? f[(position.getLine() + 1)][position.getColum()] : "";
		String fieldLeft = position.getColum() >= 1 ? f[position.getLine()][(position.getColum() - 1)] : "";
		String fieldRight = position.getColum() < (board.getDimension().getColumns() - 1) ? f[position.getLine()][(position.getColum() + 1)] : "";

		long count = Arrays.asList(
			 Optional.ofNullable(fieldDown).orElse(""),
			 Optional.ofNullable(filedUP).orElse(""),
			 Optional.ofNullable(fieldRight).orElse(""),
			 Optional.ofNullable(fieldLeft).orElse(""))
			 .stream()
			 .filter(c -> c.equalsIgnoreCase("*"))
			 .count();

		if (count > 1 && isCharge()) {
			this.charge = false;
			board.addGrains(1);
			board.refreshItem(getPosition(), myFace());
		}

	}

	protected boolean basicsMovimentsOK(Board board) {
		this.board = board;
		basicsMovimentsOnBoard();
		basicsMovimentsOnFreeFieldsOrWithGrain();
		return moviments.size() > 0;
	}

	protected void basicsMovimentsOnFreeFieldsOrWithGrain() {
		moviments = moviments
			 .stream()
			 .filter(m -> canIGoToNextField(m))
			 .collect(Collectors.toList());
	}

	private boolean canIGoToNextField(Moviment m) {
		Position nextFiled = m.getNextFiled(board, this);
		if (!fieldInLimitOdBoard(nextFiled)) {
			return false;
		}
		String contentNextField = board.getFields()[nextFiled.getLine()][nextFiled.getColum()];
		boolean result =
			 (contentNextField == null || contentNextField.isEmpty()) ||
					(contentNextField.equalsIgnoreCase("*") && !isCharge());

		return result;
	}

	private boolean fieldInLimitOdBoard(Position p) {
		Dimension dimension = board.getDimension();
		boolean lines = (p.getLine() >= 0) && (p.getLine() < (dimension.getLines()));
		boolean columns = (p.getColum() >= 0) && (p.getColum() < dimension.getColumns());
		return (lines && columns);
	}

	protected void basicsMovimentsOnBoard() {
		moviments = new ArrayList<>();
		if ((position.getLine() < (position.getLine() + 1))) moviments.add(new Down());
		if (position.getLine() > 0) moviments.add(new Up());
		if (position.getColum() > 0) moviments.add(new Left());
		if (position.getColum() < (position.getColum() + 1)) moviments.add(new Right());
	}

	protected abstract Moviment ruleToMoviment(Board board);

	public abstract String myFaceWithGrain();

	public abstract String myFaceWithoutGrain();

	public void setarCarga(boolean b) {
		this.charge = b;
	}

	public Moviment getLastMoviment() {
		return lastMoviment;
	}

}
