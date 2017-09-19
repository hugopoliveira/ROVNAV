package test.rovnav;

import static rovnav.Direction.*;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import rovnav.Coordinate;
import rovnav.Navigation;

public class NavigationTest {

	@Test
	public void exampleTest1 () {
		Navigation nav = new Navigation();
		Coordinate coordinate = nav.newPosition("LMRDDMMUU");
		assertEquals(coordinate, new Coordinate(-1, 2, 0, NORTE));
	}

	@Test
	public void exampleTest2 () {
		Navigation nav = new Navigation();
		Coordinate coordinate = nav.newPosition("RMMLMMMDDLL");
		assertEquals(coordinate, new Coordinate(2, 3, -2, SUL));
	}

}
