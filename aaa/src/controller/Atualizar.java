package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import PilhaObject.PilhaObject;
import controllerFila.FilaObject;
import modelObject.ISetObject;

public class Atualizar {
	public void atualizarAluno (PilhaObject pilhaPrincipal) throws Exception {
		File nome = new File("C:\\TEMP", "Aluno.csv");
		// Criando novo arquivo
		File arqNovo = new File("C:\\TEMP", "TempFile.csv");
		boolean existe = false;
		if (arqNovo.exists()) {
			existe = true;
		}
		FileWriter abreArq = new FileWriter(arqNovo, existe);
		PrintWriter escreveArq = new PrintWriter(abreArq);
		if (arqNovo.exists() && arqNovo.isFile()) {
			//Passando informação
			while(!pilhaPrincipal.isEmpty()) {
				String rA = pilhaPrincipal.pop().toString();
				String nomeAluno = pilhaPrincipal.pop().toString();
				escreveArq.write(nomeAluno+";"+rA+"\r\n");
			}
			
			escreveArq.flush();
			escreveArq.close();
			abreArq.close();
		}
		//Deletando
		nome.delete();
		//Renomeando
		arqNovo.renameTo(nome);
		
	}
	public void excluiSubarea (FilaObject filaSub) throws Exception {
		File nome = new File("C:\\TEMP", "Subarea.csv");
		// Criando novo arquivo
		File arqNovo = new File("C:\\TEMP", "TempFile.csv");
		boolean existe = false;
		if (arqNovo.exists()) {
			existe = true;
		}
		FileWriter abreArq = new FileWriter(arqNovo, existe);
		PrintWriter escreveArq = new PrintWriter(abreArq);
		if (arqNovo.exists() && arqNovo.isFile()) {
			//Passando informação 
			while(!filaSub.filaVazia()) {
				String subarea = filaSub.remove().toString();
				escreveArq.write(subarea+"\r\n");
			}
			
			escreveArq.flush();
			escreveArq.close();
			abreArq.close();
		}
		//Deletando
		nome.delete();
		//Renomeando
		arqNovo.renameTo(nome);
	}
	public void atualizarGrupos (String grupo, String iDAntigo, String iDNovo) throws Exception {
		//Carregando arquivo antigo
		int idArqAntigo = Integer.parseInt(iDAntigo.charAt(0)+""+iDAntigo.charAt(1));
		File nome = new File("C:\\TEMP",idArqAntigo+"Grupo.csv");
		String idGrupoAntigo ="";
		
		if (iDAntigo.length() == 3) {
			idGrupoAntigo = iDAntigo.charAt(2)+"";
		}else {
			idGrupoAntigo = iDAntigo.charAt(2)+""+iDAntigo.charAt(3);
		}
		File arqNovo = new File("C:\\TEMP", "TempFile.csv");
		boolean existe = false;
		if (arqNovo.exists()) {
			existe = true;
		}
		FileWriter abreArq = new FileWriter(arqNovo, existe);
		PrintWriter escreveArq = new PrintWriter(abreArq);
		if (arqNovo.exists() && arqNovo.isFile()) {
				FileInputStream abreFluxoArq = new FileInputStream(nome);
				InputStreamReader leitorFluxo = new InputStreamReader(abreFluxoArq);
				BufferedReader buffer = new BufferedReader(leitorFluxo);
				String linha = buffer.readLine();
				while (linha != null) {
					String[] vetLinha = linha.split(";");
					if (vetLinha[2].contains(idGrupoAntigo) && iDAntigo.contains(iDNovo) ) {
						escreveArq.write(grupo+"\r\n");
					}else if (vetLinha[2].contains(idGrupoAntigo) && !iDAntigo.contains(iDNovo) ){
						escreveArq.write("."+"\r\n");
					}else {
						escreveArq.write(linha+"\r\n");
					}
					linha = buffer.readLine();
				}
				buffer.close();
				leitorFluxo.close();
				abreFluxoArq.close();
				
			escreveArq.flush();
			escreveArq.close();
			abreArq.close();
		}
		nome.delete();
		arqNovo.renameTo(nome);
	}
	
}
	