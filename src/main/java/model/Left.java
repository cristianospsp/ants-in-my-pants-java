package model;

/**
 * Created by Cristiano on 07/06/16.
 */
public class Left extends Moviment {

	@Override
	public void go(Board board, Ant ant) {
		Position novaPosicao = new Position(ant.getPosition().getLine(), ant.getPosition().getColum() - 1);
		board.getFields()[ant.getPosition().getLine()][ant.getPosition().getColum()] = null;
		board.getFields()[novaPosicao.getLine()][novaPosicao.getColum()] = ant.myFace();
		ant.setPosition(novaPosicao);
	}

	@Override
	public Position getNextFiled(Board board, Ant formigaant) {
		return new Position(formigaant.getPosition().getLine(), formigaant.getPosition().getColum() - 1);
	}

	@Override
	public void defineName() {
		myName = "Left";
	}

}
