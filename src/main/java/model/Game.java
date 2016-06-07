package model;

/**
 * Created by Cristiano on 07/06/16.
 */
public class Game {

	public static void main(String[] ants) throws InterruptedException {
		System.out.println("Attention, ants climbing in your pants.... :o) \n20 boards rounds...");
		Thread.sleep(2000);
		Board tabuleiro = new Board(new Dimension(8, 8), new PlayerBuilder().build());
		for (int i = 0; i < 20; i++) {
			tabuleiro.move();
		}
		System.out.println("Bye Bye !!!");
	}

}
