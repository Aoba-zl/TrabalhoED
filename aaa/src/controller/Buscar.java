package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import PilhaObject.PilhaObject;
import controllerFila.FilaObject;
import modelObject.ISetObject;

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
	public void buscarSubarea(FilaObject filaSub) throws Exception {
		File arq = new File("C:\\TEMP", "Subarea.csv");
		if (arq.exists() && arq.isFile()) {
			FileInputStream abreFluxoArq = new FileInputStream(arq);
			InputStreamReader leitorFluxo = new InputStreamReader(abreFluxoArq);
			BufferedReader buffer = new BufferedReader(leitorFluxo);
			String linha = buffer.readLine();
			while (linha != null) {
				String[] vetLinha = linha.split(";");
				filaSub.insert(vetLinha[1]);
				linha = buffer.readLine();
			}
			buffer.close();
			leitorFluxo.close();
			abreFluxoArq.close();
		}
	}
	public ISetObject buscarArea(ISetObject setArea) throws Exception {
		File arq = new File("C:\\TEMP", "Subarea.csv");
		if (arq.exists() && arq.isFile()) {
			FileInputStream abreFluxoArq = new FileInputStream(arq);
			InputStreamReader leitorFluxo = new InputStreamReader(abreFluxoArq);
			BufferedReader buffer = new BufferedReader(leitorFluxo);
			String linha = buffer.readLine();
			while (linha != null) {
				String[	] vetLinha = linha.split(";");
				setArea.addFirst(vetLinha[0]);
				linha = buffer.readLine();
			}
			buffer.close();
			leitorFluxo.close();
			abreFluxoArq.close();
			return setArea;
		}
		return null;
	}
	public void buscarGrupo (int grupo, FilaObject filaGrupo) throws IOException {
		String nome = (grupo+1)+"Grupo.csv";
		File arq = new File("C:\\TEMP", nome);
		if (arq.exists() && arq.isFile()) {
			FileInputStream abreFluxoArq = new FileInputStream(arq);
			InputStreamReader leitorFluxo = new InputStreamReader(abreFluxoArq);
			BufferedReader buffer = new BufferedReader(leitorFluxo);
			String linha = buffer.readLine();
			while (linha != null) {
				String[] vetLinha = linha.split(";");
				if (grupo < 10) {
					filaGrupo.insert("0"+grupo+""+vetLinha[2]);
				}else {
					filaGrupo.insert(grupo+""+vetLinha[2]);
				}
				filaGrupo.insert(vetLinha[0]);
				filaGrupo.insert(vetLinha[1]);
				filaGrupo.insert(vetLinha[3]);
				linha = buffer.readLine();
			}
			buffer.close();
			leitorFluxo.close();
			abreFluxoArq.close();
		}
	}
	public void buscarGrupoExpecifico (int codGrupo, int codArquivo) throws IOException {
		String nome = codArquivo+"Grupo.csv";
		File arq = new File("C:\\TEMP", nome);
		if (arq.exists() && arq.isFile()) {
			FileInputStream abreFluxoArq = new FileInputStream(arq);
			InputStreamReader leitorFluxo = new InputStreamReader(abreFluxoArq);
			BufferedReader buffer = new BufferedReader(leitorFluxo);
			String linha = buffer.readLine();
			while (linha != null) {
				String[] vetLinha = linha.split(";");
				if(Integer.parseInt(vetLinha[2]) == codGrupo) {
					
				}
				linha = buffer.readLine();
			}
			buffer.close();
			leitorFluxo.close();
			abreFluxoArq.close();
		}
	}
}
