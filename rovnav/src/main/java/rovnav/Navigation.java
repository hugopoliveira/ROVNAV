package rovnav;

import static rovnav.Direction.*;

/**
 * Prerrogativas assumidas.
 * 
 * Não há obstáculos para movimentação
 * Qualquer comando de movimentação acima da suprfície (Z > 0) será ignorado.
 */
public class Navigation {

	private Coordinate actualPosition = new Coordinate(0, 0, 0, NORTE);

	public Coordinate newPosition(String command) {

		resolve(command);

		return actualPosition;
	}

	private Coordinate resolve(String command) {
		if (command == null || command.length() == 0) {
			return actualPosition;
		}

		char mov = command.charAt(0);
		resolve(mov);

		return resolve(command.substring(1));
	}

	private void resolve(char mov) {
		if (mov == 'L') {
			rotateLeft();
		} else if (mov == 'R') {
			rotateRight();
		} else if (mov == 'U') {
			moveUp();
		} else if (mov == 'D') {
			moveDown();
		} else if (mov == 'M') {
			move();
		}
	}

	private void move() {
		switch (actualPosition.getDirection()) {
		case NORTE:
		case SUL:
			moveAxisY();
			break;
		case LESTE:
		case OESTE:
			moveAxisX();
			break;
		}
	}

	private void moveAxisY() {
		actualPosition.setY(actualPosition.getY() + actualPosition.getDirection().getOrientation());
	}

	private void moveAxisX() {
		actualPosition.setX(actualPosition.getX() + actualPosition.getDirection().getOrientation());
	}

	private void moveDown() {
		actualPosition.setZ(actualPosition.getZ() - 1);
	}

	private void moveUp() {
		//Ignora movimentação para cima quando na superfície
		if (actualPosition.getZ() == 0) {
			return;
		}
		
		actualPosition.setZ(actualPosition.getZ() + 1);
	}

	private void rotateRight() {
		switch (actualPosition.getDirection()) {
		case NORTE:
			actualPosition.setDirection(LESTE);
			break;
		case SUL:
			actualPosition.setDirection(OESTE);
			break;
		case LESTE:
			actualPosition.setDirection(SUL);
			break;
		case OESTE:
			actualPosition.setDirection(NORTE);
			break;
		}
	}

	private void rotateLeft() {
		switch (actualPosition.getDirection()) {
		case NORTE:
			actualPosition.setDirection(OESTE);
			break;
		case SUL:
			actualPosition.setDirection(LESTE);
			break;
		case LESTE:
			actualPosition.setDirection(NORTE);
			break;
		case OESTE:
			actualPosition.setDirection(SUL);
			break;
		}
	}
}