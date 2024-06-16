public class Projektaufgabe {

//	Methode erstelleFeld, erstellt ein zweidimensionales char-Array der Länge n und füllt diese mit den Initialen DN aus
	public static char[][] erstelleFeld(int n) {
//		Erstelle nur dann ein Array, falls n > 10 ist
		if (n > 10) {
			int m;
//			Falls n < 17 ist, behandle die Initialen wie ab Größe 16, damit die Initialen eine bessere Auflösung haben
			if (n < 17) {
				m = 16;
			} else {
				m = n;
			}
//			int x dient für das Erstellen der Schräge der Initiale N
			int x = m / (m / 3);
//			Erstelle ein zweidimensionales char-Array der Länge n
			char[][] array = new char[n][n];
//			Fülle das gesamte Array mit Leerzeichen
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					array[i][j] = ' ';
				}
			}
//			Erstelle die Geraden der Initialen DN
			for (int i = 0; i < m / 2; i++) {
				array[i][0] = '+';
				array[i][m / 4 + 1] = '+';
				array[i][m / 4 + m / 4] = '+';
			}
//			Erstelle den Bogen der Initiale D
			for (int i = 0; i < m / 4 - 2; i++) {
				array[0][i] = '+';
				array[m / 2 - 1][i] = '+';
			}
			array[1][m / 4 - 2] = '+';
			array[m / 2 - 2][m / 4 - 2] = '+';
			for (int i = m / 4 - 1; i < m / 4; i++) {
				for (int j = 2; j < m / 2 - 2; j++) {
					array[j][i] = '+';
				}
			}
//			Erstelle die Schräge der Initiale N
			for (int i = m / 4 + 2; i < m / 4 + m / 4; i++) {
				array[x][i] = '+';
				x++;
			}
//			Gebe das Array mit den Initialen zurück
			return array;
		} else {
			System.out.println("Ungültige Größe des Arrays.");
			return null;
		}
	}

//	Methode gameOfLife bekommt ein 2-dim char-Array und t (Anzahl der Durchläufe) übergeben, spielt Conway's Game of Life durch und gibt das Ergebnis aus
	public static char[][] gameOfLife(char[][] feld, int t) {
		if (feld == null) {
			return null;
		} else {
//			Erstelle ein 2-dim char-Array der Länge des übergebenen Arrays
			char[][] workspace = new char[feld.length][feld.length];
//			Sobald der letzte Durchlauf ansteht, gebe das Ergebnis aus
			if (t <= 0) {
				return feld;
			}
//			Spiele das Game of Life, speichere die Ergebnisse der Methoden neueZelle und anzahlLeben3x3 im workspace-Array ab
			if (t > 0) {
				for (int i = 0; i < workspace.length; i++) {
					for (int j = 0; j < workspace.length; j++) {
						workspace[i][j] = neueZelle(feld, i, j, anzahlLeben3x3(feld, i, j));
					}
				}
			}
//			rufe dieselbe Methode erneut auf, nur diesmal mit den Ergebnissen des Durchlaufs und senke t um 1
			return gameOfLife(workspace, --t);
		}
	}

//	Methode gameOfLife2 bekommt ein 2-dim char-Array und t (Anzahl der Durchläufe) übergeben, spielt das modifizierte Game of Life durch und gibt das Ergebnis aus
	public static char[][] gameOfLife2(char[][] feld, int t) {
		if (feld == null) {
			return null;
		} else {
//			Erstelle ein 2-dim char-Array der Länge des übergebenen Arrays
			char[][] workspace = new char[feld.length][feld.length];
//			Sobald der letzte Durchlauf ansteht, gebe das Ergebnis aus
			if (t <= 0) {
				return feld;
			}
//			Spiele das modifizierte Game of Life, speichere die Ergebnisse der Methoden neueZelle2 und anzahlLeben5x5 im workspace-Array ab
			if (t > 0) {
				for (int i = 0; i < workspace.length; i++) {
					for (int j = 0; j < workspace.length; j++) {
						workspace[i][j] = neueZelle2(feld, i, j, anzahlLeben5x5(feld, i, j));
					}
				}
			}
//			rufe dieselbe Methode erneut auf, nur diesmal mit den Ergebnissen des Durchlaufs und senke t um 1
			return gameOfLife2(workspace, --t);
		}
	}

