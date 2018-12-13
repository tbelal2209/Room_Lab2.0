package Game;



import People.Person;
import Rooms.Room;
import Rooms.TreasureRoom;
import Rooms.TrapRoom;
	
import java.util.Scanner;

public class Runner {
	public static int validMove;
	private static boolean gameOn = true;

	public static void main(String[] args) {
		Room[][] building = new Room[5][5];

		//Fill the building with normal rooms
		for (int x = 0; x < building.length; x++) {
			for (int y = 0; y < building[x].length; y++) {
				building[x][y] = new Room(x, y);
			}
		}

		Scanner input = new Scanner(System.in);
		System.out.println("Hi! What is your name?");
		String name = input.nextLine();
		//Create a random winning room.
		int x = (int) (Math.random() * building.length);
		int y = (int) (Math.random() * building.length);
		building[x][y] = new TrapRoom(x, y);


		int z = (int) (Math.random() * building.length);
		int a = (int) (Math.random() * building.length);
		building[z][a] = new TreasureRoom(z, a);


		//Setup player 1 and the input scanner
		Person player1 = new Person("FirstName", "FamilyName", 0, 0);
		building[0][0].enterRoom(player1);
		Scanner in = new Scanner(System.in);

		while (gameOn) {
			System.out.println("Hello " + name + " Where would you like to move? (Choose N, S, E, W)");
			String move = in.nextLine();
			if (validMove(move, player1, building)) {
				System.out.println("Your coordinates: row = " + player1.getxLoc() + " col = " + player1.getyLoc() + " attempt " + (validMove+1));
				validMove++;
			} else {
				System.out.println("Please choose a valid move.");
			}


		}
		in.close();
	}

	/**
	 * Checks that the movement chosen is within the valid game map.
	 *
	 * @param move the move chosen
	 * @param p    person moving
	 * @param map  the 2D array of rooms
	 * @return
	 */
	public static boolean validMove(String move, Person p, Room[][] map) {
		move = move.toLowerCase().trim();
		switch (move) {
			case "n":
				if (p.getxLoc() > 0) {
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc() - 1][p.getyLoc()].enterRoom(p);
					System.out.println("You have moved one unit north");
					return true;
				} else {
					System.out.println("You are allowed to move South");
					return false;
				}
			case "e":
				if (p.getyLoc() < map[p.getyLoc()].length - 1) {
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc()][p.getyLoc() + 1].enterRoom(p);
					System.out.println("You have moved one unit east");
					return true;
				} else {
					System.out.println("You are allowed to move west");
					return false;
				}

			case "s":
				if (p.getxLoc() < map.length - 1) {
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc() + 1][p.getyLoc()].enterRoom(p);
					System.out.println("You have moved one unit south");
					return true;
				} else {
					System.out.println("You are allowed to move north");
					return false;
				}

			case "w":
				if (p.getyLoc() > 0) {
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc()][p.getyLoc() - 1].enterRoom(p);
					System.out.println("You have moved one unit west");
					return true;
				} else {
					System.out.println("You are allowed to move east");
					return false;
				}
			default:
				break;

		}
		return true;
	}

	public static void gameOff() {
		gameOn = false;
	}

	public static void gameOn() {
		gameOn = true;
	}
}

