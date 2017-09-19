package rovnav;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@Data
@EqualsAndHashCode
public class Coordinate {
	private int x;
	private int y;
	private int z;
	private Direction direction;
	
	@Override
	public String toString() {
		return x + " " + y + " " + z + " " + direction;
	}
}