
public class FigureRook extends ChessFigure {

	public FigureRook(byte x, byte y, boolean color) {
		this.setCoordinate_x(x);
		this.setCoordinate_y(y);
		this.setIsActive(true);
		this.setColor(color);
		if (color)
			this.setLabel('\u2656');
		else
			this.setLabel('\u265C');
	}
	@Override
	boolean CanMove(byte to_x, byte to_y, boolean turn) {
		byte x = this.getCoordinate_x();
		byte y = this.getCoordinate_y();
		boolean color = this.getColor();
		if (((Worker.Field[to_x][to_y].getColor() != color) || (!Worker.Field[to_x][to_y].getIsActive()))
				&& (turn == color) && ((x-to_x==0)||(y-to_y==0))) {
			if (x-to_x>0)
				for (int i=1;i<x-to_x;i++)
					if (Worker.Field[x-i][y].getIsActive())
						return false;
			if (x-to_x<0)
				for (int i=1;i<x-to_x;i++)
					if (Worker.Field[x+i][y].getIsActive())
						return false;
			if (y-to_y>0)
				for (int i=1;i<y-to_y;i++)
					if (Worker.Field[x][y-i].getIsActive())
						return false;
			if (y-to_y>0)
				for (int i=1;i<y-to_y;i++)
					if (Worker.Field[x][y+i].getIsActive())
						return false;
			return true;			
		}
		return false;
	}
	@Override
	void Move(byte to_x, byte to_y) {
		this.setCoordinate_x(to_x);
		this.setCoordinate_y(to_y);
	}
}
