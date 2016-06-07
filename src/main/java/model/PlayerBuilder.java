package model;

import java.util.*;
import java.util.function.Supplier;

/**
 * Created by Cristiano on 07/06/16.
 */
public class PlayerBuilder {

	private final int min = 1;
	private final int max = 10;
	private Map<String, Supplier<Ant>> tipos = new HashMap<>();
	private Random random = new Random();
	private List<Ant> ants = new ArrayList<>();

	public PlayerBuilder() {
		int quantidadeFormigas = random.nextInt(max - min + 1) + min;
		tipos.put("Blue", () -> new AntBlue());
		tipos.put("Black", () -> new AntBlack());
		tipos.put("Green", () -> new AntGreen());

		String[] colors = {"Blue", "Black", "Green"};

		for (int i = 0; i < quantidadeFormigas; i++) {
			ants.add(tipos.get(colors[random.nextInt(3)]).get());
		}
	}

	public List<Ant> build() {
		return new ArrayList<>(ants);
	}

}
