package Esercizio1;

public class ExampleRunnable implements Runnable {
	private String simbolo;

	public ExampleRunnable(String simbolo) {
		this.simbolo = simbolo;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i += 1) {
			App.log.info(simbolo);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
