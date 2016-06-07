package model;

import java.util.Random;

/**
 * Created by Cristiano on 07/06/16.
 */
public class AntBlue extends Ant {

	@Override
	protected Moviment ruleToMoviment(Board board) {
		return getMoviments().get(new Random().nextInt(getMoviments().size()));
	}

	@Override
	public String myFaceWithGrain() {
		return "B";
	}

	@Override
	public String myFaceWithoutGrain() {
		return "b";
	}
}
