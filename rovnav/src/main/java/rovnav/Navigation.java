package rovnav;

import static rovnav.Direction.*;

public class Navigation {
	
	private static Coordinate actualPosition = new Coordinate(0, 0, 0, NORTE);
	
	public Coordinate newPosition(final String command) {
		
		//TODO Resolver comando
		return actualPosition; 
	}
}