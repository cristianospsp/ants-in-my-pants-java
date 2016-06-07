import model.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.function.Supplier;

/**
 * Created by Cristiano on 07/06/16.
 */
public class PlayerBuilderTest {

	@Test
	public void mustCreateAntsRandomly() {
		List<Ant> ants = new PlayerBuilder().build();
		Assert.assertTrue(ants.size() > 0);
	}

}
