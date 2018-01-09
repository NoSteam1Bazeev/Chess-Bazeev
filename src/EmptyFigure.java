public class EmptyFigure extends ChessFigure {
	public EmptyFigure(byte x, byte y) {
		this.setCoordinate_x(x);
		this.setCoordinate_y(y);
		this.setIsActive(false);
	}

	@Override
	boolean CanMove(byte to_x, byte to_y,boolean turn) {
		return false;
	}
}
