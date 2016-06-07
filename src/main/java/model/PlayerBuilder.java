package model;

import java.util.*;
import java.util.function.Supplier;

/**
 * Created by Cristiano on 07/06/16.
 */
public class PlayerBuilder {

	private final int min = 1;
	private final int max = 10;
	private Map<Colors, Supplier<Ant>> types = new HashMap<>();
	private Random random = new Random();
	private List<Ant> ants = new ArrayList<>();
	private Colors[] chooser = {Colors.BLUE, Colors.BLACK, Colors.GREEN};

	public PlayerBuilder() {
		int amountAnts = random.nextInt(max - min + 1) + min;

		types.put(Colors.BLUE, AntBlue::new);
		types.put(Colors.BLACK, AntBlack::new);
		types.put(Colors.GREEN, AntGreen::new);

		for (int i = 0; i < amountAnts; i++) {
			ants.add(types.get(chooser[random.nextInt(3)]).get());
		}
	}

	public List<Ant> build() {
		return new ArrayList<>(ants);
	}

}
