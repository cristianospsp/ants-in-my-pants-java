package model;

/**
 * Created by Cristiano on 07/06/16.
 */
public class Down extends Moviment {

	@Override
	public void go(Board board, Ant ant) {
		Position novaPosicao = new Position(ant.getPosition().getLine() + 1, ant.getPosition().getColum());
		board.getFields()[ant.getPosition().getLine()][ant.getPosition().getColum()] = null;
		board.getFields()[novaPosicao.getLine()][novaPosicao.getColum()] = ant.myFace();
		ant.setPosition(novaPosicao);
	}

	@Override
	public Position getNextFiled(Board board, Ant ant) {
		return new Position(ant.getPosition().getLine() + 1, ant.getPosition().getColum());
	}

	@Override
	public void defineName() {
		myName = "Down";
	}

}
