package Esercizio3;

public class Presenza {
	private String nomeDipendente;
	private int giorniPresenza;

	public Presenza(String nomeDipendente, int giorniPresenza) {
		this.nomeDipendente = nomeDipendente;
		this.giorniPresenza = giorniPresenza;
	}

	public int getGiorniPresenza() {
		return giorniPresenza;
	}

	public String getNomeDipendente() {
		return nomeDipendente;
	}
}
