import java.util.Scanner;

public class Worker {
	static ChessFigure[][] Field;
	static Scanner sc;
	static byte[] Coor;
	static boolean logs = false;
	static boolean turn;
	static boolean W;
	static boolean B;
	static boolean again = true;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		Coor = new byte[4];
		while (again) {
			MakeField();
			ShowField();
			while (true) {
				if (readInputData())
					if (Field[Coor[0]][Coor[1]].CanMove(Coor[2], Coor[3], turn)) {
						if (logs) {
							System.out.println(Field[Coor[0]][Coor[1]].getClass());
							System.out.println("Yes");
						}
						Field[Coor[2]][Coor[3]] = Field[Coor[0]][Coor[1]];
						Field[Coor[2]][Coor[3]].Move(Coor[2], Coor[3]);
						Field[Coor[0]][Coor[1]] = new EmptyFigure(Coor[0], Coor[1]);
						turn = !turn;

					} else {
						if (logs) {
							System.out.println(Field[Coor[0]][Coor[1]].getClass());
							System.out.println("No");
						}
					}
				if (!END())
					if (W) {
						System.out.println("White Win");
						break;
					} else {
						System.out.println("Black Win");
						break;
					}
				else
					ShowField();
			}
			System.out.println();
			System.out.println("Do you would like again?");
			System.out.println("(true/false)");
			again=sc.nextBoolean();
		}
	}

	static void MakeField() {
		turn = true;
		Field = new ChessFigure[8][8];
		for (byte i = 0; i < 8; i++)
			for (byte j = 0; j < 8; j++)
				Field[i][j] = new EmptyFigure(i, j);
		for (byte i = 0; i < 8; i++) {
			Field[i][6] = new FigurePawn(i, (byte) 6, false);
			Field[i][1] = new FigurePawn(i, (byte) 1, true);
		}
		Field[0][0] = new FigureRook((byte) 0, (byte) 0, true);
		Field[7][0] = new FigureRook((byte) 7, (byte) 0, true);
		Field[0][7] = new FigureRook((byte) 0, (byte) 7, false);
		Field[7][7] = new FigureRook((byte) 7, (byte) 7, false);

		Field[1][0] = new FigureKnight((byte) 1, (byte) 0, true);
		Field[6][0] = new FigureKnight((byte) 6, (byte) 0, true);
		Field[1][7] = new FigureKnight((byte) 1, (byte) 7, false);
		Field[6][7] = new FigureKnight((byte) 6, (byte) 7, false);

		Field[2][0] = new FigureBishop((byte) 2, (byte) 0, true);
		Field[5][0] = new FigureBishop((byte) 5, (byte) 0, true);
		Field[2][7] = new FigureBishop((byte) 2, (byte) 7, false);
		Field[5][7] = new FigureBishop((byte) 5, (byte) 7, false);

		Field[4][0] = new FigureKing((byte) 4, (byte) 0, true);
		Field[3][0] = new FigureQueen((byte) 3, (byte) 0, true);
		Field[4][7] = new FigureKing((byte) 4, (byte) 7, false);
		Field[3][7] = new FigureQueen((byte) 3, (byte) 7, false);

	}

	static void ShowField() {
		for (byte i = 7; i > -1; i--) {
			System.out.print((i + 1) + "-");
			for (byte j = 0; j < 8; j++)
				System.out.print("[" + Field[j][i].toString() + "]");
			System.out.println();
		}
		System.out.println("   A  B   C  D  E   F  G  H");
	}

	static boolean readInputData() {
		boolean flag = true;
		String input = sc.nextLine().toLowerCase();
		if (input.length() == 5) {
			Coor[0] = (byte) (input.charAt(0) - 'a');// from X
			Coor[1] = (byte) (input.charAt(1) - '1');// from Y
			Coor[2] = (byte) (input.charAt(3) - 'a');// to X
			Coor[3] = (byte) (input.charAt(4) - '1');// to Y
			for (byte i = 0; i < Coor.length; i++)
				if (Coor[i] < 0 || Coor[i] > 7)
					flag = false;
			if (logs) {
				System.out.println(input);
				for (byte i = 0; i < Coor.length; i++)
					System.out.print(Coor[i] + "; ");
			}
			return flag;
		}
		return false;

	}

	static boolean END() {
		W=false;
		B=false;
		for (byte i = 7; i > -1; i--)
			for (byte j = 0; j < 8; j++) {
				if (Field[i][j].getLabel()=='\u2654')
					W=true;
				if (Field[i][j].getLabel()=='\u265A')
					B=true;	
			}
		return W&B;
	}

}
