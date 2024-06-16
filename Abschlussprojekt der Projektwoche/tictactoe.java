import java.util.Scanner;

public class tictactoe {
	public static void main(String[] args) {
		spieler_plus sp1 = new spieler_plus("x");
		spieler_plus sp2 = new spieler_plus("o");
		spielfeld_plus spiel = new spielfeld_plus(3);
		menu(spiel, sp1, sp2);
	}

	public static void menu(spielfeld_plus spiel, spieler_plus sp1, spieler_plus sp2) {
		Scanner sc = new Scanner(System.in);
		int wert = 0;
		int zeile = 0;
		int spalte = 0;
		do {
			spiel.druckeSpielfeld();
			spiel.testeSieg(sp2);
			System.out.print("Spieler mit der Kennung " + sp1.getKennung() + "\nWert(0/1/2): ");
			wert = sc.nextInt();
			System.out.print("Zeile: ");
			zeile = sc.nextInt();
			System.out.print("Spalte: ");
			spalte = sc.nextInt();
			spiel.setzeSpielstein(sp1, wert, zeile, spalte);
			System.out.println();
			spiel.druckeSpielfeld();
			spiel.testeSieg(sp1);
			System.out.print("Spieler mit der Kennung " + sp2.getKennung() + "\nWert(0/1/2): ");
			wert = sc.nextInt();
			System.out.print("Zeile: ");
			zeile = sc.nextInt();
			System.out.print("Spalte: ");
			spalte = sc.nextInt();
			spiel.setzeSpielstein(sp2, wert, zeile, spalte);
			System.out.println();
		} while (1 != 0);
	}
}