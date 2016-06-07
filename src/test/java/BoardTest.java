import model.AntBlue;
import model.Board;
import model.Dimension;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Cristiano on 07/06/16.
 */
public class BoardTest {

	Board board = new Board(new Dimension(5, 5));

	@Test
	public void mustShowEmptyBoard() {
		board.show();
		Assert.assertEquals(5, board.getDimension().getLines());
		Assert.assertEquals(5, board.getDimension().getColumns());
	}

	@Test
	public void mustShowBoardWithSize5By5With4GrainsSpreadRandomly() {
		board.addGrains(4);
		board.show();
		Assert.assertEquals(4, board.getAmountGrains());
	}

	@Test
	public void mustShowBoardWithSize5By5With1AntSpreadRandomly() {
		board.addAntOnBoard(new AntBlue());
		board.show();
		Assert.assertEquals(1, board.getQtdPlayers());
	}

	@Test
	public void mustShowBoardWithSize5By5With1AntAnd4GrainsSpreadRandomly() {
		board.addGrains(4);
		board.addAntOnBoard(new AntBlue());
		board.show();
		Assert.assertEquals(4, board.getAmountGrains());
		Assert.assertEquals(1, board.getQtdPlayers());
	}

}
