package Esercizio1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
	static Logger log = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		ExampleRunnable r1 = new ExampleRunnable("*");
		ExampleRunnable r2 = new ExampleRunnable("#");

		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);

		t1.setName("THREAD 1");
		t2.setName("THREAD 2");

		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();
	}

}
