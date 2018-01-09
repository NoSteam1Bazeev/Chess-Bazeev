
public abstract class ChessFigure {
	private byte coordinate_x;
	private byte coordinate_y;
	private boolean isActive;
	private boolean color;
	private char label;

	boolean CanMove(byte to_x, byte to_y, boolean turn) {
		return true;
	}

	void Move(byte to_x, byte to_y) {
	}

	@Override
	public String toString() {

		if (isActive && (label > '\u2653' && label < '\u2660'))
			return String.valueOf(label);
		else
			return " ";
	}

	public char getLabel() {
		return label;
	}

	public void setLabel(char label) {
		this.label = label;
	}

	public byte getCoordinate_x() {
		return coordinate_x;
	}

	public void setCoordinate_x(byte coordinate_x) {
		this.coordinate_x = coordinate_x;
	}

	public byte getCoordinate_y() {
		return coordinate_y;
	}

	public void setCoordinate_y(byte coordinate_y) {
		this.coordinate_y = coordinate_y;
	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean getColor() {
		return color;
	}

	public void setColor(boolean color) {
		this.color = color;
	}

}