//	Methode anzahlLeben3x3 zählt die Anzahl der lebenden Nachbarn der ausgewählten Zelle
	public static int anzahlLeben3x3(char[][] array, int x, int y) {
		int z = 0;
		if (array == null) {
			return 0;
		} else {
//			Gehe die Zeile [x-1] durch, unter der Bedingung, dass es nicht out-of-bounds ist: gehe von [y-1] bis [y+1]
			if (x > 0) {
				if (y > 0) {
					if (array[x - 1][y - 1] == '+') {
						z++;
					}
				}
				if (array[x - 1][y] == '+') {
					z++;
				}
				if (y + 1 < array.length) {
					if (array[x - 1][y + 1] == '+') {
						z++;
					}
				}
			}
//			Gehe die Zeile [x] durch, gehe von [y-1] bis [y+1], lasse dabei [y] aus
			if (y > 0) {
				if (array[x][y - 1] == '+') {
					z++;
				}
			}
			if (y + 1 < array.length) {
				if (array[x][y + 1] == '+') {
					z++;
				}
			}
//			Gehe die Zeile [x+1] durch, unter der Bedingung, dass es nicht out-of-bounds ist: gehe von [y-1] bis [y+1]
			if (x + 1 < array.length) {
				if (y > 0) {
					if (array[x + 1][y - 1] == '+') {
						z++;
					}
				}
				if (array[x + 1][y] == '+') {
					z++;
				}
				if (y + 1 < array.length) {
					if (array[x + 1][y + 1] == '+') {
						z++;
					}
				}
			}
		}
//		Gebe die Anzahl der lebenden Nachbarn (Zellen mit Inhalt '+') aus
		return z;
	}

//	Methode anzahlLeben5x5 zählt die Anzahl der lebenden Nachbarn der ausgewählten Zelle 
	public static int anzahlLeben5x5(char[][] array, int x, int y) {
		int z = 0;
		if (array == null) {
			return 0;
		} else {
//			Gehe die Zeile [x-2] durch, unter der Bedingung, dass es nicht out-of-bounds ist: gehe von [y-2] bis [y+2]
			if (x > 1) {
				if (y > 1) {
					if (array[x - 2][y - 2] == '+') {
						z++;
					}
				}
				if (y > 0) {
					if (array[x - 2][y - 1] == '+') {
						z++;
					}
				}
				if (array[x - 2][y] == '+') {
					z++;
				}
				if (y + 1 < array.length) {
					if (array[x - 2][y + 1] == '+') {
						z++;
					}
				}
				if (y + 2 < array.length) {
					if (array[x - 2][y + 2] == '+') {
						z++;
					}
				}
			}
//			Gehe die Zeile [x-1] durch, unter der Bedingung, dass es nicht out-of-bounds ist: gehe von [y-2] bis [y+2]
			if (x > 0) {
				if (y > 1) {
					if (array[x - 1][y - 2] == '+') {
						z++;
					}
				}
				if (y > 0) {
					if (array[x - 1][y - 1] == '+') {
						z++;
					}
				}
				if (array[x - 1][y] == '+') {
					z++;
				}
				if (y + 1 < array.length) {
					if (array[x - 1][y + 1] == '+') {
						z++;
					}
				}
				if (y + 2 < array.length) {
					if (array[x - 1][y + 2] == '+') {
						z++;
					}
				}
			}
//			Gehe die Zeile [x] durch, gehe von [y-2] bis [y+2], lasse dabei [y] aus
			if (y > 1) {
				if (array[x][y - 2] == '+') {
					z++;
				}
			}
			if (y > 0) {
				if (array[x][y - 1] == '+') {
					z++;
				}
			}
			if (y + 1 < array.length) {
				if (array[x][y + 1] == '+') {
					z++;
				}
			}
			if (y + 2 < array.length) {
				if (array[x][y + 2] == '+') {
					z++;
				}
			}
//			Gehe die Zeile [x+1] durch, unter der Bedingung, dass es nicht out-of-bounds ist: gehe von [y-2] bis [y+2]
			if (x + 1 < array.length) {
				if (y > 1) {
					if (array[x + 1][y - 2] == '+') {
						z++;
					}
				}
				if (y > 0) {
					if (array[x + 1][y - 1] == '+') {
						z++;
					}
				}
				if (array[x + 1][y] == '+') {
					z++;
				}
				if (y + 1 < array.length) {
					if (array[x + 1][y + 1] == '+') {
						z++;
					}
				}
				if (y + 2 < array.length) {
					if (array[x + 1][y + 2] == '+') {
						z++;
					}
				}
			}
//			Gehe die Zeile [x+2] durch, unter der Bedingung, dass es nicht out-of-bounds ist: gehe von [y-2] bis [y+2]
			if (x + 2 < array.length) {
				if (y > 1) {
					if (array[x + 2][y - 2] == '+') {
						z++;
					}
				}
				if (y > 0) {
					if (array[x + 2][y - 1] == '+') {
						z++;
					}
				}
				if (array[x + 2][y] == '+') {
					z++;
				}
				if (y + 1 < array.length) {
					if (array[x + 2][y + 1] == '+') {
						z++;
					}
				}
				if (y + 2 < array.length) {
					if (array[x + 2][y + 2] == '+') {
						z++;
					}
				}
			}
		}
//		Gebe die Anzahl der lebenden Nachbarn (Zellen mit Inhalt '+') aus
		return z;
	}

