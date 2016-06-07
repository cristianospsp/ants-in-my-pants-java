package model;

/**
 * Created by Cristiano on 07/06/16.
 */
public class Right extends Moviment {

	@Override
	public void defineName() {
		myName = "Right";
	}

	@Override
	public void go(Board board, Ant ant) {
		Position novaPosicao = new Position(ant.getPosition().getLine(), ant.getPosition().getColum()+1);
		board.getFields()[ant.getPosition().getLine()][ant.getPosition().getColum()] = null;
		board.getFields()[novaPosicao.getLine()][novaPosicao.getColum()] = ant.myFace();
		ant.setPosition(novaPosicao);
	}

	@Override
	public Position getNextFiled(Board board, Ant ant) {
		return new Position(ant.getPosition().getLine(), ant.getPosition().getColum()+1);
	}

}
