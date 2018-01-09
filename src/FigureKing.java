
public class FigureKing extends ChessFigure {

	public FigureKing(byte x, byte y, boolean color) {
		this.setCoordinate_x(x);
		this.setCoordinate_y(y);
		this.setIsActive(true);
		this.setColor(color);
		if (color)
			this.setLabel('\u2654');
		else
			this.setLabel('\u265A');
	}
	@Override
	boolean CanMove(byte to_x, byte to_y, boolean turn) {
		byte x = this.getCoordinate_x();
		byte y = this.getCoordinate_y();
		boolean color = this.getColor();
		if (((Worker.Field[to_x][to_y].getColor() != color) || (!Worker.Field[to_x][to_y].getIsActive()))
				&& (turn == color) && (((y-to_y==0)||(y-to_y==1)||(to_y-y==1)&&(y-to_y==0)||(x-to_y==1)||(to_y-y==1))))
			return true;
		return false;
	}
	@Override
	void Move(byte to_x, byte to_y) {
		this.setCoordinate_x(to_x);
		this.setCoordinate_y(to_y);
	}
}
