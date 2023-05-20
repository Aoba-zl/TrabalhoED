package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import PilhaObject.PilhaObject;

public class Buscar {
	public PilhaObject buscarAluno(PilhaObject pilhaAluno) throws IOException {
		File arq = new File("C:\\TEMP", "Aluno.csv");
		if (arq.exists() && arq.isFile()) {
			FileInputStream abreFluxoArq = new FileInputStream(arq);
			InputStreamReader leitorFluxo = new InputStreamReader(abreFluxoArq);
			BufferedReader buffer = new BufferedReader(leitorFluxo);
			String linha = buffer.readLine();
			while (linha != null) {
				String[] vetLinha = linha.split(";");
				pilhaAluno.push(vetLinha[0]);
				pilhaAluno.push(vetLinha[1]);
				linha = buffer.readLine();
			}
			buffer.close();
			leitorFluxo.close();
			abreFluxoArq.close();
		}
		return pilhaAluno;
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