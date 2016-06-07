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
	public void deveExibirOTabuleiroSemVazio() {
		board.show();
		Assert.assertEquals(5, board.getDimension().getLines());
		Assert.assertEquals(5, board.getDimension().getColumns());
	}

	@Test
	public void deveExibirOTabuleiroDeTamanho5Por5Com4GraosEspalhadosAleatoreamente() {
		board.addGrains(4);
		board.show();
		Assert.assertEquals(4, board.getAmountGrains());
	}

	@Test
	public void deveExibirOTabuleiroDeTamanho5Por5Com1FormigaAdicionadaAleatoreamente() {
		board.addAntOnBoard(new AntBlue());
		board.show();
		Assert.assertEquals(1, board.getQtdPlayers());
	}

	@Test
	public void deveExibirOTabuleiroDeTamanho5Por5Com1FormigasE4GraosAdicionadosAleatoreamente() {
		board.addGrains(4);
		board.addAntOnBoard(new AntBlue());
		board.show();
		Assert.assertEquals(4, board.getAmountGrains());
		Assert.assertEquals(1, board.getQtdPlayers());
	}

}
