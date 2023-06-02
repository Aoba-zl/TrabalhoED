package controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
}
	