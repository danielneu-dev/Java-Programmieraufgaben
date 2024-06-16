public class spielfeld_plus {
	private String[][] spiel;

	public spielfeld_plus(int x) {
		if (x % 2 != 0 && x > 0) {
			spiel = new String[x][x];
		} else {
			System.out.println("ungültige Eingabe");
		}
		initialisiereSpielfeld();
	}

	public void initialisiereSpielfeld() {
		for (int i = 0; i < spiel.length; i++) {
			for (int j = 0; j < spiel.length; j++) {
				spiel[i][j] = "  ";
			}
		}
	}

	public void druckeSpielfeld() {
		for (int i = 0; i < spiel.length; i++) {
			System.out.print("  |  " + (i + 1));
		}
		System.out.print("  |\n");
		for (int i = 0; i < spiel.length; i++) {
			System.out.print("--+---");
		}
		System.out.print("--+\n");

		for (int i = 0; i < spiel.length; i++) {
			System.out.print(i + 1 + " |  ");
			for (int j = 0; j < spiel.length; j++) {
				System.out.print(spiel[i][j] + " |  ");
			}
			System.out.println();
			for (int x = 0; x < spiel.length; x++) {
				System.out.print("--+---");
			}
			System.out.print("--+\n");
		}
	}

	public void setzeSpielstein(spieler_plus sp, int w, int x, int y) {
		if (spiel[x - 1][y - 1] == "  " || spiel[x - 1][y - 1].charAt(1) - 48 < w) {
			if (w == 0 && sp.getZ0() < 2) {
				spiel[x - 1][y - 1] = sp.getKennung() + w;
				sp.setZ0();
			}
			if (w == 1 && sp.getZ1() < 2) {
				spiel[x - 1][y - 1] = sp.getKennung() + w;
				sp.setZ1();
			}
			if (w == 2 && sp.getZ2() < 2) {
				spiel[x - 1][y - 1] = sp.getKennung() + w;
				sp.setZ2();
			}
		}
	}

	public void testeSieg(spieler_plus spieler) {
		for (int i = 0; i < spiel.length; i++) {
			if (spiel[i][0].charAt(0) == spieler.getKennung().charAt(0)) {
				boolean test = true;
				for (int j = 0; j < spiel.length; j++) {
					if (spiel[i][j].charAt(0) == spieler.getKennung().charAt(0)) {

					} else {
						test = false;
					}
				}
				if (test == true) {
					System.out.println("\nSpieler mit der Kennung " + spieler.getKennung() + " hat gewonnen!");
					System.exit(0);
				}
			}
		}

		for (int i = 0; i < spiel.length; i++) {
			if (spiel[0][i].charAt(0) == spieler.getKennung().charAt(0)) {
				boolean test = true;
				for (int j = 0; j < spiel.length; j++) {
					if (spiel[j][i].charAt(0) == spieler.getKennung().charAt(0)) {

					} else {
						test = false;
					}
				}
				if (test == true) {
					System.out.println("\nSpieler mit der Kennung " + spieler.getKennung() + " hat gewonnen!");
					System.exit(0);
				}
			}
		}

		if (spiel[0][0].charAt(0) == spieler.getKennung().charAt(0)) {
			boolean test = true;
			for (int i = 0; i < spiel.length; i++) {
				if (spiel[i][i].charAt(0) == spieler.getKennung().charAt(0)) {

				} else {
					test = false;
				}
			}
			if (test == true) {
				System.out.println("\nSpieler mit der Kennung " + spieler.getKennung() + " hat gewonnen!");
				System.exit(0);
			}
		}

		if (spiel[spiel.length - 1][0].charAt(0) == spieler.getKennung().charAt(0)) {
			boolean test = true;
			for (int i = 0; i < spiel.length; i++) {
				if (spiel[(spiel.length - 1) - i][0 + i].charAt(0) == spieler.getKennung().charAt(0)) {

				} else {
					test = false;
				}
			}
			if (test == true) {
				System.out.println("\nSpieler mit der Kennung " + spieler.getKennung() + " hat gewonnen!");
				System.exit(0);
			}
		}
	}

}