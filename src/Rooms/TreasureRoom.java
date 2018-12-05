package Rooms;

import Game.Runner;
import People.Person;

public class TreasureRoom extends Room {
    public TreasureRoom(int z, int a) {
        super(z, a);

    }

    /**
     * Triggers the game ending conditions.
     * @param x the Person entering
     */
    @Override
    public void enterRoom(Person x) {

        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        System.out.println("You found the Treasure room! Ten points for Gryffindor.");
        Runner.gameOff();
    }
}
