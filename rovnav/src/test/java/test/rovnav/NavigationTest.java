package test.rovnav;

import static rovnav.Direction.*;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import rovnav.Coordinate;
import rovnav.Navigation;

public class NavigationTest {

	@Test
	public void exampleTest1() {
		Navigation nav = new Navigation();
		Coordinate coordinate = nav.newPosition("LMRDDMMUU");
		assertEquals(coordinate, new Coordinate(-1, 2, 0, NORTE));
	}

	@Test
	public void exampleTest2() {
		Navigation nav = new Navigation();
		Coordinate coordinate = nav.newPosition("RMMLMMMDDLL");
		assertEquals(coordinate, new Coordinate(2, 3, -2, SUL));
	}

	@Test
	public void testRotationLeftCommand() {
		Navigation nav = new Navigation();
		Coordinate coordinate = nav.newPosition("L");
		assertEquals(coordinate, new Coordinate(0, 0, 0, OESTE));
		coordinate = nav.newPosition("L");
		assertEquals(coordinate, new Coordinate(0, 0, 0, SUL));
		coordinate = nav.newPosition("L");
		assertEquals(coordinate, new Coordinate(0, 0, 0, LESTE));
		coordinate = nav.newPosition("L");
		assertEquals(coordinate, new Coordinate(0, 0, 0, NORTE));
	}

	@Test
	public void testRotationRightCommand() {
		Navigation nav = new Navigation();
		Coordinate coordinate = nav.newPosition("R");
		assertEquals(coordinate, new Coordinate(0, 0, 0, LESTE));
		coordinate = nav.newPosition("R");
		assertEquals(coordinate, new Coordinate(0, 0, 0, SUL));
		coordinate = nav.newPosition("R");
		assertEquals(coordinate, new Coordinate(0, 0, 0, OESTE));
		coordinate = nav.newPosition("R");
		assertEquals(coordinate, new Coordinate(0, 0, 0, NORTE));
	}

	@Test
	public void testMoveAxisZ() {
		Navigation nav = new Navigation();
		Coordinate coordinate = nav.newPosition("U");
		assertEquals(coordinate, new Coordinate(0, 0, 0, NORTE));
		coordinate = nav.newPosition("D");
		assertEquals(coordinate, new Coordinate(0, 0, -1, NORTE));
		coordinate = nav.newPosition("D");
		assertEquals(coordinate, new Coordinate(0, 0, -2, NORTE));
		coordinate = nav.newPosition("U");
		assertEquals(coordinate, new Coordinate(0, 0, -1, NORTE));
	}

	@Test
	public void testMoves() {
		Navigation nav = new Navigation();
		Coordinate coordinate = nav.newPosition("M");
		assertEquals(coordinate, new Coordinate(0, 1, 0, NORTE));
		coordinate = nav.newPosition("LM");
		assertEquals(coordinate, new Coordinate(-1, 1, 0, OESTE));
		coordinate = nav.newPosition("RM");
		assertEquals(coordinate, new Coordinate(-1, 2, 0, NORTE));
		coordinate = nav.newPosition("RMM");
		assertEquals(coordinate, new Coordinate(1, 2, 0, LESTE));
		coordinate = nav.newPosition("RM");
		assertEquals(coordinate, new Coordinate(1, 1, 0, SUL));
		coordinate = nav.newPosition("RM");
		assertEquals(coordinate, new Coordinate(0, 1, 0, OESTE));
		coordinate = nav.newPosition("LM");
		assertEquals(coordinate, new Coordinate(0, 0, 0, SUL));
	}
}