package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import PilhaObject.PilhaObject;
import controllerFila.FilaObject;
import listaObject.ListaObject;
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
					filaGrupo.insert("0"+(grupo+1)+""+vetLinha[2]);
				}else {
					filaGrupo.insert((grupo+1)+""+vetLinha[2]);
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
	public String[] buscarGrupoExpecifico (int codGrupo, int codArquivo) throws IOException {
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
					return vetLinha;
				}
				linha = buffer.readLine();
			}
			buffer.close();
			leitorFluxo.close();
			abreFluxoArq.close();
		}
		return null;
	}
	public void buscarOrientacaoMenosUma (int iD, ListaObject Lista) throws IOException {
		
		String iDArq = Integer.toString(iD);
		File arq = new File("C:\\TEMP", "Orientaçoes");
		if (arq.exists() && arq.isFile()) {
			FileInputStream abreFluxoArq = new FileInputStream(arq);
			InputStreamReader leitorFluxo = new InputStreamReader(abreFluxoArq);
			BufferedReader buffer = new BufferedReader(leitorFluxo);
			String linha = buffer.readLine();
			while (linha != null) {
				String[] vetLinha = linha.split(";");
				if (!vetLinha[1].contains(iDArq)) {
					Lista.addFirst(vetLinha);
				}
				linha = buffer.readLine();
			}
			buffer.close();
			leitorFluxo.close();
			abreFluxoArq.close();
		}
				
		
	}
	public void buscarOrientacaoExpecifica (String iD, ListaObject Lista) throws IOException {
		File arq = new File("C:\\TEMP", "Orientaçoes.csv");
		if (arq.exists() && arq.isFile()) {
			FileInputStream abreFluxoArq = new FileInputStream(arq);
			InputStreamReader leitorFluxo = new InputStreamReader(abreFluxoArq);
			BufferedReader buffer = new BufferedReader(leitorFluxo);
			String linha = buffer.readLine();
			while (linha != null) {
				String[] vetLinha = linha.split(";");
				if (vetLinha[1].contains(iD)) {
					Lista.addFirst(linha);
				}
				linha = buffer.readLine();
			}
			buffer.close();
			leitorFluxo.close();
			abreFluxoArq.close();
		}
	}
}
