package model;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by Cristiano on 07/06/16.
 */
public class AntGreen extends Ant {

	@Override
	protected Moviment ruleToMoviment(Board tabuleiro) {
		if (isCharge()) {
			return getMoviments().get(new Random().nextInt(getMoviments().size()));
		} else {
			List<Moviment> movimentsPossibles = getMoviments()
				 .stream()
				 .filter(m ->
				 {
					 Position nextFiled = m.getNextFiled(tabuleiro, this);
					 String s = Optional.ofNullable(tabuleiro.getPosition(nextFiled.getLine(), nextFiled.getColum())).orElse("");
					 return s.equalsIgnoreCase("*");
				 })
				 .collect(Collectors.toList());
			refreshMoviment(movimentsPossibles);
			return movimentsPossibles.size() == 0 ? null : movimentsPossibles.get(new Random().nextInt(movimentsPossibles.size()));
		}
	}

	@Override
	public String myFaceWithGrain() {
		return "G";
	}

	@Override
	public String myFaceWithoutGrain() {
		return "g";
	}


}
