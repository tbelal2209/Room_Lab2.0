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
       if (validMove>10) {
            System.out.println("You found the Treasure room! You earned five points because of " + validMove + " attempts.");
            Runner.gameOff();
        }
        else {
           System.out.println("You found the Treasure room! Congrats You earned ten points because of " + validMove + " attempts.");
           Runner.gameOff();
       }

    }
}

