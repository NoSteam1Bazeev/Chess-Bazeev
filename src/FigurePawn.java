
public class FigurePawn extends ChessFigure {
	byte count = 0;

	public FigurePawn(byte x, byte y, boolean color) {
		this.setCoordinate_x(x);
		this.setCoordinate_y(y);
		this.setIsActive(true);
		this.setColor(color);
		if (color)
			this.setLabel('\u2659');
		else
			this.setLabel('\u265F');
	}

	@Override
	boolean CanMove(byte to_x, byte to_y, boolean turn) {
		byte x = this.getCoordinate_x();
		byte y = this.getCoordinate_y();
		if (turn)
			if (this.getColor()) {
				// white
				if ((x - to_x) == 0)
					if ((count == 0 && (to_y - y) == 2) || (to_y - y) == 1) {
						if (!Worker.Field[to_x][to_y].getIsActive()) {
							count++;
							return true;
						}
					}
				if ((to_y - y) == 1 && ((x - to_x) == 1 || (to_x - x) == 1)
						&& (Worker.Field[to_x][to_y].getColor() != this.getColor())) {
					count++;
					return true;
				}
			} else
				;
		else if (!this.getColor()) {
			// black
			if ((x - to_x) == 0)
				if ((count == 0 && (y - to_y) == 2) || (y - to_y) == 1) {
					if (!Worker.Field[to_x][to_y].getIsActive()) {
						count++;
						return true;
					}
				}
			if ((y - to_y) == 1 && ((x - to_x) == 1 || (to_x - x) == 1)
					&& (Worker.Field[to_x][to_y].getColor() != this.getColor())) {
				count++;
				return true;
			}
		}

		return false;
	}

	@Override
	void Move(byte to_x, byte to_y) {
		this.setCoordinate_x(to_x);
		this.setCoordinate_y(to_y);
	}

}
