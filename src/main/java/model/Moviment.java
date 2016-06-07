package model;

import java.util.Objects;

/**
 * Created by Cristiano on 07/06/16.
 */
public abstract class Moviment {

	public String myName;

	public Moviment() {
		defineName();
	}

	public abstract void go(Board tabuleiro, Ant formiga);

	public abstract Position getNextFiled(Board tabuleiro, Ant formiga);

	public abstract void defineName();

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Moviment)) return false;
		Moviment movimento = (Moviment) o;
		return Objects.equals(myName, movimento.myName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(myName);
	}
}
