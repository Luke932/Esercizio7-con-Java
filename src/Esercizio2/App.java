package Esercizio2;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
	static Logger log = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		int[] array = generateRandomArray(3000, 1, 100);

		Somma[] threads = new Somma[3];
		Thread[] threadObjects = new Thread[3];

		for (int i = 0; i < 3; i++) {
			threads[i] = new Somma(array, i * 1000, (i + 1) * 1000);
			threadObjects[i] = new Thread(threads[i]);
			threadObjects[i].start();
		}

		try {
			for (int i = 0; i < 3; i++) {
				threadObjects[i].join();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		int sommaTotale = 0;
		for (int i = 0; i < 3; i++) {
			sommaTotale += threads[i].getSommaParziale();
		}

		log.info("Somma totale: " + sommaTotale);
	}

	public static int[] generateRandomArray(int size, int min, int max) {
		Random random = new Random();
		int[] array = new int[size];

		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(max - min + 1) + min;
		}

		return array;
	}
}
