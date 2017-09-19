package rovnav;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Direction {
	NORTE(1),SUL(-1),LESTE(1),OESTE(-1);
	
	private int orientation;
}