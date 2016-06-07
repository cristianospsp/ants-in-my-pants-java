package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Cristiano on 07/06/16.
 */
public class AntBlack extends Ant {

	@Override
	protected Moviment ruleToMoviment(Board board) {
		List<Moviment> movimentos = getMoviments();
		movimentos.remove(getLastMoviment());
		List<Moviment> movimentosPossiveis = new ArrayList<>(movimentos);
		refreshMoviment(movimentosPossiveis);
		return movimentosPossiveis.size() == 0 ? null : movimentosPossiveis.get(new Random().nextInt(movimentosPossiveis.size()));
	}

	@Override
	public String myFaceWithGrain() {
		return "K";
	}

	@Override
	public String myFaceWithoutGrain() {
		return "k";
	}

}
