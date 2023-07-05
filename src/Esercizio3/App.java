package Esercizio3;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
	static Logger log = LoggerFactory.getLogger(App.class);
	private List<Presenza> elencoPresenze;

	public App() {
		elencoPresenze = new ArrayList<>();
	}

	public void addpresenza(String nomeDipendente, int giorniPresenza) {
		Presenza ps = new Presenza(nomeDipendente, giorniPresenza);
		elencoPresenze.add(ps);
	}

	public void savePs(String nameFile) {
		StringBuilder sb = new StringBuilder();
		for (Presenza presenza : elencoPresenze) {
			sb.append(presenza.getNomeDipendente()).append("@").append(presenza.getGiorniPresenza()).append("#");
		}

		try {
			FileUtils.writeStringToFile(new File(nameFile), sb.toString(), StandardCharsets.UTF_8);
			log.info("Presenze salvate su disco");
		} catch (IOException e) {
			log.error("Errore durante il salvataggio delle presenze su disco");
		}
	}

	public void readSv(String nameFile) {
		try {
			String fileContent = FileUtils.readFileToString(new File(nameFile), StandardCharsets.UTF_8);
			String[] presenzeArray = fileContent.split("#");

			for (String str : presenzeArray) {
				String[] pst = str.split("@");
				if (pst.length == 2) {
					String nomeDipendente = pst[0];
					int giorniPresenza = Integer.parseInt(pst[1]);
					Presenza presenza = new Presenza(nomeDipendente, giorniPresenza);
					elencoPresenze.add(presenza);
				}
			}
			log.info("Presenze lette da disco");
		} catch (IOException e) {
			log.error("Errore durante la lettura delle presenze da disco.");
		}
	}

	public void printElencoPs() {
		for (Presenza presenza : elencoPresenze) {
			log.info(presenza.getNomeDipendente() + ": " + presenza.getGiorniPresenza() + " giorni");
		}
	}

	public static void main(String[] args) {
		App pst = new App();

		pst.addpresenza("Artem", 5);
		pst.addpresenza("Giulio", 33);
		pst.addpresenza("Marco", 49);

		pst.elencoPresenze.clear();

		pst.readSv("presenze.txt");

		pst.printElencoPs();
	}
}
