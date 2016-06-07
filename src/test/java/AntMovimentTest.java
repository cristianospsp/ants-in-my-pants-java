import model.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Cristiano on 07/06/16.
 */
public class AntMovimentTest {

	@Test
	public void deveAndarAleatoreamenteFormigaAzul() {
		Board board = new Board(new Dimension(5, 5));
		Ant ant = new AntBlue();
		Ant ant2 = new AntBlue();
		board.addGrains(10);
		board.addAntOnBoard(ant);
		board.addAntOnBoard(ant2);
		board.show();

		for (int i = 0; i < 10; i++) {
			ant.walk(board);
			ant2.walk(board);
			board.show();
		}

	}

	@Test
	public void deveAndarAleatoreamenteFormigaAzulEFormigaVerde() {
		Board board = new Board(new Dimension(5, 5));
		Ant blue = new AntBlue();
		Ant green = new AntGreen();

		board.addGrains(8);
		board.addAntOnBoard(blue);
		board.addAntOnBoard(green);
		board.show();

		for (int i = 0; i < 10; i++) {
			blue.walk(board);
			green.walk(board);
		}

	}


	@Test
	public void deveAndarComRegraFormigaPreta() {
		Board board = new Board(new Dimension(5, 5));
		Ant black = new AntBlack();
		board.addAntOnBoard(black);
		board.show();

		for (int i = 0; i < 10; i++) {
			black.walk(board);
		}

	}


	@Test
	public void deveAndarComTresTiposDeFormigaECom25Graos() {
		Board board = new Board(new Dimension(10, 10));
		board.addGrains(25);
		Ant blue = new AntBlue();
		Ant green = new AntGreen();
		Ant black = new AntBlack();
		Ant blue2 = new AntBlue();
		Ant green2 = new AntGreen();
		Ant black2 = new AntBlack();
		board.addAntOnBoard(blue);
		board.addAntOnBoard(green);
		board.addAntOnBoard(black);
		board.addAntOnBoard(blue2);
		board.addAntOnBoard(green2);
		board.addAntOnBoard(black2);
		board.show();

		List<Ant> ants = Arrays.asList(blue, blue2, black, black2, green, green2);

		for (int i = 0; i < 5; i++) {
			ants.forEach(f -> f.walk(board));
		}

	}

}
