import model.Ant;
import model.AntBlack;
import model.AntBlue;
import model.AntGreen;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.function.Supplier;

/**
 * Created by Cristiano on 07/06/16.
 */
public class PlayerBuilderTest {

	@Test
	public void deveCriarFormigasAleatoremante() {
		Random random = new Random();
		int amountAnts = random.nextInt(10);
		List<Ant> ants = new ArrayList<>();

		Map<String, Supplier<Ant>> types = new HashMap<>();

		types.put("Blue", () -> new AntBlue());
		types.put("Black", () -> new AntBlack());
		types.put("Green", () -> new AntGreen());

		String[] array_ = {"Blue", "Black", "Green"};


		for (int i=0; i<amountAnts; i++) {
			ants.add(types.get(array_[random.nextInt(2)]).get());
		}

		Assert.assertEquals(amountAnts, ants.size());

	}

}
