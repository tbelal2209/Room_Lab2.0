package Rooms;

import Game.Runner;
import People.Person;

public class TrapRoom extends Room {
	public TrapRoom(int x, int y) {
		super(x, y);

	}

	/**
	 * Triggers the game ending conditions.
	 * @param x the Person entering
	 */
	@Override
	public void enterRoom(Person x) {

		if (occupant == x) {
			x.setxLoc(this.xLoc);
			x.setyLoc(this.yLoc);
			System.out.println("Unfortunately you are in the trapped room so now you must start over again.");
			Runner.gameOn();
		}
	}
	

}
