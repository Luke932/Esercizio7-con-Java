package Esercizio2;

public class Somma implements Runnable {
	private int[] array;
	private int start;
	private int end;
	private int sommaParziale;

	public Somma(int[] array, int start, int end) {
		this.array = array;
		this.start = start;
		this.end = end;
	}

	@Override
	public void run() {
		sommaParziale = 0;
		for (int i = start; i < end; i++) {
			sommaParziale += array[i];
		}
	}

	public int getSommaParziale() {
		return sommaParziale;
	}
}
