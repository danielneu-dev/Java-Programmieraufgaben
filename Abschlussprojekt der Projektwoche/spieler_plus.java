public class spieler_plus {
	private String kennung;
	private int z0;
	private int z1;
	private int z2;

	public spieler_plus(String kennung) {
		this.kennung = kennung;
		z0 = 0;
		z1 = 0;
		z2 = 0;
	}

	public String getKennung() {
		return kennung;
	}

	public void setZ0() {
		++z0;
	}

	public void setZ1() {
		++z1;
	}

	public void setZ2() {
		++z2;
	}

	public int getZ0() {
		return z0;
	}

	public int getZ1() {
		return z1;
	}

	public int getZ2() {
		return z2;
	}
}