//	Methode neueZelle gibt die Veränderung der Zelle anhand Conway's Game of Life Regeln zurück
	public static char neueZelle(char[][] array, int x, int y, int z) {
		if (array == null) {
			return ' ';
		} else {
//			Wenn eine tote Zelle genau drei lebende Nachbarn hat, wird daraus eine lebende Zelle
			if (array[x][y] == '-') {
				if (z == 3) {
					return '+';
				} else {
					return '-';
				}
			}
//			Wenn eine lebende Zelle genau zwei oder drei lebende Nachbarn hat, bleibt diese am Leben
			if (array[x][y] == '+') {
				if (z != 2 && z != 3) {
					return '-';
				} else {
					return '+';
				}
			}
//			Eine leere Zelle wird wie eine tote Zelle behandelt, also tritt nur Veränderung auf, falls sie genau drei lebende Nachbarn hat
			if (array[x][y] == ' ') {
				if (z == 3) {
					return '+';
				} else {
					return ' ';
				}
			}
		}
		return ' ';
	}

//	Methode neueZelle2 gibt die Veränderung der Zelle anhand der modifizierten Game of Life Regeln zurück
	public static char neueZelle2(char[][] array, int x, int y, int z) {
		if (array == null) {
			return ' ';
		} else {
//			Zähle die Gesamtanzahl aller lebenden Zellen
			int n = 0;
			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array.length; j++) {
					if (array[i][j] == '+') {
						n++;
					}
				}
			}
//			Falls genau 4 oder 12 lebende Zellen existieren, sterben diese
			if (n == 4 || n == 12) {
				for (int i = 0; i < array.length; i++) {
					for (int j = 0; j < array.length; j++) {
						if (array[i][j] == '+') {
							array[i][j] = '-';
						}
					}
				}
			}
//			Falls eine tote Zelle genau vier lebende Nachbarn hat, wird daraus eine lebende Zelle
			if (array[x][y] == '-') {
				if (z == 4) {
					return '+';
				} else {
					return '-';
				}
			}
//			Falls eine lebende Zelle genau fünf lebende Nachbarn hat, überlebt diese
			if (array[x][y] == '+') {
				if (z != 5) {
					return '-';
				} else {
					return '+';
				}
			}
//			Falls eine leere Zelle genau einen lebenden Nachbarn hat, wird diese zur lebenden Zelle
			if (array[x][y] == ' ') {
				if (z == 1) {
					return '+';
				} else {
					return ' ';
				}
			}
		}
		return ' ';
	}

//	Methode druckeFeld, gibt das gesamte Array auf der Konsole aus: diente als Testverfahren
	public static void druckeFeld(char[][] array) {
		if (array != null) {
			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array.length; j++) {
					System.out.print(array[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

//	Methode zaehleFeld, gibt die Gesamtanzahl lebender Zellen des Arrays auf der Konsole aus: diente als Testverfahren
	public static void zaehleFeld(char[][] array) {
		if (array != null) {
			int z = 0;
			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array.length; j++) {
					if (array[i][j] == '+') {
						z++;
					}
				}
			}
			System.out.println(array.length + ":	" + z);
		}
	}

}
