package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

import PilhaObject.PilhaObject;

public class Buscar {
	public void buscarAluno() {
		
	}
	public void buscarSubarea(PilhaObject pilhaSub) throws Exception {
		File arq = new File("C:\\TEMP", "Subarea.csv");
		if (arq.exists() && arq.isFile()) {
			FileInputStream abreFluxoArq = new FileInputStream(arq);
			InputStreamReader leitorFluxo = new InputStreamReader(abreFluxoArq);
			BufferedReader buffer = new BufferedReader(leitorFluxo);
			String linha = buffer.readLine();
			while (linha != null) {
				String[] vetLinha = linha.split(";");
				pilhaSub.push(vetLinha[0]);
				linha = buffer.readLine();
			}
			buffer.close();
			leitorFluxo.close();
			abreFluxoArq.close();
		}
	}
}
